package com.ordina.eventing.customer.domain;

import com.ordina.eventing.customer.domain.events.OrderIsOrderedEvent;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@ToString
public class Order extends AbstractAggregateRoot {

    @Id
    private UUID id;

    private String customerCode;
    private OrderStatus status;

    private List<Product> productList;

    public Order() {}

    public Order(Customer customer, HashMap<String,Product> productList) {
        this.id = UUID.randomUUID();
        this.customerCode = customer.getCode();

        this.productList = new ArrayList<>(productList.values());

        this.status = OrderStatus.ORDERED;

        registerEvent(new OrderIsOrderedEvent(this));
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
