package com.solutioniabd.beans;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.solutioniabd.entity.Customer;

@Stateless
public class CustomerService implements CustomerServiceLocal {
	@PersistenceContext
	EntityManager em;

	@Override
	public void createCustomer(Customer customer) {
		em.persist(customer);
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
		// TODO Auto-generated method stub
		return null;
	}
	

}
