package com.solutioniabd.beans;

import java.util.List;

import javax.ejb.Local;

import com.solutioniabd.entity.Customer;
import com.solutioniabd.entity.Customeraddress;

@Local
public interface CustomerServiceLocal {
	public void createCustomer(Customer customer,Customeraddress customeraddress);
	public void updateCustomer(Customer customer,Customeraddress customeraddress);
	public void deleteCustomer(int customerId, int addressId);
	public List<Customer> listCustomer();
}
