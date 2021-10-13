package com.vco.CustomerAndOnlineOrder.payload;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vco.CustomerAndOnlineOrder.model.Orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//this class is connected with orderservice class

@Data
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class PayLoadOrder implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer productId;			//this class is directaly connected with order service here i am getting the fk of productId and customerId
	private Integer customerId;
	private Orders order;
	public int getProductId() {
		// TODO Auto-generated method stub
		return this.productId;
	}
	public int getCustomerId() {
		// TODO Auto-generated method stub
		return this.customerId;
	}
	public Orders getOrder() {
		// TODO Auto-generated method stub
		return this.order;
	}
	
	// this Payload is to hold the result after inserting the data referred in TWO tables
}
