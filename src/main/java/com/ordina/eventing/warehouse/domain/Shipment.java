package com.ordina.eventing.warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@ToString
@Entity
@Table
public class Shipment extends AbstractAggregateRoot {

    @Id
    private UUID id;

    private String customerCode;

    private ShipmentStatus status;

    private Order order;

    @ElementCollection
    @CollectionTable(name = "shipment_products")
    private List<Product> productList;

    public Shipment(String customerCode, Order order, List<Product> products) {
        this.id = UUID.randomUUID();

        this.customerCode = customerCode;
        this.order = order;

        this.status = ShipmentStatus.NEW;

        this.productList = products;
    }

    public Shipment() {
        //
    }

    public void readyToShip() {
        this.status = ShipmentStatus.ASSEMBLED;
        //broadcast event
    }

    public void send() {
        this.status = ShipmentStatus.SENT;
        //broadcast event
    }

    public void deliveredToDestination() {
        this.status = ShipmentStatus.DELIVERED;
        //broadcast event
    }


    public enum ShipmentStatus {
        NEW,
        ASSEMBLED,
        SENT,
        DELIVERED
    }

    @Builder
    @Embeddable
    @AllArgsConstructor
    @Getter
    public static class Order {

        private String orderCode;

        private OrderStatus orderStatus;

        public Order() {
            //
        }


        public enum OrderStatus{
            ORDERED,
            PAID,
            CANCELLED
        }
    }

    @Embeddable
    public static class Product {
        private String code;
        private String name;

        public Product(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public Product() {

        }
    }


}
