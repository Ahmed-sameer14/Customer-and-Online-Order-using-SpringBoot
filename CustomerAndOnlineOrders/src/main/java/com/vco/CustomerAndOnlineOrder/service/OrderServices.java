package com.vco.CustomerAndOnlineOrder.service;

import java.util.List;

import com.vco.CustomerAndOnlineOrder.model.Orders;

public interface OrderServices {

	    String saveOrder(Orders order);
		
		List<Orders> findAllOrders(Integer order);
		
		Orders findOrderById(Integer orderId);
		
		String updateOrder(Integer order);
		
		 String deleteOrders(Integer id);

}
