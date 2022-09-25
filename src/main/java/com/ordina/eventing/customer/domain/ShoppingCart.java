package com.ordina.eventing.customer.domain;

import java.util.HashMap;
import java.util.UUID;

public class ShoppingCart {

    private UUID id;
    private ShoppingCartStatus status;
    private Customer customer;

    private HashMap<String, Product> productList;

    public ShoppingCart(Customer customer){
        id = UUID.randomUUID();
        status = ShoppingCartStatus.NEW;
        this.customer = customer;
        productList = new HashMap<>();
    }

    public void updateProduct(Product product){
        if (product.getAmount() > 0) {
            productList.put(product.getCode(), product);
        } else if (product.getAmount() <= 0
            && productList.containsKey(product.getCode())) {
            productList.remove(product.getCode());
        }
    }

    public Order order() {
        //add event broadcast
        this.status = ShoppingCartStatus.ORDERED;

        return new Order(customer, productList);
    }

    public enum ShoppingCartStatus {
        NEW,
        ORDERED,
        CANCELLED;
    }

}
