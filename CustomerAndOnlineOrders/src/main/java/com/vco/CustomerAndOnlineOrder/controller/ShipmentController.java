package com.vco.CustomerAndOnlineOrder.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vco.CustomerAndOnlineOrder.exception.NotFoundException;
import com.vco.CustomerAndOnlineOrder.model.Shipment;
import com.vco.CustomerAndOnlineOrder.repository.ShipmentRepository;

/*in this class i am trying to perform the crud operation which the OnetoOne relationship
with costomer table and order table*/

@RestController		//rest controller annotation which mentions the class contain crud type operation
@RequestMapping("/api")	//requesting url
public class ShipmentController {
	@Autowired
	private ShipmentRepository shipmentRepository;	//autowired the orderRepository interface which extended jpareporitory
	
    @GetMapping("/shipments")	//this method is used for fetching the all the record present in the database of shipment table
    public List<Shipment> getAllShipment() {
    	return shipmentRepository.findAll();
    }
    
    @GetMapping("/shipment/{id}")	//this method is used for fetching the perticuler one record present in the database of shipment table
    public Shipment getShipmentByID(@PathVariable Integer id) {
    	Optional<Shipment> optShipment = shipmentRepository.findById(id);
    	if(optShipment.isPresent()) {
    		return optShipment.get();
    	}else {
    		throw new NotFoundException("shipment not found with id " + id);
    	}
    }
    
    @PostMapping("/shipment")		//this method is used for inserting the  records in to the database of order table
    public Shipment createShipment(@Valid @RequestBody Shipment shipment) {
        return shipmentRepository.save(shipment);
    }
    
    @PutMapping("/shipment/{id}")	//this method is used for updating the one perticuler record present in the database of shipment table
    public Shipment updateShipment(@PathVariable Integer id,
                                   @Valid @RequestBody Shipment shipmentUpdated) {
        return shipmentRepository.findById(id)
                .map(shipment -> {
                	shipment.setCustomerId(shipmentUpdated.getCustomerId());
                	shipment.setDispatchDate(shipmentUpdated.getDispatchDate());
                	shipment.setOrderId(shipmentUpdated.getOrderId());
                	shipment.setOrderStatus(shipmentUpdated.getOrderStatus());
                	shipment.setRecieveDate(shipmentUpdated.getRecieveDate());
                    return shipmentRepository.save(shipment);
                }).orElseThrow(() -> new NotFoundException("shipment not found with id " + id));
    }
    
    @DeleteMapping("/shipment/{id}")	//this delete method is use for deleting one perticuler record from the database
    public String deleteShipment(@PathVariable Integer id) {
        return shipmentRepository.findById(id)
                .map(shipment -> {
                	shipmentRepository.delete(shipment);
                    return "Delete Successfully!";
                }).orElseThrow(() -> new NotFoundException("shipment not found with id " + id));
    }
}
