package org.example.cardgame.usecase.gateways;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.cardgame.domain.JuegoId;
import reactor.core.publisher.Flux;

public interface JuegoDomainEventRepository {
    Flux<DomainEvent> consultarEventosPor(JuegoId juegoId);
}
