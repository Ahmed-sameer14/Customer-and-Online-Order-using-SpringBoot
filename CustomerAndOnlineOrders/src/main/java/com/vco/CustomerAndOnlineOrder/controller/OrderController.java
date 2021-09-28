package com.vco.CustomerAndOnlineOrder.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vco.CustomerAndOnlineOrder.exception.ResourceNotFoundException;
import com.vco.CustomerAndOnlineOrder.model.Customer;
import com.vco.CustomerAndOnlineOrder.model.Orders;
import com.vco.CustomerAndOnlineOrder.payload.PayLoadOrder;
import com.vco.CustomerAndOnlineOrder.payload.ResponsePayLoad;
import com.vco.CustomerAndOnlineOrder.repository.OrderRepository;

/*in this class i am trying to perform the crud operation which the ManytoOne relationship
  with costomer table and product table*/

@RestController			//rest controller annotation which mentions the class contain crud type operation
@RequestMapping("/api")	//requesting url
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;	// autowired the orderRepository interface which extended jpareporitory
	
	@Autowired
	private OrderService orderService;
	
	 @GetMapping("/orders")		//this method is used for fetching the all the record present in the database of order table
	    public List<Orders> getAllOrders() {
//	        return orderRepository.findAll();
		 return ((JpaRepository<Orders, Integer>) orderRepository).findAll();
	    }
//	@GetMapping("/Orders")
//	private Object getAllOrders() {
//		List<Orders>s=null;
//		try {
//			s=orderRepository.findAll();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return new ResponsePayLoad(HttpStatus.BAD_REQUEST.value(), "Failed", ex.getMessage());
//		}
//		return new ResponsePayLoad(HttpStatus.ACCEPTED.value(), "SUCCESS", s);
//	}
	
    @GetMapping("/order/{id}")		//this method is used for fetching the perticuler one record present in the database of order table
    public ResponseEntity<Optional<Orders>> findById(@PathVariable (value = "id")Integer orderId	) {
      Optional<Orders> order = orderRepository.findById(orderId);
      try {
		order.orElseThrow(() -> new ResourceNotFoundException("order not found for this id :: " + orderId));
	} 
      catch (ResourceNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      return ResponseEntity.ok().body(order);
    }
    
    @PostMapping("/order")		//this method is used for inserting the  records in to the database of order table
	private Object saveOrder(@RequestBody PayLoadOrder payloadOrder) {
		
		int productId=payloadOrder.getProductId();
		int customerId=payloadOrder.getCustomerId();
		Orders order=payloadOrder.getOrder();
		return  orderService.saveOrder(productId, order,customerId);
	}
    
    @PutMapping("/order/{id}")		//this method is used for updating the one perticuler record present in the database of order table
    public ResponseEntity<Orders> updateOrders(@PathVariable(value = "id")Integer orderId,
								@Valid @RequestBody Orders orderUpdated) throws ResourceNotFoundException
    							 {
    	Orders order = orderRepository.findById(orderId)
    	        .orElseThrow(() -> new ResourceNotFoundException("order not found for this id :: " + orderId));
    	        System.out.println("order");
    	        order.setPaymentMethod(orderUpdated.getPaymentMethod());
    	        order.setTotalItem(orderUpdated.getTotalItem());
    	        order.setTotalPrice(orderUpdated.getTotalPrice());
    	        final Orders orderUpdate = orderRepository.save(order);
    	        return ResponseEntity.ok(orderUpdate);
        
    }
    
    @DeleteMapping("/order/{id}")	//this delete method is use for deleting one perticuler record
    public Map<String, Boolean> deleteOrder(@PathVariable(value = "id") Integer orderId) throws ResourceNotFoundException{
    	
    	Orders order = orderRepository.findById(orderId)
    		       .orElseThrow(() -> new ResourceNotFoundException("order not found for this id :: " + orderId));

    				orderRepository.delete(order);
    		        Map<String, Boolean> response = new HashMap<>();
    		        response.put("deleted", Boolean.TRUE);
    		        return response;
    }

}
