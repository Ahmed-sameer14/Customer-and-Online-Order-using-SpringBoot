package com.vco.CustomerAndOnlineOrder.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

//This is my transaction table which has two fk productId and customerId

@Data				//lombok annotations used to avoiding the boiler codes like getters, setters and constructors
@Entity							
@Table(name = "customer_order")			//mapping the name with data base table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 		/*SpringApplication allows an application to be initialized lazily. When lazy initialization is enabled,
																	beans are created as they are needed rather than during application startup.*/
public class Orders implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id			//@Id used as a primary key column
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")			
	private int orderId;			//fields present in the data base table
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)	//Relationship of many to one which contain product table pk as fk for reference
    @JoinColumn(name = "product_id",nullable = false)
//	 @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnoreProperties
	private Product productId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)	//Relationship of many to one which contain customer table pk as fk for reference
	@JoinColumn(name = "ccustomer_id",nullable = false)
//	 @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnoreProperties
    private Customer customerId;
	
	@CreatedDate
	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "total_item")
	private int totalItem;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	@Column(name = "payment_method")
	private String paymentMethod;
}
