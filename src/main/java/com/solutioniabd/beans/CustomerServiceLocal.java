package com.solutioniabd.beans;

import java.util.List;

import javax.ejb.Local;

import com.solutioniabd.entity.Customer;
import com.solutioniabd.entity.Customeraddress;

@Local
public interface CustomerServiceLocal {
	public void createCustomer(Customer customer,Customeraddress customeraddress);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(int customerId);
	public List<Customer> listCustomer();
}
