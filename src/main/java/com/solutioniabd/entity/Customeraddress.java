package com.solutioniabd.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customeraddress database table.
 * 
 */
@Entity
@NamedQuery(name="Customeraddress.findAll", query="SELECT c FROM Customeraddress c")
public class Customeraddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;

	private String area;

	@Column(name="house_no")
	private String houseNo;

	@Column(name="postal_code")
	private int postalCode;

	private String road;

	
	@OneToOne(mappedBy="customeraddresses")
	private Customer customer;

	public Customeraddress() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getHouseNo() {
		return this.houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public int getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getRoad() {
		return this.road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}