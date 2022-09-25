package com.ordina.eventing.shipping.domain;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Shipment {

    private UUID id;

    private String customerCode;

    private ShipmentStatus status;

    private Order order;

    public Shipment(String customerCode, Order order) {
        this.id = UUID.randomUUID();

        this.customerCode = customerCode;
        this.order = order;

        this.status = ShipmentStatus.NEW;
    }

    public void readyToShip() {
        this.status = ShipmentStatus.ASSEMBLED;
        //broadcast event
    }

    public void send() {
        this.status = ShipmentStatus.SENT;
        //broadcast event
    }

    public void receive() {
        this.status = ShipmentStatus.RECEIVED;
        //broadcast event
    }


    public enum ShipmentStatus {
        NEW,
        ASSEMBLED,
        SENT,
        RECEIVED
    }

    public class Order {

        private String orderCode;

        private OrderStatus status;

        private List<Product> productList;

        public class Product {
            private String code;
            private String description;
        }

        public enum OrderStatus{
            ORDERED,
            PAID,
            CANCELLED
        }
    }


}
