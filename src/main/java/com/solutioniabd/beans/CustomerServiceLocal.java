package com.solutioniabd.beans;

import java.util.List;

import javax.ejb.Local;

import com.solutioniabd.entity.Customer;

@Local
public interface CustomerServiceLocal {
	public void createCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(int customerId);
	public List<Customer> listCustomer();
}
