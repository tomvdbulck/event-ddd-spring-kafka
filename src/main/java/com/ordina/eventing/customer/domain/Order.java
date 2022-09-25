package com.ordina.eventing.customer.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Order {

    private String customerCode;
    private OrderStatus status;

    private List<Product> productList;

    public Order(Customer customer, HashMap<String,Product> productList) {
        this.customerCode = customer.getCode();

        this.productList = new ArrayList<>(productList.values());

        this.status = OrderStatus.ORDERED;
        //broadcast event
    }

    public void pay() {
        this.status = OrderStatus.PAID;
        //broadcast event
    }

    public void cancel() {
        this.status = OrderStatus.CANCELLED;
        //broadcast event
    }

    public enum OrderStatus{
        ORDERED,
        PAID,
        CANCELLED
    }


}
