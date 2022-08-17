package org.example.cardgame.domain;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Set;
import java.util.function.Predicate;

public class Mazo implements ValueObject<Set<Carta>> {
    private final Set<Carta> cartas;

    public Mazo(Set<Carta> cartas) {
        this.cartas = cartas;
    }

    public Mazo quitarCarta(String cartaId){
        cartas.removeIf(carta -> carta.value().cartaMaestraId().equals(cartaId));
        return new Mazo(cartas);
    }

    public Mazo agregarCarta(Carta carta){
        cartas.add(carta);
        return new Mazo(cartas);
    }

    @Override
    public Set<Carta> value() {
        return cartas;
    }
}
