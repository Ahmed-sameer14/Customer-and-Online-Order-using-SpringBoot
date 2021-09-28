package com.vco.CustomerAndOnlineOrder.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//this is my transaction table which has two fk  orderId and suctomerId

@Entity
//@AllArgsConstructor
//@Getter						//lombok annotations used to avoiding the boiler codes
//@Setter
//@NoArgsConstructor
@Table(name = "order_shipment")		//mapping the name with data base table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 		// Annotation that can be used to either suppress serialization of
																	// properties (during serialization), or ignore processing of
																	//JSON properties read (during deserialization).
public class Shipment  implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id			//@Id used as a primary key column
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shipment_id")
	private int shipmentId;		//fields present in the date base table
	
	@OneToOne
    @JoinColumn(name = "order_id", nullable = false)		//relation ship of one to one which contain order table pk as fk for reference
	private Orders orderId;
	
	@OneToOne
    @JoinColumn(name = "customer_id", nullable = false)		//relation ship of one to one which contain customer table pk as fk for reference
	private Customer customerId;
	
	@Column(name = "dispatch_date")
	private Date dispatchDate;
	
	@Column(name = "order_status")
	private String orderStatus;
	
	@Column(name = "recieve_date")
	private Date recieveDate;
	
	public Shipment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public Orders getOrderId() {
		return orderId;
	}

	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public Date getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getRecieveDate() {
		return recieveDate;
	}

	public void setRecieveDate(Date recieveDate) {
		this.recieveDate = recieveDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
