package com.vco.CustomerAndOnlineOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vco.CustomerAndOnlineOrder.model.Shipment;
@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer>{

}

/*in this shipmentRepo interface i am extende jpa repository
basicaly which contain crud operation methods */