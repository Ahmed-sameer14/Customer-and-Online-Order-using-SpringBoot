//package com.vco.CustomerAndOnlineOrder;
//
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.vco.CustomerAndOnlineOrder.model.Product;
//import com.vco.CustomerAndOnlineOrder.repository.ProductRepository;
//@SpringBootTest 
//class ProductTest {
//
//	@Autowired
//	private ProductRepository productRepository;
//	@Test
//	public void createProduct()
//	{
//		Product p = new Product();
//		
//		p.setProductId(19);
//		p.setProductName("oppo");
//		p.setProductDiscription("this is used for vvery good");
//		p.setCategory("mobiles");
//		p.setSubCategory("4gb ram,6gb ram,8gb ram");
//		p.setProductCost("4gb ram:-10000,6gb ram:-12000,8gb ram:-15000");
//		p.setProductPrice("4gb ram:-11000,6gb ram:-14000,8gb ram:-17000");
//		p.setQuantityInHand("4gb ram:- 4pices,6gb ram:- 4pices,8gb ram:- 4pices");
//		productRepository.save(p);
//		assertNotNull(productRepository.findById(19).get());
//	}
//
//}
