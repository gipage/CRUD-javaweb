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
@WebServlet(name = "AppServlet", urlPatterns={"/arma-tu-equipo"})
public class AppServlet extends HttpServlet {
    private static final String URI_LISTAR = "WEB-INF/pages/jugadores/listarJugadores.jsp";
    private Modelo model;
    
    @Override
    public void init() throws ServletException{
        this.model = new ModeloHC();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listaJugadores", model.getJugadores()); 
        req.getRequestDispatcher(URI_LISTAR).forward(req, resp);
    }
    
    
}
