package com.ordina.eventing.customer.domain;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class ShoppingCart {

    private String customerCode;
    private ShoppingCartStatus status;
    private Customer customer;

    private HashMap<String, Product> productList;

    public ShoppingCart(Customer customer){
        customerCode = customer.getCode();
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
        this.status = ShoppingCartStatus.ORDERED;

        return new Order(customer, productList);
    }

    public enum ShoppingCartStatus {
        NEW,
        ORDERED,
        CANCELLED;
    }

}
