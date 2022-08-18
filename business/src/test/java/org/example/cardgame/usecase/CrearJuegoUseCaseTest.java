package org.example.cardgame.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cardgame.domain.CrearJuegoCommand;
import org.example.cardgame.domain.JuegoCreado;
import org.example.cardgame.domain.JugadorAgregado;
import org.example.cardgame.usecase.gateways.CartaMaestra;
import org.example.cardgame.usecase.gateways.ConsultarCartaMaestraService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.HashMap;
import java.util.Objects;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearJuegoUseCaseTest {

    @Mock
    private ConsultarCartaMaestraService service;

    @InjectMocks
    private CrearJuegoUseCase useCase;

    @Test
    void crearJuego(){
        //arrange
        var command = new CrearJuegoCommand();
        command.setJuegoId("xxx");
        command.setJugadores(new HashMap<>());
        command.getJugadores().put("fff", "raul");
        command.getJugadores().put("ggg", "andres");
        command.getJugadores().put("zzz", "pedro");

        when(service.cosultarCartasPepsico()).thenReturn(cartasSet());

        //act & assert
        StepVerifier.create(useCase.apply(Mono.just(command)))
                .expectNextMatches(domainEvent -> {
                    var event = (JuegoCreado)domainEvent;
                    return event.getId().value().equals("xxx");
                })
                .expectNextMatches(domainEvent -> {
                    var event = (JugadorAgregado)domainEvent;
                    assert event.getMazo().value().size() == 4;
                    return event.getAlias().equals("raul") && event.getJugadorId().value().equals("fff");
                })
                .expectNextMatches(domainEvent -> {
                    var event = (JugadorAgregado)domainEvent;
                    assert event.getMazo().value().size() == 4;
                    return event.getAlias().equals("andres") && event.getJugadorId().value().equals("ggg");
                })
                .expectNextMatches(domainEvent -> {
                    var event = (JugadorAgregado)domainEvent;
                    assert event.getMazo().value().size() == 4;
                    return event.getAlias().equals("pedro") && event.getJugadorId().value().equals("zzz");
                })
                .expectComplete()
                .verify();

    }

    private Flux<CartaMaestra> cartasSet() {
        return Flux.just(
                new CartaMaestra(),
                new CartaMaestra(),
                new CartaMaestra(),
                new CartaMaestra(),
                new CartaMaestra(),
                new CartaMaestra(),
                new CartaMaestra(),
                new CartaMaestra(),
                new CartaMaestra(),
                new CartaMaestra(),
                new CartaMaestra(),
                new CartaMaestra(),
                new CartaMaestra(),
                new CartaMaestra()
        );
    }
}