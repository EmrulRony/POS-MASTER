package com.solutioniabd.entity;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.*;

/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@Table(name = "customer")
@NamedQueries({ @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
		@NamedQuery(name = "Customer.findAll.join.CustomerAddress", query = "SELECT c FROM Customer c JOIN c.customeraddresses ca") }
)

@Named
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "customer_email")
	private String customerEmail;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_phone")
	private int customerPhone;

	@OneToOne(mappedBy = "customer")
	private Customeraddress customeraddresses;

	public Customer() {
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerEmail() {
		return this.customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(int customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Customeraddress getCustomeraddresses() {
		return customeraddresses;
	}

	public void setCustomeraddresses(Customeraddress customeraddresses) {
		this.customeraddresses = customeraddresses;
	}

}