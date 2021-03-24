package com.app.bank.user.service;

import java.util.List;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;
import com.app.bank.model.Employee;
import com.app.bank.model.User;

public interface UserCRUD {
	//create customer account
	public int createCustomer(User user, Customer customer) throws BusinessBankException;
	
	//get customer accounts
	public List<Customer> getCustomer() throws BusinessBankException;
	
	//get list of users
	public List<User> getUsers() throws BusinessBankException;
	
	//get list of employees
	public List<Employee> getEmployees() throws BusinessBankException;

	//update pending customer accounts
	public String upPendCustomer(String statup, int cid) throws BusinessBankException;
	

}
