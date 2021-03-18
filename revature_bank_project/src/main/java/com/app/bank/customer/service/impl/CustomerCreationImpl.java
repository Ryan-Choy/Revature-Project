package com.app.bank.customer.service.impl;

import com.app.bank.customer.service.CustomerCreation;
import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;
import com.app.bank.validations.BankValidations;

public class CustomerCreationImpl implements CustomerCreation {

	@Override
	public int createCustomer(Customer customer) throws BusinessBankException {

		if (!BankValidations.isValidName(customer.getFirstname())) {
			throw new BusinessBankException("Entered first name " + customer.getFirstname() + " is invalid");
		}
		if (!BankValidations.isValidName(customer.getLastname())) {
			throw new BusinessBankException("Entered last name " + customer.getLastname() + " is invalid");
		}

		if (!BankValidations.isValidUserName(customer.getUsername())) {
			throw new BusinessBankException("Entered user name " + customer.getUsername()
					+ " is invalid, please enter a username that is in the correct format.");
		}
		if (!BankValidations.isValidPassword(customer.getPassword())) {
			throw new BusinessBankException("Entered password " + customer.getPassword()
					+ " is invalid, please enter a password that is in the correct format.");
		}
		
		if (!BankValidations.isValidEmail(customer.getEmail())) {
			throw new BusinessBankException("Entered email " + customer.getEmail()
					+ " is invalid, please enter an email that is in the correct format.");
		}
		

		return 0;

	}

}
