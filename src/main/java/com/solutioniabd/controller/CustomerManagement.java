package com.solutioniabd.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.solutioniabd.beans.CustomerServiceLocal;
import com.solutioniabd.entity.Customer;
import com.solutioniabd.entity.Customeraddress;

@Named
@RequestScoped
public class CustomerManagement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	CustomerServiceLocal customerService;
	
	// Models
	@Inject
	private Customer customer;
	@Inject
	private Customeraddress customeraddress;
	
	// Fields 
	
	private String customerName;
	private int customerNumber;
	

	@PostConstruct
	public void init() {
		
		System.out.println("CustomerManagement instantiated");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy method called!!");
	}
	
	
	
	// 
	public void saveCustomer() {
		FacesContext  context = FacesContext.getCurrentInstance();
		
		customer.setCustomeraddresses(customeraddress);
		customeraddress.setCustomer(customer);
		
		customer.setCustomerName(customerName);
		customer.setCustomerPhone(customerNumber);
		System.out.println("--------------Saving Customer------------");
		try{
			customerService.createCustomer(customer,customeraddress);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			context.addMessage(null, new FacesMessage("Successful","User created!"));
			
		}
		
	}
	
	// Helper Methods (Should be in different class)
	
	public void clearCustomerForm() {
		customer.setCustomerName(null);
	}
	
	// Getters and setters
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customeraddress getCustomeraddress() {
		return customeraddress;
	}
	public void setCustomeraddress(Customeraddress customeraddress) {
		this.customeraddress = customeraddress;
	}
	
	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public int getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
		
}
