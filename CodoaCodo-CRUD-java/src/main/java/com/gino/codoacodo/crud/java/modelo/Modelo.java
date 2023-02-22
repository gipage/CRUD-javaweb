/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gino.codoacodo.crud.java.modelo;

import java.util.List;

/**
 *
 * @author ginop
 */
public interface Modelo {
    /**
     * Devuelve una lista de Jugadores existentes
     * @return 
     */
    public List<Jugador> getJugadores();
    
    /**
     * Retorna un Jugador por ID
     * @param id el id del Jugador a retornar
     * @return El Jugador encontrado por ID o null si no existe
     */
    public Jugador getJugador(int id);
    
    /**
     * Agrega un Jugador al modelo
     * @param jugador El Jugador a agregar
     * @return La cantidad de registros modificados
     */
    public int addJugador(Jugador jugador);
    
    /**
     * Modifica un Jugador del modelo
     * @param jugador El Jugador que contiene los datos para modificar
     * @return La cantidad de registros modificados
     */
    public int updateJugador(Jugador jugador);
    
    /**
     * Borra un Jugador por ID
     * @param id el id del Jugador a borrar
     * @return La cantidad de registros modificados
     */
    public int removeJugador(int id);
}

    

