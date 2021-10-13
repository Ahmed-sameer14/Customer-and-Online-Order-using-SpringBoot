package com.vco.CustomerAndOnlineOrder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vco.CustomerAndOnlineOrder.model.Orders;
import com.vco.CustomerAndOnlineOrder.repository.OrderRepository;

@Service("orderServices")
public class OrderServiceImp implements OrderServices{
	
	@Qualifier("orderRepository")
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public String saveOrder(Orders order) {
		orderRepository.saveAndFlush(order);
        return "customer Added Sucessfully";

	}

	@Override
	public List<Orders> findAllOrders(Integer order) {
		// TODO Auto-generated method stub
		 return orderRepository.findAll();
	}

	@Override
	public Orders findOrderById(Integer orderId) {
		// TODO Auto-generated method stub
		return ((OrderServiceImp) orderRepository).findOrderById(orderId);
	}

	@Override
	public String updateOrder(Integer order) {
		orderRepository.saveAndFlush(order);
		return "Order Updated Succesfully";
	}

	@Override
	public String deleteOrders(Integer id) {
		@SuppressWarnings("deprecation")
		Orders order = orderRepository.getOne(id);
		orderRepository.saveAndFlush(order);
		return "order Deleted Sucessfully";
	}
	
}
