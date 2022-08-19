package org.example.cardgame.domain;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.cardgame.domain.events.*;
import org.example.cardgame.domain.values.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Juego extends AggregateEvent<JuegoId> {
    protected Map<JugadorId, Jugador> jugadores;
    protected Tablero tablero;
    protected Jugador ganador;
    protected Ronda ronda;
    protected JugadorId jugadorPrincipal;

    public Juego(JuegoId id, JugadorId uid, JugadorFactory jugadorFactory) {
        super(id);
        appendChange(new JuegoCreado(uid)).apply();
        jugadorFactory.getJugadores()
                .forEach(jugador ->
                        appendChange(new JugadorAgregado(jugador.identity(), jugador.alias(), jugador.mazo()))
                );
        subscribe(new JuegoEventChange(this));
    }

    private Juego(JuegoId id) {
        super(id);
        subscribe(new JuegoEventChange(this));
    }

    public static Juego from(JuegoId juegoId, List<DomainEvent> events) {
        var juego = new Juego(juegoId);
        events.forEach(juego::applyEvent);
        return juego;
    }

    public void crearTablero() {
        var id = new TableroId();
        appendChange(new TableroCreado(id, jugadores.keySet())).apply();
    }

    public void crearRonda(Ronda ronda, Integer tiempo) {
        appendChange(new RondaCreada(ronda, tiempo)).apply();
    }

    public void cambiarTiempoDelTablero(TableroId tableroId, Integer tiempo) {
        appendChange(new TiempoCambiadoDelTablero(tableroId, tiempo)).apply();
    }

    public void ponerCartaEnTablero(TableroId tableroId, JugadorId jugadorId, Carta carta) {
        appendChange(new CartaPuestaEnTablero(tableroId, jugadorId, carta)).apply();
        appendChange(new CartaQuitadaDelMazo(jugadorId, carta)).apply();
    }

    public void quitarCartaEnTablero(TableroId tableroId, JugadorId jugadorId, Carta carta) {
        appendChange(new CartaQuitadaDelTablero(tableroId, jugadorId, carta)).apply();
    }

    public Ronda ronda() {
        return ronda;
    }

    public Tablero tablero() {
        return tablero;
    }

    public Map<JugadorId, Jugador> jugadores() {
        return jugadores;
    }

    public void iniciarRonda() {
        appendChange(new RondaIniciada()).apply();
    }


    public void asignarCartasAGanador(JugadorId ganadorId, Integer puntos, Set<Carta> cartasApuesta) {
        appendChange(new CartasAsignadasAJugador(ganadorId, puntos, cartasApuesta)).apply();
    }

    public void terminarRonda(TableroId tableroId, Set<JugadorId> jugadorIds) {
        appendChange(new RondaTerminada(tableroId, jugadorIds)).apply();

    }

    public void finalizarJuego(JugadorId jugadorId, String alias) {
        appendChange(new JuegoFinalizado(jugadorId, alias)).apply();

    }
}
