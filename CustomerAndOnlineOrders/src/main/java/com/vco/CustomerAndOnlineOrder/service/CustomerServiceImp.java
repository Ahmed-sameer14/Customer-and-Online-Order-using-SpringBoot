package com.vco.CustomerAndOnlineOrder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vco.CustomerAndOnlineOrder.model.Customer;
import com.vco.CustomerAndOnlineOrder.repository.CustomerRepository;

@Service("CustomerService")
public class CustomerServiceImp implements CustomerService{

	@Qualifier("customerRepository")
    @Autowired
    private CustomerRepository customerRepository;

	 @Override
	    public String saveCustomer(Customer customer) {
		 customerRepository.saveAndFlush(customer);
	        return "customer Added Sucessfully";
	    }

	
	@Override
	 public List<Customer> findAllCustomer(Integer customer) {
	        // TODO Auto-generated method stub
	        return customerRepository.findAll();
	    }
	
	@Override
	public Customer findCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		return ((CustomerServiceImp) customerRepository).findCustomerById(customerId);
	}

	@Override
	public String updateCustomer(Integer customer) {
		 customerRepository.saveAndFlush(customer);
		return "Customer Updated Succesfully";
	}
	
	
	@Override
	public String deleteCustomer(Integer id) {
		@SuppressWarnings("deprecation")
		Customer customer = customerRepository.getOne(id);
		customerRepository.saveAndFlush(customer);
		return "Customer Deleted Sucessfully";
	}
}
