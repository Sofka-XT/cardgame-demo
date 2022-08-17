package org.example.cardgame.domain;

import java.util.HashMap;
import java.util.Map;

public class JugadoresFactory {
    private final Map<JugadorId, Jugador> jugadores = new HashMap<>();

    public void agregarJugador(JugadorId id, String alias, Mazo mazo){
        var jugador = new Jugador(id, alias);
        jugador.agregarMazo(mazo);
        jugadores.put(id, jugador);
    }

    protected Map<JugadorId, Jugador> jugadores() {
        return jugadores;
    }
}
