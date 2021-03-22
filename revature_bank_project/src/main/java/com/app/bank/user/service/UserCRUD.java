package com.app.bank.user.service;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;
import com.app.bank.model.User;

public interface UserCRUD {
	//create customer account, bank account
	public int createCustomer(User user, Customer customer) throws BusinessBankException;

}
