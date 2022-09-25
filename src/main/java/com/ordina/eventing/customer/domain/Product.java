package com.ordina.eventing.customer.domain;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Product {
    private String code;
    private String description;

    private BigDecimal price;

    private int amount;
}
