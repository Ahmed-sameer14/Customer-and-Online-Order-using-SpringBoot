package com.vco.CustomerAndOnlineOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vco.CustomerAndOnlineOrder.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	static Object print() {
		// TODO Auto-generated method stub
		return null;
	}

//	boolean existsById(Product productId);

}

/*in this productRepo interface i am extende jpa repository
basicaly which contain crud operation methods */