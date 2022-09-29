package com.ordina.eventing.customer.domain;

public interface ShoppingCarts {
    void add(ShoppingCart shoppingCart);

    ShoppingCart get(String id);

    void update(ShoppingCart shoppingCart);
}
