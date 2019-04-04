package com.solutioniabd.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.solutioniabd.beans.CustomerServiceLocal;
import com.solutioniabd.entity.Customer;

@Named
@ViewScoped
public class CustomerManagement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	CustomerServiceLocal customerService;
	
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void saveCustomer() {
		try{
			customerService.createCustomer(customer);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
		
}
