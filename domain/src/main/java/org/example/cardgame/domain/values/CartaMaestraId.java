package org.example.cardgame.domain.values;

import co.com.sofka.domain.generic.Identity;

public class CartaMaestraId extends Identity {
    public CartaMaestraId() {

    }

    private CartaMaestraId(String id) {
        super(id);
    }

    public static CartaMaestraId of(String id) {
        return new CartaMaestraId(id);
    }
}
