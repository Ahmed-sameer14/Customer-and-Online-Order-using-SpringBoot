package com.vco.CustomerAndOnlineOrder.payload;

import com.vco.CustomerAndOnlineOrder.model.Orders;

import lombok.Data;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class ResponsePayLoad 
{
	public ResponsePayLoad(int value, String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	public ResponsePayLoad(int value, String string, Orders or) {
		// TODO Auto-generated constructor stub
	}
//	public ResponsePayLoad(int value, String string, Object s) {
//		// TODO Auto-generated constructor stub
//		System.out.println("s is "+s);
//	}
	private int statusCode;
	private String message;
	private Object obj;
	
	 //  can the customer object be mapped into the object reference called obj which is of type Object ?
		// yes
		// reason :: the super class can hold the object of its sub class 
		// Object is the SUPERMOST CLASS
}
