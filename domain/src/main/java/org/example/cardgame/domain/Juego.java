package org.example.cardgame.domain;

import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Map;

public class Juego extends AggregateEvent<JuegoId> {
    protected Map<JugadorId, Jugador> jugadores;
    public Juego(JuegoId id, JugadoresFactory factory) {
        super(id);
        appendChange(new JuegoCreado(id)).apply();
        factory.jugadores()
                .forEach((jugadorId, jugador) ->
                        appendChange(new JugadorAgregado(jugadorId, jugador.alias(), jugador.mazo())).apply());

        subscribe(new JuegoEventChange(this));
    }

    /*
    TODO: agregar el metodo estatico
    TODO: crear comportamientos
     */
}
