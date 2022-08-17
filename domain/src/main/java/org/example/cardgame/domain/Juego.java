package org.example.cardgame.domain;

import co.com.sofka.domain.generic.AggregateEvent;

import java.util.function.BiConsumer;

public class Juego extends AggregateEvent<JuegoId> {

    public Juego(JuegoId id, JugadoresFactory factory) {
        super(id);
        appendChange(new JuegoCreado(id)).apply();
        factory.jugadores()
                .forEach((jugadorId, jugador) ->
                        appendChange(new JugadorAgregado(jugadorId, jugador.alias(), jugador.mazo())).apply());
    }
    /*
    TODO: agregar el metodo estatico
    TODO: crear comportamientos
    TODO: crear el event change
     */
}
