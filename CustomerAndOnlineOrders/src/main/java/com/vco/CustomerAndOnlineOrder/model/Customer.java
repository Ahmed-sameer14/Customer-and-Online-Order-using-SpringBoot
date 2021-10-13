package com.vco.CustomerAndOnlineOrder.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

//This is the master class which doesn't contain any foreign key

@Data		//lombok annotations used to avoiding the boiler codes like getters, setters and constructors
@Entity					
@Table(name = "customer")			//mapping the name with data base table
public class Customer implements Serializable  // Annotation that can be used to either suppress serialization of
												// properties (during serialization), or ignore processing of
												//JSON properties read (during deserialization).
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id															//@Id used as a primary key column
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")								//fields present in the date base table
	private int customerId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "date_ofbirth")
	private Date dob;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "mobile_number")
	private long mobile_number;
	
	@Column(name = "email_address")
	private String email_address;
	
	@Column(name = "home_address")
	private String home_address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "zipcode")
	private int zipcode;
	
	@Column(name = "state")
	private String state;
	
	@OneToMany(mappedBy = "orderId",orphanRemoval = true)		//mapping with order table one to many relation ship
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Orders> order;
	

}
