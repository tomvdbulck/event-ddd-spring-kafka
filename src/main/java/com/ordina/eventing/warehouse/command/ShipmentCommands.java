package com.ordina.eventing.warehouse.command;

import com.ordina.eventing.warehouse.domain.Shipment;
import com.ordina.eventing.warehouse.domain.Shipments;
import org.springframework.stereotype.Component;

@Component
public class ShipmentCommands {

    private Shipments shipments;

    public ShipmentCommands(Shipments shipments) {
        this.shipments = shipments;
    }

    public void indicateShipmentHasBeenAssembled(Shipment shipment) {
        shipment = shipments.findById(shipment.getId().toString()).orElse(null);

        shipment.readyToShip();
        shipments.save(shipment);
    }

    public void sendShipment(Shipment shipment) {

    }

    public void shipmentHasBeenDelivered(Shipment shipment) {
        //Actually this would be nice to be handled as an event coming from UPS, TNT, ... ;-)

    }
}
