package com.app.bank.customer.service.dao;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;

public interface CustomerCreationDAO {
	public int createCustomer(Customer customer) throws BusinessBankException;
}
