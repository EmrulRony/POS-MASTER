package com.solutioniabd.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
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
@ViewScoped
public class CustomerManagement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	CustomerServiceLocal customerService;
	private Customer customer = new Customer();
	private Customeraddress customeraddress = new Customeraddress();
	
	@PostConstruct
	public void init() {
		System.out.println("CustomerManagement instantiated");
	}
	
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
	public void saveCustomer() {
		FacesContext  context = FacesContext.getCurrentInstance();
		
		customer.setCustomeraddresses(customeraddress);
		customeraddress.setCustomer(customer);
		System.out.println("--------------Saving Customer------------");
		try{
			customerService.createCustomer(customer,customeraddress);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			context.addMessage(null, new FacesMessage("Successful","User created!"));
			clearCustomerForm();
		}
		
	}
	
	public void clearCustomerForm() {
		customer.setCustomerName(null);
	}
		
}
