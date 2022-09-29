package com.ordina.eventing.customer.repository;

import com.ordina.eventing.customer.domain.Order;
import com.ordina.eventing.customer.domain.Orders;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository implements Orders {

    private HashMap<String, Order> orderHashMap;

    public OrderRepository(){
        this.orderHashMap = new HashMap<>();
    }


    @Override
    public void save(Order order) {
        orderHashMap.put(order.getId(), order);
    }

    @Override
    public Order findById(String id) {
        return orderHashMap.get(id);
    }

    @Override
    public List<Order> findAll() {
        return orderHashMap.values().stream().toList();
    }
}
