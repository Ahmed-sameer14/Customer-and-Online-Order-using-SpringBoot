package com.vco.CustomerAndOnlineOrder.service;

import java.util.List;

import com.vco.CustomerAndOnlineOrder.model.Customer;

public interface CustomerService {
	String saveCustomer(Customer customer);
	
	List<Customer> findAllCustomer(Integer customer);
	
	Customer findCustomerById(Integer customerId);
	
	String updateCustomer(Integer customer);
	
	 String deleteCustomer(Integer id);
}
