package org.example.cardgame.domain;

import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Jugador extends Entity<JugadorId> {

    private final String alias;
    private Integer puntos;
    private Mazo mazo;

    public Jugador(JugadorId id, String alias) {
        super(id);
        this.alias = alias;
        puntos = 0;
    }

    public void agregarPuntos(Integer puntos){
        this.puntos = puntos + this.puntos;
    }

    public String alias() {
        return alias;
    }

    public void agregarMazo(Mazo mazo) {
        this.mazo = Objects.requireNonNull(mazo, "El mazo esta null");
    }
    public void quitarCartaAMazo(String cartaMaestraId){
        this.mazo = this.mazo.quitarCarta(cartaMaestraId);
    }
    public void agregarCartaAMazo(Carta carta){
        this.mazo = this.mazo.agregarCarta(carta);
    }

    public Mazo mazo() {
        return mazo;
    }


}
