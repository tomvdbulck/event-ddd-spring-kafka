package com.ordina.eventing.customer.domain;

import java.util.List;
import java.util.UUID;

public interface Orders {
    void add(Order order);

    Order get(UUID id);

    List<Order> forCustomer(String customerCode);

    void update(Order shipment);
}
