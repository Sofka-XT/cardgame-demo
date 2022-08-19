package org.example.cardgame.domain;

import co.com.sofka.domain.generic.Entity;
import org.example.cardgame.domain.values.Carta;
import org.example.cardgame.domain.values.JugadorId;
import org.example.cardgame.domain.values.Mazo;

import java.util.Objects;

public class Jugador extends Entity<JugadorId> {
    private final String email;
    private Mazo mazo;

    public Jugador(JugadorId entityId, String email, Mazo mazo) {
        super(entityId);
        this.email = Objects.requireNonNull(email);
        this.mazo = Objects.requireNonNull(mazo);
        if (mazo.value().cantidad() <= 0) {
            throw new IllegalArgumentException("El mazo debe contener cartas ");
        }
    }

    public void agregarCartaAMazo(Carta carta) {
        mazo = mazo.nuevaCarta(carta);
    }

    public void quitarCartaDeMazo(Carta carta) {
        mazo = mazo.retirarCarta(carta);
    }

    public String alias() {
        return email;
    }

    public Mazo mazo() {
        return mazo;
    }
}
