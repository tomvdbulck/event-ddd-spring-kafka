package com.ordina.eventing.customer.domain;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class Product {
    private String code;
    private String name;
    private String description;

    private BigDecimal price;

    private int amount;
}
