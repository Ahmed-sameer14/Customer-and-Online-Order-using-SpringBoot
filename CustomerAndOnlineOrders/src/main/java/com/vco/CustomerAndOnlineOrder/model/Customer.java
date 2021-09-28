package com.vco.CustomerAndOnlineOrder.model;

import java.io.Serializable;
import java.sql.Date;
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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//this is the master class which doesn't contain any foreign key

//@Data
@Entity											
//@AllArgsConstructor							//lombok annotations used to avoiding the boiler codes
//@Getter
//@Setter
//@NoArgsConstructor
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
	
//	@OneToOne
//    private Shipment shipment;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getHome_address() {
		return home_address;
	}

	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<Orders> getOrder() {
		return order;
	}

	public void setOrder(Set<Orders> order) {
		this.order = order;
	}
	
}
