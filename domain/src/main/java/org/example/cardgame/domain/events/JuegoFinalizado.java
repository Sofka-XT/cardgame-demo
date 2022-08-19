package org.example.cardgame.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cardgame.domain.values.JugadorId;

public class JuegoFinalizado extends DomainEvent {
    private final JugadorId jugadorId;
    private final String alias;

    public JuegoFinalizado(JugadorId jugadorId, String alias) {
        super("cargame.juegofinalizado");
        this.jugadorId = jugadorId;
        this.alias = alias;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public String getAlias() {
        return alias;
    }
}
