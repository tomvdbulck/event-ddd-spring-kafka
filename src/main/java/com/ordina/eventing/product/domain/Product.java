package com.ordina.eventing.product.domain;

import lombok.Builder;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Builder
@ToString
public class Product {

    private String code;
    private String name;
    private String description;

    private List<String> relatedProducts;

    private BigDecimal price;
}
