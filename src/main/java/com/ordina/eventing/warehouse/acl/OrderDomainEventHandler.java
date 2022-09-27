package com.ordina.eventing.warehouse.acl;

import com.ordina.eventing.customer.domain.events.OrderIsOrderedEvent;
import com.ordina.eventing.warehouse.domain.Shipment;
import com.ordina.eventing.warehouse.domain.Shipments;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderDomainEventHandler {

    @Autowired
    public Shipments shipments;

    @EventListener
    //@TransactionalEventListener
    public void onOrderIsOrdered(OrderIsOrderedEvent event){
        log.info("Handling a DOMAIN event {}", event);

        Shipment.Order order = Shipment.Order.builder()
                .orderCode(event.getOrderId().toString())
                .status(Shipment.Order.OrderStatus.ORDERED)
                .productList(event.getProductList().stream()
                        .map(product -> new Shipment.Order.Product(product.getCode(), product.getName()))
                        .collect(Collectors.toList())
                )
                .build();

        Shipment shipment = new Shipment(event.getCustomerCode(), order);
        shipments.add(shipment);

        log.info("We have now added the new shipment {}", shipment);
    }
}
