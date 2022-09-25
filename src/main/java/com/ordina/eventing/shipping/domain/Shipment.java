package com.ordina.eventing.shipping.domain;

import java.util.List;

public class Shipment {

    private String customerCode;

    private Order order;



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
