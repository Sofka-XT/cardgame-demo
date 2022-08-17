package org.example.cardgame.usecase.gateways;

import reactor.core.publisher.Flux;

public interface ConsultarCartaMaestraService {
    Flux<CartaMaestra> cosultarCartasPepsico();
}
