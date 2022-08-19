package org.example.cardgame.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cardgame.domain.values.Carta;
import org.example.cardgame.domain.values.JugadorId;

import java.util.Set;

public class CartasAsignadasAJugador extends DomainEvent {
    private final JugadorId ganadorId;
    private final Integer puntos;
    private final Set<Carta> cartasApuesta;

    public CartasAsignadasAJugador(JugadorId ganadorId, Integer puntos, Set<Carta> cartasApuesta) {
        super("cargame.cartasasignadasajugador");
        this.ganadorId = ganadorId;
        this.puntos = puntos;
        this.cartasApuesta = cartasApuesta;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public JugadorId getGanadorId() {
        return ganadorId;
    }

    public Set<Carta> getCartasApuesta() {
        return cartasApuesta;
    }
}
