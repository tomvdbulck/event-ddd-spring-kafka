package com.ordina.eventing.customer.domain;


import org.springframework.data.repository.Repository;

import java.util.List;

public interface Orders extends Repository<Order, String> {
    void save(Order order);

    Order findById(String id);

    List<Order> findAll();

}
