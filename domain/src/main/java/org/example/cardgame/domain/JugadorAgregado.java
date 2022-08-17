package org.example.cardgame.domain;

import co.com.sofka.domain.generic.DomainEvent;

public class JugadorAgregado extends DomainEvent {
    private final JugadorId jugadorId;
    private final String alias;
    private final Mazo mazo;

    public JugadorAgregado(JugadorId jugadorId, String alias, Mazo mazo) {
        super("cardgame.jugadoragregado");

        this.jugadorId = jugadorId;
        this.alias = alias;
        this.mazo = mazo;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public String getAlias() {
        return alias;
    }
}
