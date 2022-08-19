package org.example.cardgame.domain.values;

import co.com.sofka.domain.generic.Identity;

public class JugadorId extends Identity {

    public JugadorId(String value) {
        super(value);
    }

    public JugadorId() {

    }

    public static JugadorId of(String value) {
        return new JugadorId(value);
    }
}
