package com.solutioniabd.beans;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.enterprise.inject.Typed;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.solutioniabd.entity.Customer;
import com.solutioniabd.entity.Customeraddress;

@Stateless
public class CustomerService implements CustomerServiceLocal {
	@PersistenceContext
	EntityManager em;

	@Override
	public void createCustomer(Customer customer,Customeraddress customeraddress) {
		em.persist(customer);
		em.persist(customeraddress);
		em.flush();
		System.out.println("----------Customer Saved!!--------------");
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> listCustomer() {
		TypedQuery<Customer> query=em.createNamedQuery("Customer.findAll.join.CustomerAddress", Customer.class);
		List<Customer> customerList=query.getResultList();
		return customerList;
	}
	

}
