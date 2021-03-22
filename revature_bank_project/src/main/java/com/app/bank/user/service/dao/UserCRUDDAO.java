package com.app.bank.user.service.dao;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;
import com.app.bank.model.User;

public interface UserCRUDDAO {
	public int createCustomer(User user, Customer customer) throws BusinessBankException;
}
