package com.vco.CustomerAndOnlineOrder.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vco.CustomerAndOnlineOrder.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
	List<Orders> findOrderByOrderId(Integer orderId);

	Optional<Orders> findById(Integer orderId);

	void saveAndFlush(Integer order);

//	List<Orders> findByProducttId(Long productId);

}

/*in this orderRepository interface i am extende jpa repository
basicaly which contain crud operation methods */