package com.ordina.eventing.warehouse.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface Shipments extends CrudRepository<Shipment, String> {
}
