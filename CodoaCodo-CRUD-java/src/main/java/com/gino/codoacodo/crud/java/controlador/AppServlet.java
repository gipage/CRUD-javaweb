/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gino.codoacodo.crud.java.controlador;

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
    private Modelo model;

    @Override
    public void init() throws ServletException {
        this.model = new ModeloHC();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String laAccion = req.getParameter("accion");
        String idStr = req.getParameter("id");
        int id = (idStr == null ? -1 : Integer.parseInt(idStr));
        laAccion = (laAccion == null ? "" : laAccion);
        switch (laAccion) {
            case "remove":
                req.setAttribute("jugadorABorrar", model.getJugador(id));
                req.getRequestDispatcher(URI_BORRAR).forward(req, resp);                
                break;
            case "edit":
                break;
            case "add":
                break;
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
            case "remove":
                model.removeJugador(id);
                resp.sendRedirect(getServletContext().getContextPath() + "/arma-tu-equipo");
                break;
            case "edit":
                break;
            case "add":
                break;
            default: {
                req.setAttribute("listaJugadores", model.getJugadores());
                req.getRequestDispatcher(URI_LISTAR).forward(req, resp);
            }

        }

    }

}
