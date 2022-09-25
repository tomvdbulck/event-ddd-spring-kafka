package com.ordina.eventing.shipping.acl;

import com.ordina.eventing.customer.domain.events.OrderIsOrderedEvent;
import com.ordina.eventing.shipping.domain.Shipment;
import com.ordina.eventing.shipping.domain.Shipments;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Slf4j
public class OrderDomainEventHandler {

    @Autowired
    public Shipments shipments;

    @EventListener
    public void onOrderIsOrdered(OrderIsOrderedEvent event){

        log.info("Handling event {}", event);

        Shipment.Order order = Shipment.Order.builder()
                .orderCode(event.getOrderId().toString())
                .status(Shipment.Order.OrderStatus.ORDERED)
                .productList(event.getProductList().stream()
                        .map(product -> new Shipment.Order.Product(product.getCode(), product.getName()))
                        .collect(Collectors.toList())
                )
                .build();

        shipments.add(new Shipment(event.getCustomerCode(), order));

    }
}
