package com.ordina.eventing.shipping.domain;

import java.util.List;
import java.util.UUID;

public interface Shipments {
    void add(Shipment shipment);

    Shipment get(UUID id);

    List<Shipment> forCustomer(String customerCode);

    void update(Shipment shipment);
}
