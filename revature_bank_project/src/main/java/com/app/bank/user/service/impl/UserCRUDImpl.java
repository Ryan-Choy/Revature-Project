package com.app.bank.user.service.impl;

import java.util.List;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;
import com.app.bank.model.Employee;
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

	@Override
	public List<Customer> getCustomer() throws BusinessBankException {
		
		return usercruddao.getCustomer();
	}

	@Override
	public String upPendCustomer(String statup, int cid) throws BusinessBankException {
		
		if(!BankValidations.isValidUpdate(statup)) {
			throw new BusinessBankException("Entered status "+ statup +" is invalid.");
		}

		return usercruddao.upPendCustomer(statup, cid);
	}

	@Override
	public List<User> getUsers() throws BusinessBankException {
		// TODO Auto-generated method stub
		return usercruddao.getUsers();
	}



	@Override
	public List<Employee> getEmployees() throws BusinessBankException {
		// TODO Auto-generated method stub
		return usercruddao.getEmployees();
	}



}
