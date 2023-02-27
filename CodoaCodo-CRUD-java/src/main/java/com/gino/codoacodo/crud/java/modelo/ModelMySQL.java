/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gino.codoacodo.crud.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ginop
 */
public class ModelMySQL implements Modelo {

    private static final String GET_ALL_QUERY = "Select * from jugadores";

    @Override
    public List<Jugador> getJugadores() {
        List<Jugador> arraylistJugadores = new ArrayList<>();
        //try() cierra los recursos (interfaz auto cerreable)
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(GET_ALL_QUERY); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                arraylistJugadores.add(rstoJugador(rs));
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Error SQL", ex); //relanzo excepcion
        } catch (Exception ex) {
            throw new RuntimeException("Error al obtener listado de jugadores", ex);
        }

        return arraylistJugadores;
    }

    @Override
    public Jugador getJugador(int id) {
        Jugador jugador = null;
        try (
                Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT * FROM jugadores WHERE id = ?");) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                rs.next();
                jugador = rstoJugador(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jugador;
    }

    @Override
    public int addJugador(Jugador jugador) {
        return 0;
    }

    @Override
    public int updateJugador(Jugador jugador) {
        return 0;
    }

    @Override
    public int removeJugador(int id) {
        return 0;
    }

    private Jugador rstoJugador(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        Float estatura = rs.getFloat("estatura");
        String posicion = rs.getString("posicion");
        int dorsal = rs.getInt("dorsal");
        String fotoBase64 = rs.getString("fotoBase64");
        return new Jugador(id, nombre, apellido, estatura, posicion, dorsal, fotoBase64);
    }
}
