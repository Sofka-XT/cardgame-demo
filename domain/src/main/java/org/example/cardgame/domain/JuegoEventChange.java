package org.example.cardgame.domain;

import co.com.sofka.domain.generic.EventChange;

import java.util.HashMap;

public class JuegoEventChange extends EventChange {
    public JuegoEventChange(Juego juego) {
        apply((JuegoCreado event) -> {
            juego.jugadores = new HashMap<>();
        });

        apply((JugadorAgregado event) -> {
            var mazo = event.getMazo();
            var jugador =  new Jugador(
                    event.getJugadorId(),
                    event.getAlias()
            );
            jugador.agregarMazo(mazo);
            juego.jugadores.put(event.getJugadorId(),jugador);
        });
    }
}
