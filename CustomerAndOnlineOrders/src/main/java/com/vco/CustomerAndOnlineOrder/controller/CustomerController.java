package com.vco.CustomerAndOnlineOrder.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
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
import com.vco.CustomerAndOnlineOrder.repository.CustomerRepository;

/* this is the master class controller which has crud methods*/

@RestController		//rest controller annotation which mentions the class contain crud type operation
@RequestMapping("/api/customerTable")	//requesting url
public class CustomerController {

	@Autowired		//we have to autowired the customerRepository interface which extended jpareporitory
    private CustomerRepository customerRepository;

    @GetMapping("/customers")		//this method is used for fetching the all record present inthe database customer table
    public List<Customer> getAllCustomer() {
        return ((JpaRepository<Customer, Integer>) customerRepository).findAll();
    }

    @GetMapping("/customer/{id}")				//this method is used for fetching the perticuler one record present inthe database of customer table
    public ResponseEntity<Customer> getCustomerById(
    @PathVariable(value = "id") Integer customerId) throws ResourceNotFoundException {
        Customer customer = ((CrudRepository<Customer, Integer>) customerRepository).findById(customerId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ customerId));
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/customer")		//this method is used for inserting the  records in to the database of customer table
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return ((CrudRepository<Customer, Integer>) customerRepository).save(customer);
    }

    @PutMapping("/customer/{id}")	//this method is used for updating the one perticuler record present inthe database of customer table
    public ResponseEntity<Customer> updateCustomer(
    @PathVariable(value = "id") Integer customerId,
    @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
    	Customer customer = ((CrudRepository<Customer, Integer>) customerRepository).findById(customerId)
          .orElseThrow(() -> new ResourceNotFoundException("customer not found on :: "+ customerId));
  
    	customer.setFirstName(customerDetails.getFirstName());
    	customer.setLastName(customerDetails.getLastName());
    	customer.setMiddleName(customerDetails.getMiddleName());
    	customer.setDob(customerDetails.getDob());
    	customer.setEmail_address(customerDetails.getEmail_address());
    	customer.setMobile_number(customerDetails.getMobile_number());
    	customer.setCity(customerDetails.getCity());
    	customer.setHome_address(customerDetails.getHome_address());
    	customer.setState(customerDetails.getState());
    	customer.setZipcode(customerDetails.getZipcode());
        final Customer updatedCustomer = ((CrudRepository<Customer, Integer>) customerRepository).save(customer);
        return ResponseEntity.ok(updatedCustomer);
   }

   @DeleteMapping("/customer/{id}")			//this delete method is use for deleting the one perticuler record
   public Map<String, Boolean> deleteCustomer(
       @PathVariable(value = "id") Integer customerId) throws Exception {
       Customer customer = ((CrudRepository<Customer, Integer>) customerRepository).findById(customerId)
          .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ customerId));

       ((CrudRepository<Customer, Integer>) customerRepository).delete(customer);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
   }
}
