package com.ordina.eventing.customer.domain.events;

import com.ordina.eventing.customer.domain.Order;
import com.ordina.eventing.customer.domain.Product;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@ToString
public class OrderIsOrderedEvent {

    private UUID orderId;
    private String customerCode;

    private List<Product> productList;

    public OrderIsOrderedEvent(Order order) {
        this.orderId = UUID.fromString(order.getId());
        this.customerCode = order.getCustomerCode();

        this.productList = order.getProductList();
    }
}
