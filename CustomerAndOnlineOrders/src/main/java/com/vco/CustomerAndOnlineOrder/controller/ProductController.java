package com.vco.CustomerAndOnlineOrder.controller;


//import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vco.CustomerAndOnlineOrder.exception.ResourceNotFoundException;
import com.vco.CustomerAndOnlineOrder.model.Product;
import com.vco.CustomerAndOnlineOrder.repository.ProductRepository;

/* this is the master class controller which has crud methods*/

@RestController			//rest controller annotation which mentions the class contain crud type operation
@RequestMapping("/api/productTable")	//requesting url

public class ProductController {

	@Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")		//this method is used for fetching the all record present in the database product table
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")		//this method is used for fetching the perticuler one record present in the database of product table
    public ResponseEntity<Product> getProductById(
    @PathVariable(value = "id") Integer ProductId) throws ResourceNotFoundException {
        Product product = productRepository.findById(ProductId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ ProductId));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/products")		//this method is used for updating the one perticuler record present inthe database of product table
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/product/{id}")	//this put method is use for updating the one perticuler record
    public ResponseEntity<Product> updateProduct(
    @PathVariable(value = "id") Integer ProductId,
    @Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
         Product product = productRepository.findById(ProductId)
          .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ ProductId));
         
         product.setProductName(productDetails.getProductName());
         product.setCategory(productDetails.getCategory());
         product.setProductCost(productDetails.getProductCost());
         product.setProductDiscription(productDetails.getProductDiscription());
        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
   }

   @DeleteMapping("/product/{id}")	//this delete method is use for deleting the one perticuler record
   public Map<String, Boolean> deleteProduct(
       @PathVariable(value = "id") Integer ProductId) throws Exception {
       Product product = productRepository.findById(ProductId)
          .orElseThrow(() -> new ResourceNotFoundException("product not found on :: "+ ProductId));

       productRepository.delete(product);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
   }
}
