package com.nt.service;

import java.util.List; 

import com.nt.entity.Customer;

public interface ICustomerMgmtService {
	
	public String registerCustomer(Customer cust);
	public Boolean isCustomerAvailable(int id);
	public long showCustomerCount();
	public Iterable<Customer> showAllCustomers();
	public Iterable<Customer> showAllCustomersByIds(Iterable<Integer> ids);
	public String registerGroupCustomer(List<Customer> custList);
	public Customer showCustomerById(int id);
	public String registerOrUpdateCustomer(Customer cust);
	public String updateCustomerAddress(int cno, String newAddress);
	public String removeCustomerById(int cno);
	public String removeCustomer(Customer cust);
	

}
