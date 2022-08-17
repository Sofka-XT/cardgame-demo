package org.example.cardgame.domain;

import co.com.sofka.domain.generic.Identity;

public class JuegoId extends Identity {
    private JuegoId(String juegoId) {
        super(juegoId);
    }

    public static JuegoId of(String juegoId) {
        return new JuegoId(juegoId);
    }
}
