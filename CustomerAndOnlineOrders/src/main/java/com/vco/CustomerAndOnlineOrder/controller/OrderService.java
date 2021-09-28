package com.vco.CustomerAndOnlineOrder.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vco.CustomerAndOnlineOrder.model.Customer;
import com.vco.CustomerAndOnlineOrder.model.Orders;
import com.vco.CustomerAndOnlineOrder.model.Product;
import com.vco.CustomerAndOnlineOrder.payload.ResponsePayLoad;
import com.vco.CustomerAndOnlineOrder.repository.CustomerRepository;
import com.vco.CustomerAndOnlineOrder.repository.OrderRepository;
import com.vco.CustomerAndOnlineOrder.repository.ProductRepository;

//in this class i am tryng to connect the productId and customerId into the Assigment table

@Service
public class OrderService 
{
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository ProductRepository;

	public Object saveOrder(int productId,Orders order,int customerId) {
		Orders or=null;
		try {
			// concentrated OOPS tonic (all flavour/features are concentrated
			// interface, class, Inheritance, data hiding, abstraction , collections
			//                 select * from product where productId = productId
			Optional<Product>p=ProductRepository.findById(productId);
			// possibility 1 :::  data is there , extract the ENTIRE details of the product
			// possibility 2 :::  data is NOT there , it will hold null
			Product p1=p.get(); // if null is there is there then it will throw NoSuchElementException
			System.out.println("*** Product **** name "+p1.getProductName()+" id "+p1.getProductId());
			order.setProductId(p1);
			p1.getOrder().add(order);
			
			Optional<Customer>c=customerRepository.findById(customerId);
			Customer c1=c.get();
			order.setCustomerId(c1);
			System.out.println("*** Customer **** Id "+c1.getCustomerId());
			c1.getOrder().add(order);
			// it means that there is a Set and that set holds object of Order class
			//  order class has  ProductId,customerId,OrderDate,totalItem,totalPrice
			or=orderRepository.save(order);
			// insert into order(product_id,cutomer_id,order_date,total_price,total_item) values (10,9,'2021-09-24',1,7000)	1 row(s) affected	0.000 sec
 
		}catch(Exception ex) {
			System.out.println("Excetpion is " + ex);
			return new ResponsePayLoad(HttpStatus.BAD_REQUEST.value(), "Failed", ex.getMessage());
		}
		return new ResponsePayLoad(HttpStatus.ACCEPTED.value(), "SUCCESS", or);
	}
}
