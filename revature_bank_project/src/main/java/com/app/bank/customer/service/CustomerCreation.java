package com.app.bank.customer.service;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;

public interface CustomerCreation {
	
	public int createCustomer(Customer customer) throws BusinessBankException;

}
