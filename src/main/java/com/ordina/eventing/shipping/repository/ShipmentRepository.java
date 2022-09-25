package com.ordina.eventing.shipping.repository;

import com.ordina.eventing.shipping.domain.Shipment;
import com.ordina.eventing.shipping.domain.Shipments;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ShipmentRepository implements Shipments {

    private HashMap<UUID, Shipment> shipmentHashMap;

    public ShipmentRepository(){
        this.shipmentHashMap = new HashMap<>();
    }


    @Override
    public void add(Shipment shipment) {
        if (shipmentHashMap.containsKey(shipment.getId())) {
            throw new RuntimeException("shipment-already-exists");
        }

        shipmentHashMap.put(shipment.getId(), shipment);
    }

    @Override
    public Shipment get(UUID id) {
        return shipmentHashMap.get(id);
    }

    @Override
    public List<Shipment> forCustomer(String customerCode) {
        return shipmentHashMap.values().stream()
                .filter(shipment -> shipment.getCustomerCode().equals(customerCode))
                .collect(Collectors.toList());
    }


    @Override
    public void update(Shipment shipment) {
        if (!shipmentHashMap.containsKey(shipment.getId())) {
            throw new RuntimeException("shipment-does-not-yet-exists");
        }

        shipmentHashMap.put(shipment.getId(), shipment);
    }
}