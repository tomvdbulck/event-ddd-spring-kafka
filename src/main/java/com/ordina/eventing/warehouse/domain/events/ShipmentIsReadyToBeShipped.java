package com.ordina.eventing.warehouse.domain.events;

import com.ordina.eventing.warehouse.domain.Shipment;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ShipmentIsReadyToBeShipped {

    private String orderCode;
    private UUID shipmentId;

    public ShipmentIsReadyToBeShipped(Shipment shipment) {
        this.orderCode = shipment.getOrder().getOrderCode();
        this.shipmentId = UUID.fromString(shipment.getId());
    }
}
