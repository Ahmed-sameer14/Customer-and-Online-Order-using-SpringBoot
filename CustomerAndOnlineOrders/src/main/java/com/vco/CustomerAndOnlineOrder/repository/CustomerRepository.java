package com.vco.CustomerAndOnlineOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vco.CustomerAndOnlineOrder.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	String saveAndFlush(Integer customer);
//	boolean existsById(Customer customer);
}
	
	/*in this customerRepository interface i am extende jpa repository
	  basicaly which contain crud operation methods */
	 