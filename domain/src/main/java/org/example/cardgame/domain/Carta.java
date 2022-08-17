package org.example.cardgame.domain;

import co.com.sofka.domain.generic.ValueObject;

public class Carta implements ValueObject<Carta.Props> {
    private final Integer poder;
    private final String cartaMaestraId;

    public Carta(Integer poder, String cartaMaestraId, Boolean estaHabilitada) {
        this.poder = poder;
        this.cartaMaestraId = cartaMaestraId;
        this.estaHabilitada = estaHabilitada;
    }

    private final Boolean estaHabilitada;

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer poder() {
                return poder;
            }

            @Override
            public String cartaMaestraId() {
                return cartaMaestraId;
            }

            @Override
            public Boolean estaHabilitada() {
                return estaHabilitada;
            }
        };
    }

    public interface Props {
        Integer poder();
        String cartaMaestraId();
        Boolean estaHabilitada();
    }
}
