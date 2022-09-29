package com.ordina.eventing.warehouse.query;

import com.ordina.eventing.warehouse.domain.Shipment;
import com.ordina.eventing.warehouse.domain.Shipments;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ShipmentQueries {

    private Shipments shipments;

    public ShipmentQueries(Shipments shipments){
        this.shipments = shipments;
    }

    public Shipment getById(UUID id){
        return this.shipments.get(id);
    }

    public Shipment getByOrderNumber(String orderNumber){
        return this.shipments.getByOrder(orderNumber);
    }

}
