package com.ordina.eventing.warehouse.domain;

import java.util.List;
import java.util.UUID;

public interface Shipments {
    void save(Shipment shipment);

    Shipment get(UUID id);

    List<Shipment> forCustomer(String customerCode);

    void update(Shipment shipment);

    Shipment getByOrder(String orderNumber);
}
