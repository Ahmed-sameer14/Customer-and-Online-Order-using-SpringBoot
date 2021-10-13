package com.vco.CustomerAndOnlineOrder.service;

import java.util.List;

import com.vco.CustomerAndOnlineOrder.model.Shipment;


public interface ShipmentService {
	String saveShipment(Shipment shipment);
	
	List<Shipment> findAllShioment(Integer shipment);
	
	Shipment findShipmentById(Integer shipmentId);
	
	String updateShipment(Integer shipment);
	
	 String deleteShipment(Integer id);

}
