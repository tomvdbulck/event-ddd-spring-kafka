package com.ordina.eventing.warehouse.acl;

import com.ordina.eventing.customer.domain.events.OrderIsOrderedEvent;
import com.ordina.eventing.warehouse.domain.Shipment;
import com.ordina.eventing.warehouse.domain.Shipments;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .orderStatus(Shipment.Order.OrderStatus.ORDERED)
                .build();

        List<Shipment.Product> productList = event.getProductList().stream()
                        .map(product -> new Shipment.Product(product.getCode(), product.getName()))
                        .collect(Collectors.toList());

        Shipment shipment = new Shipment(event.getCustomerCode(), order, productList);
        shipments.save(shipment);

        log.info("We have now added the new shipment {}", shipment);
    }
}
