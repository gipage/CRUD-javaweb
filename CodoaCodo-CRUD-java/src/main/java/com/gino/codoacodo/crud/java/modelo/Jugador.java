/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gino.codoacodo.crud.java.modelo;

/**
 *
 * @author ginop
 */
public class Jugador {
    private int id;
    private String nombre;
    private String apellido;
    private float estatura;
    private String posicion;
    private int dorsal;
    private String foto;

    public Jugador() {
    }

    public Jugador(int id, String nombre, String apellido, float estatura, String posicion, int dorsal, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estatura = estatura;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
         if (foto == null || foto.trim().isEmpty()) {
            foto = "assets/no-face.jpg";
        }
        if (!foto.contains("no-face") || this.foto == null || this.foto.contains("no-face")) {
            this.foto = foto.trim();
        }
    }
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
}
