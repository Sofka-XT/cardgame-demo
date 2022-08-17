package org.example.cardgame.domain;

import co.com.sofka.domain.generic.DomainEvent;

public class JuegoCreado extends DomainEvent {
    private final JuegoId id;

    public JuegoCreado(JuegoId id) {
        super("cardgame.juegocreado");
        this.id = id;
    }

    public JuegoId getId() {
        return id;
    }
}
