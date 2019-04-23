package com.solutioniabd.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import com.solutioniabd.beans.CustomerServiceLocal;
import com.solutioniabd.entity.Car;
import com.solutioniabd.entity.Customer;
import com.solutioniabd.entity.Customeraddress;

@Named
@RequestScoped
public class CustomerController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	CustomerServiceLocal customerService;
	
	// Models
	private Customer customer = new Customer();

	private Customeraddress customeraddress= new Customeraddress();
	
	// Fields 
	
	private List<Customer> listOfCustomers;
	
	

	@PostConstruct
	public void init() {
		
		System.out.println("CustomerManagement instantiated");
		listOfCustomers= customerService.listCustomer();
			
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
		
		System.out.println("--------------Saving Customer------------");
		try{
			customerService.createCustomer(customer,customeraddress);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			context.addMessage(null, new FacesMessage("Successful","User created!"));
			listOfCustomers=customerService.listCustomer();
			
		}
		
	}
	
	// Helper Methods (Should be in different class)
	
	public void clearCustomerForm() {
		customer.setCustomerName(null);
	}
	
	// Buttons and Events
	
	 public void onRowEdit(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Car Edited");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        Customer customer = (Customer) event.getObject();
	        Customeraddress cusAddress =(Customeraddress) customer.getCustomeraddresses();
	        customerService.updateCustomer(customer,cusAddress);
	        listOfCustomers=customerService.listCustomer();
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Edit Cancelled");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	    
	    public void onRowDelete(int customerId,int addressId) {
	    	customerService.deleteCustomer(customerId, addressId);
	    	listOfCustomers=customerService.listCustomer();
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

	public List<Customer> getListOfCustomers() {
		
		return listOfCustomers;
		
	}

		
}
