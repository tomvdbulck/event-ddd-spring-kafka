package com.ordina.eventing.customer.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Getter
public class Order {

    private UUID id;

    private String customerCode;
    private OrderStatus status;

    private List<Product> productList;

    public Order(Customer customer, HashMap<String,Product> productList) {
        this.id = UUID.randomUUID();
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

    public void ship() {
        this.status = OrderStatus.SHIPPED;
        //broadcast event
    }

    public void delivered(){
        this.status = OrderStatus.DELIVERED;
        //broadcast event
    }

    public enum OrderStatus{
        ORDERED,
        PAID,
        CANCELLED,
        SHIPPED,
        DELIVERED
    }


}
