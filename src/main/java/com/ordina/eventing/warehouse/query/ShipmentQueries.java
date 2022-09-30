package com.ordina.eventing.warehouse.query;

import com.ordina.eventing.warehouse.domain.Shipment;
import com.ordina.eventing.warehouse.domain.Shipments;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ShipmentQueries {

    private Shipments shipments;

    public ShipmentQueries(Shipments shipments){
        this.shipments = shipments;
    }

    public Shipment getById(String id){
        return this.shipments.findById(id).orElse(null);
    }

    public Shipment getByOrderNumber(String orderNumber){
        return StreamSupport
                .stream(this.shipments.findAll().spliterator(), false)
                .filter( shipment -> shipment.getOrder().getOrderCode().equals(orderNumber))
                .findFirst()
                .orElse(null);

    }

}
