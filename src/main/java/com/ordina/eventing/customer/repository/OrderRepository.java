package com.ordina.eventing.customer.repository;

import com.ordina.eventing.customer.domain.Order;
import com.ordina.eventing.customer.domain.Orders;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class OrderRepository implements Orders {

    private HashMap<UUID, Order> orderHashMap;

    public OrderRepository(){
        this.orderHashMap = new HashMap<>();
    }


    @Override
    public void add(Order order) {
        if (orderHashMap.containsKey(order.getId())) {
            throw new RuntimeException("order-already-exists");
        }

        orderHashMap.put(order.getId(), order);
    }

    @Override
    public Order get(UUID id) {
        return orderHashMap.get(id);
    }

    @Override
    public List<Order> forCustomer(String customerCode) {
        return orderHashMap.values().stream()
                .filter(order -> order.getCustomerCode().equals(customerCode))
                .collect(Collectors.toList());
    }


    @Override
    public void update(Order order) {
        if (!orderHashMap.containsKey(order.getId())) {
            throw new RuntimeException("order-does-not-yet-exists");
        }

        orderHashMap.put(order.getId(), order);
    }
}
