package com.app.bank.customer.service;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.User;

public interface CustomerCRUD {
	//create customer account, bank account
	public int createCustomer(User customer) throws BusinessBankException;

}
