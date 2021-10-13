package com.vco.CustomerAndOnlineOrder.service;

import java.util.List;

import com.vco.CustomerAndOnlineOrder.model.Product;

public interface ProductService {
String saveProduct(Product product);
	
	List<Product> findAllProduct(Integer product);
	
	Product findProductById(Integer productId);
	
	String updateProduct(Integer product);
	
	 String deleteProduct(Integer id);
}
