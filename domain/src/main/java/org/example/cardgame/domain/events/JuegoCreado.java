package org.example.cardgame.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cardgame.domain.values.JugadorId;

public class JuegoCreado extends DomainEvent {
    private final JugadorId jugadorPrincipal;

    public JuegoCreado(JugadorId jugadorPrincipal) {
        super("cargame.juegocreado");
        this.jugadorPrincipal = jugadorPrincipal;
    }

    public JugadorId getJugadorPrincipal() {
        return jugadorPrincipal;
    }
}
