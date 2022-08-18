package org.example.cardgame.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cardgame.domain.*;
import org.example.cardgame.usecase.gateways.CartaMaestra;
import org.example.cardgame.usecase.gateways.ConsultarCartaMaestraService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        Random random = new Random();
        var cartasList = new ArrayList<>(cartas);
        List<Carta> carta =  cartas.stream().map(c ->{
            int randomIndex = random.nextInt(cartasList.size());
            CartaMaestra cartaMaestra = cartasList.get(randomIndex);
            cartasList.remove(randomIndex);
            return new Carta(cartaMaestra.getPoder(),cartaMaestra.getId(),false);
        }).limit(4).collect(Collectors.toList());

        return new Mazo(Set.copyOf(carta));
    }
}
