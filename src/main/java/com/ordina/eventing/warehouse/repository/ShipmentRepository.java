package com.ordina.eventing.warehouse.repository;

import com.ordina.eventing.warehouse.domain.Shipment;
import com.ordina.eventing.warehouse.domain.Shipments;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class ShipmentRepository implements Shipments {

    private HashMap<UUID, Shipment> shipmentHashMap;

    public ShipmentRepository(){
        this.shipmentHashMap = new HashMap<>();
    }


    @Override
    public void add(Shipment shipment) {
        log.info("Adding shipment {}", shipment);

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
