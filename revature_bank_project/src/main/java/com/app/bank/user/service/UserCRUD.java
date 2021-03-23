package com.app.bank.user.service;

import java.util.List;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;
import com.app.bank.model.User;

public interface UserCRUD {
	//create customer account
	public int createCustomer(User user, Customer customer) throws BusinessBankException;
	
	//get pending customer accounts
	public List<Customer> getPendCustomer() throws BusinessBankException;
	
	//update pending customer accounts
	public String upPendCustomer(String statup) throws BusinessBankException;
	

}
