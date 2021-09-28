package com.vco.CustomerAndOnlineOrder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.vco.CustomerAndOnlineOrder.controller.ProductController;
import com.vco.CustomerAndOnlineOrder.model.Product;
import com.vco.CustomerAndOnlineOrder.repository.ProductRepository;
@SpringBootTest 
//@TestMethodOrder(OrderAnnotation.class)
class CustomerAndOnlineOrderApplicationTests 
{
	
	@Autowired
	private ProductRepository productRepository;
	
//	@Test
//	//@Order(1)
//public void testCreate()
//{
//		
//		CompanyDTO c=new CompanyDTO();
//		c.setCompanyId(16);
//		c.setCompanyName("HP");
//		c.setCompanyPhoneNo(12567);
//		c.setCompanyEmail("HP@gmail.com");
//		c.setCompanyAddress("BANGLORE");
//		companyrepository.save(c);
//		assertNotNull(companyrepository.findById(15).get());
//		
//}
	
	@Test
	@Order(1)
	public void createProduct()
	{
		Product p = new Product();
		
		p.setProductId(66);
		p.setProductName("oppo");
		p.setProductDiscription("this is used for vvery good");
		p.setCategory("mobiles");
		p.setSubCategory("4gb ram,6gb ram,8gb ram");
		p.setProductCost("4gb ram:-10000,6gb ram:-12000,8gb ram:-15000");
		p.setProductPrice("4gb ram:-11000,6gb ram:-14000,8gb ram:-17000");
		p.setQuantityInHand("4gb ram:- 4pices,6gb ram:- 4pices,8gb ram:- 4pices");
		productRepository.save(p);
		assertNotNull(productRepository.findById(65).get());
	}
	
	@Test
	@Order(2)
	public void tesrReadAll()
	{
		List<Product> list = productRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testSingleProduct()
	{
		Product p = productRepository.findById(10).get();
		assertEquals("oppo", p.getProductName());
	}
	@Test
	@Order(4)
	public void testUpdate() {
		Product p=productRepository.findById(40).get();
		p.setProductDiscription("this is a very demanding product");
		productRepository.save(p);
		assertNotNull("this is a very demanding product",productRepository.findById(40).get().getProductDiscription());
	}
	@Test
	@Order(5)
	public void testDelete() {
		productRepository.deleteById(40);
		assertThat(productRepository.existsById(40)).isFalse();
	}
}
