package com.app.bank.customer.service.dao;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.User;

public interface CustomerCreationDAO {
	public int createCustomer(User customer) throws BusinessBankException;
}
