/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gino.codoacodo.crud.java.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ginop
 */
public class Conexion {

    private static Conexion instance = null;
    private  Connection connection = null;

    private Conexion() {
        String url = "jdbc:mysql://us-east.connect.psdb.cloud:3306/crud-java?autoReconnect=true&useSSL=false&serverTimezone\\=US/Eastern";
        String user = "dkbvfnlb2sicygs37eoa";
        String password = "pscale_pw_K35LR0aUdA4c1ViCzOL5jS0LbLnnP6eS9XFknBSdNll";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
