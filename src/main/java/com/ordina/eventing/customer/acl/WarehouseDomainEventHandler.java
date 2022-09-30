package com.ordina.eventing.customer.acl;

import com.ordina.eventing.customer.domain.Order;
import com.ordina.eventing.customer.domain.Orders;
import com.ordina.eventing.customer.domain.events.OrderIsOrderedEvent;
import com.ordina.eventing.warehouse.domain.Shipment;
import com.ordina.eventing.warehouse.domain.Shipments;
import com.ordina.eventing.warehouse.domain.events.ShipmentIsReadyToBeShipped;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WarehouseDomainEventHandler {

    @Autowired
    public Orders orders;

    @EventListener
    public void onOrderIsOrdered(ShipmentIsReadyToBeShipped event){
        log.info("Handling a DOMAIN event {}", event);

        Order order = orders.findById(event.getOrderCode());
        order.readyToBeShipped();
        orders.save(order);
    }
}
