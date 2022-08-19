package org.example.cardgame.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Set;

public class Ronda implements ValueObject<Ronda.Props> {
    private final Set<JugadorId> jugadores;
    private final Integer numero;
    private final Boolean estaIniciada;

    public Ronda(Integer numero, Set<JugadorId> jugadores) {
        this.jugadores = jugadores;
        this.numero = numero;
        this.estaIniciada = false;
    }

    private Ronda(Integer numero, Set<JugadorId> jugadores, Boolean estaIniciada) {
        this.jugadores = jugadores;
        this.numero = numero;
        this.estaIniciada = estaIniciada;
    }

    public Ronda iniciarRonda() {
        return new Ronda(this.numero, this.jugadores, true);
    }

    public Ronda terminarRonda() {
        return new Ronda(this.numero, this.jugadores, false);
    }

    public Ronda incrementarRonda(Set<JugadorId> jugadores) {
        System.out.println("nueva ronda");
        return new Ronda(this.numero + 1, jugadores, false);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Set<JugadorId> jugadores() {
                return jugadores;
            }

            @Override
            public Integer numero() {
                return numero;
            }

            @Override
            public Boolean estaIniciada() {
                return estaIniciada;
            }
        };
    }


    public interface Props {
        Set<JugadorId> jugadores();

        Integer numero();

        Boolean estaIniciada();
    }
}
