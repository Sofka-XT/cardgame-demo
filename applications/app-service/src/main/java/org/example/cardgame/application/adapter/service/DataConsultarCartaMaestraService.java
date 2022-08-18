package org.example.cardgame.application.adapter.service;

import org.example.cardgame.usecase.gateways.CartaMaestra;
import org.example.cardgame.usecase.gateways.ConsultarCartaMaestraService;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class DataConsultarCartaMaestraService implements ConsultarCartaMaestraService {
    private final ReactiveMongoTemplate template;

    public DataConsultarCartaMaestraService(ReactiveMongoTemplate template) {
        this.template = template;
    }

    @Override
    public Flux<CartaMaestra> cosultarCartasPepsico() {
        return template.findAll(CartaMaestra.class, "cards");
    }
}
