package com.app.bank.user.service.impl;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;
import com.app.bank.model.User;
import com.app.bank.user.service.UserCRUD;
import com.app.bank.user.service.dao.UserCRUDDAO;
import com.app.bank.user.service.dao.impl.UserCRUDDAOImpl;
import com.app.bank.validations.BankValidations;

public class UserCRUDImpl implements UserCRUD {

	private UserCRUDDAO usercruddao = new UserCRUDDAOImpl();

	@Override
	public int createCustomer(User user, Customer customer) throws BusinessBankException {

		if (!BankValidations.isValidName(user.getFirstname())) {
			throw new BusinessBankException("Entered first name " + user.getFirstname() + " is invalid");
		}
		if (!BankValidations.isValidName(user.getLastname())) {
			throw new BusinessBankException("Entered last name " + user.getLastname() + " is invalid");
		}
		if (!BankValidations.isValidUserName(user.getUsername())) {
			throw new BusinessBankException("Entered user name " + user.getUsername() + " is invalid.");
		}
		if (!BankValidations.isValidPassword(user.getUserpassword())) {
			throw new BusinessBankException("Entered password " + user.getUserpassword() + " is invalid.");
		}
		if (!BankValidations.isValidCity(customer.getCity())) {
			throw new BusinessBankException("Entered city " + customer.getCity() + " is invalid.");
		}
		if (!BankValidations.isValidState(customer.getState())) {
			throw new BusinessBankException("Entered state "+ customer.getState()+ " is invalid.");
		}
		if(!BankValidations.isValidPhone(customer.getPhone())) {
			throw new BusinessBankException("Entered phone number "+customer.getPhone()+ " is invalid.");
		}
	
		

		return usercruddao.createCustomer(user, customer);

	}

}
