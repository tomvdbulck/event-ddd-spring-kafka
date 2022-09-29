package com.ordina.eventing.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Getter
@ToString
@Builder(toBuilder = true)
@Embeddable
@AllArgsConstructor
public class Product {
    private String code;
    private String name;
    private String description;

    private BigDecimal price;

    private int amount;

    public Product() {
        //
    }

    public void updateAmount(int newAmount) {
        this.amount = newAmount;
    }
}
