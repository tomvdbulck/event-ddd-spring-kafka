package com.ordina.eventing.customer.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@Builder(toBuilder = true)
public class Product {
    private String code;
    private String name;
    private String description;

    private BigDecimal price;

    private int amount;

    public void updateAmount(int newAmount) {
        this.amount = newAmount;
    }
}
