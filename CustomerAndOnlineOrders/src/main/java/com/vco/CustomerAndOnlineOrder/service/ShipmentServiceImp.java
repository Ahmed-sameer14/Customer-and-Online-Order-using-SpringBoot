package com.vco.CustomerAndOnlineOrder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vco.CustomerAndOnlineOrder.model.Shipment;
import com.vco.CustomerAndOnlineOrder.repository.ShipmentRepository;
@Service("shipmentService")
public class ShipmentServiceImp implements ShipmentService{

	@Qualifier("shipmentRepository")
	@Autowired
	private ShipmentRepository shipmentRepository;
	
	@Override
	public String saveShipment(Shipment shipment) {
		shipmentRepository.saveAndFlush(shipment);
      return "customer Added Sucessfully";
	}

	@Override
	public List<Shipment> findAllShioment(Integer shipment) {
		// TODO Auto-generated method stub
		return shipmentRepository.findAll();
	}

	@Override
	public Shipment findShipmentById(Integer shipmentId) {
		// TODO Auto-generated method stub
		return ((ShipmentServiceImp) shipmentRepository).findShipmentById(shipmentId);
	}

	@Override
	public String updateShipment(Integer shipment) {
		shipmentRepository.saveAndFlush(shipment);
		return "shipment Updated Succesfully";
	}

	@Override
	public String deleteShipment(Integer id) {
		@SuppressWarnings("deprecation")
		Shipment shipment = shipmentRepository.getOne(id);
		shipmentRepository.saveAndFlush(shipment);
		return "shipment Deleted Sucessfully";
	}

}
