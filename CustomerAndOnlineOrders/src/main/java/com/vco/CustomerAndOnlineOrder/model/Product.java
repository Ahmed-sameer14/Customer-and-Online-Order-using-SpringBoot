package com.vco.CustomerAndOnlineOrder.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//this is the master class which doesn't contain any foreign key

@Entity
//@AllArgsConstructor
//@Getter							//lombok annotations used to avoiding the boiler codes
//@Setter
//@NoArgsConstructor
@Table(name = "product")						//mapping the name with data base table
public class Product implements Serializable	// Annotation that can be used to either suppress serialization of
												// properties (during serialization), or ignore processing of
												//JSON properties read (during deserialization).
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "product_id")
	private int productId;
	 
	 @Column(name = "product_name")
	private String productName;
	 
	 @Column(name = "product_discription")
	private String productDiscription;
	 
	 @Column(name = "category")
	private String category;
	 
	 @Column(name = "sub_category")
	private String subCategory;
	 
	 @Column(name = "qty_in_hand")
	private String quantityInHand;
	
	 @Column(name = "product_cost")
	private String productCost;
	 
	 @Column(name = "product_price")
	private String productPrice;
	 											//mapping with order table one to many relation ship
	 @OneToMany(mappedBy = "orderId",orphanRemoval = true)
	 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 private Set<Orders> order;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDiscription() {
		return productDiscription;
	}

	public void setProductDiscription(String productDiscription) {
		this.productDiscription = productDiscription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getQuantityInHand() {
		return quantityInHand;
	}

	public void setQuantityInHand(String quantityInHand) {
		this.quantityInHand = quantityInHand;
	}

	public String getProductCost() {
		return productCost;
	}

	public void setProductCost(String productCost) {
		this.productCost = productCost;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public Set<Orders> getOrder() {
		return order;
	}

	public void setOrder(Set<Orders> order) {
		this.order = order;
	}
	
}
