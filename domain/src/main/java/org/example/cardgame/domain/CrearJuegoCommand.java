package org.example.cardgame.domain;

import co.com.sofka.domain.generic.Command;

import java.util.Map;

public class CrearJuegoCommand extends Command {
    private String juegoId;
    private Map<String, String> jugadores;

    public void setJuegoId(String juegoId) {
        this.juegoId = juegoId;
    }

    public void setJugadores(Map<String, String> jugadores) {
        this.jugadores = jugadores;
    }

    public String getJuegoId() {
        return juegoId;
    }

    public Map<String, String> getJugadores() {
        return jugadores;
    }
}
