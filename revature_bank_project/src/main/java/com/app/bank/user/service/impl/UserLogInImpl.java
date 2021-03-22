package com.app.bank.user.service.impl;

import org.apache.log4j.Logger;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;
import com.app.bank.model.Employee;
import com.app.bank.user.service.UserLogIn;
import com.app.bank.user.service.dao.UserLogInDAO;
import com.app.bank.user.service.dao.impl.UserLogInDAOImpl;
import com.app.bank.validations.BankValidations;

public class UserLogInImpl implements UserLogIn {

	private UserLogInDAO userlogin = new UserLogInDAOImpl();

	@Override
	public Customer customerLogIn(String username, String userpassword) throws BusinessBankException {
		if (!BankValidations.isValidUserName(username)) {
			throw new BusinessBankException("Entered user name " + username + " is invalid.");
		}
		if (!BankValidations.isValidPassword(userpassword)) {
			throw new BusinessBankException("Entered password " + userpassword + " is invalid.");
		}
		return userlogin.customerLogIn(username, userpassword);
	}

	@Override
	public Employee employeeLogIn(String username, String userpassword) throws BusinessBankException {
		if (!BankValidations.isValidUserName(username)) {
			throw new BusinessBankException("Entered user name " + username + " is invalid.");
		}
		if (!BankValidations.isValidPassword(userpassword)) {
			throw new BusinessBankException("Entered password " + userpassword + " is invalid.");
		}
		return null;
	}

}
