package com.vco.CustomerAndOnlineOrder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vco.CustomerAndOnlineOrder.model.Product;
import com.vco.CustomerAndOnlineOrder.repository.ProductRepository;


@Service("ProductService")
public class ProductServiceImp implements ProductService
{
	@Qualifier("productRepository")
    @Autowired
    private ProductRepository productRepository;

	@Override
	public String saveProduct(Product product) {
		productRepository.saveAndFlush(product);
	        return "Product Added Sucessfully";
	}


	@Override
	public List<Product> findAllProduct(Integer product) {
		// TODO Auto-generated method stub
		 return productRepository.findAll();
	}


	@Override
	public Product findProductById(Integer productId) {
		// TODO Auto-generated method stub
		return ((ProductServiceImp) productRepository).findProductById(productId);
	}


	@Override
	public String updateProduct(Integer product) {
		productRepository.saveAndFlush(product);
			return "Product Updated Succesfully";
	}

	@Override
	public String deleteProduct(Integer id) {
		@SuppressWarnings("deprecation")
		Product product = productRepository.getOne(id);
		productRepository.saveAndFlush(product);
		return "Product Deleted Sucessfully";
	}
}
