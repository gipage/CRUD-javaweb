package com.gino.codoacodo.crud.java.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author ginop
 */
public class ModeloHC implements Modelo {
    private List<Jugador> jugadoresGuardados;

    public ModeloHC() {
        this.jugadoresGuardados = new ArrayList<>();
        crearJugadoresFake();
    }

    @Override
    public List<Jugador> getJugadores() {
        return new ArrayList(this.jugadoresGuardados); // Copia de la lista original
    }

    @Override
    public Jugador getJugador(int id) {
        int i = 0;
        while (i < this.jugadoresGuardados.size() && this.jugadoresGuardados.get(i).getId() != id) {
            i++;
        }
        if (i >= this.jugadoresGuardados.size()) {
            throw new RuntimeException("No se encontró jugador con ID " + id);
        }
        return this.jugadoresGuardados.get(i);
    }

    @Override
    public int addJugador(Jugador jugador) {
        this.jugadoresGuardados.add(jugador);
        return 0;
    }

    @Override
    public int updateJugador(Jugador a) {
        Jugador target = getJugador(a.getId());
        int idx = this.jugadoresGuardados.indexOf(target);
        this.jugadoresGuardados.set(idx, a);
        return 0;
    }

    @Override
    public int removeJugador(int id) {
        Jugador target = getJugador(id);
        this.jugadoresGuardados.remove(target);
        return 0;
    }
    
    private void crearJugadoresFake() { 
        try ( InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("carasFake.properties")) {
            Properties props = new Properties();
            props.load(is);
            this.jugadoresGuardados.add(new Jugador(1, "Lebron", "James", (float)2.06, "Alero",10, (String) props.get("HOMBRE_1")));
           
        } catch (IOException ex) {
            throw new RuntimeException("No se pudieron cargar las caras fake");
        }
    }
}
