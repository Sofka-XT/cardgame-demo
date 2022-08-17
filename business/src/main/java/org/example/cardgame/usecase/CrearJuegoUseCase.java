package org.example.cardgame.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cardgame.domain.*;
import org.example.cardgame.usecase.gateways.CartaMaestra;
import org.example.cardgame.usecase.gateways.ConsultarCartaMaestraService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class CrearJuegoUseCase implements Function<Mono<CrearJuegoCommand>, Flux<DomainEvent>> {

    private final ConsultarCartaMaestraService service;

    public CrearJuegoUseCase(ConsultarCartaMaestraService service){
        this.service = service;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<CrearJuegoCommand> crearJuegoCommand) {
        return crearJuegoCommand.flatMapMany(command -> {
            return service.cosultarCartasPepsico().collectList().flatMapMany(cartas -> {
                var factory = new JugadoresFactory();
                command.getJugadores()
                        .forEach((id, alias) -> {
                            factory.agregarJugador(JugadorId.of(id), alias, generarMazo(cartas));
                        });
                var juego = new Juego(JuegoId.of(command.getJuegoId()), factory);

                return Flux.fromIterable(juego.getUncommittedChanges());
            });
        });
    }

    private Mazo generarMazo(List<CartaMaestra> cartas) {
        //TODO: sacar 5 0 6 cartas para el jugador de manera aleatorio
        return null;
    }
}
