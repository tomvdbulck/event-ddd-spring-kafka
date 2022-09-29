package com.ordina.eventing.customer.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Customer {
    private String code;
    private String name;

    private List<Order> orders;

    public Customer (String code, String name) {
        this.code = code;
        this.name = name;

        orders = new ArrayList<>();
    }


    public ShoppingCart createNewShoppingCart() {
        return new ShoppingCart(this);
    }

}
