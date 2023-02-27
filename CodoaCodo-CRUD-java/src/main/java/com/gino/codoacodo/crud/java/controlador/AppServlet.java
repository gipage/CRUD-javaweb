/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gino.codoacodo.crud.java.controlador;

import com.gino.codoacodo.crud.java.modelo.Jugador;
import com.gino.codoacodo.crud.java.modelo.ModelMySQL;
import com.gino.codoacodo.crud.java.modelo.Modelo;
import com.gino.codoacodo.crud.java.modelo.ModeloHC;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author ginop
 */
@WebServlet(name = "AppServlet", urlPatterns = {"/arma-tu-equipo"})
public class AppServlet extends HttpServlet {

    private static final String URI_LISTAR = "WEB-INF/pages/jugadores/listarJugadores.jsp";
    private static final String URI_BORRAR = "WEB-INF/pages/jugadores/borrarJugador.jsp";
    private static final String URI_EDITAR = "WEB-INF/pages/jugadores/editarJugador.jsp";
    private Modelo model;

    @Override
    public void init() throws ServletException {
        this.model = new ModelMySQL();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String laAccion = req.getParameter("accion");
        String idStr = req.getParameter("id");
        int id = (idStr == null ? -1 : Integer.parseInt(idStr));
        laAccion = (laAccion == null ? "" : laAccion);
        switch (laAccion) {
            case "remove": {
                req.setAttribute("jugadorABorrar", model.getJugador(id));
                req.getRequestDispatcher(URI_BORRAR).forward(req, resp);
                break;
            }
            case "edit": {
                Jugador juga = model.getJugador(id);
                req.setAttribute("jugadorAEditar", juga);
                req.setAttribute("yaTieneFoto", !juga.getFoto().contains("no-face"));
                req.getRequestDispatcher(URI_EDITAR).forward(req, resp);
                break;
            }
            default: {
                req.setAttribute("listaJugadores", model.getJugadores());
                req.getRequestDispatcher(URI_LISTAR).forward(req, resp);
            }

        }

    }

    //POST: Cambios en el servidoooor!
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String laAccion = req.getParameter("accion");
        String idStr = req.getParameter("id");
        int id = (idStr == null ? -1 : Integer.parseInt(idStr));
        laAccion = (laAccion == null ? "" : laAccion);
        switch (laAccion) {
            case "delete": {
                model.removeJugador(id);
                break;
            }
            case "update": {
                Jugador jugador = model.getJugador(id);
                cargarJugador(jugador, req);
                model.updateJugador(jugador);
                break;
            }
            case "add": {
                Jugador jugador = new Jugador();
                cargarJugador(jugador, req);
                model.addJugador(jugador);
                break;
            }
            default: {
                req.setAttribute("listaJugadores", model.getJugadores());
                req.getRequestDispatcher(URI_LISTAR).forward(req, resp);
            }

        }
        resp.sendRedirect(getServletContext().getContextPath() + "/arma-tu-equipo");

    }

    private void cargarJugador(Jugador jugador, HttpServletRequest req) {
        jugador.setFoto(req.getParameter("fotoBase64"));
        jugador.setNombre(req.getParameter("nombre"));
        jugador.setApellido(req.getParameter("apellido"));
        jugador.setPosicion(req.getParameter("posicion"));
        jugador.setEstatura(Float.parseFloat(req.getParameter("estatura")));
        jugador.setDorsal(Integer.parseInt(req.getParameter("dorsal")));

    }
}
