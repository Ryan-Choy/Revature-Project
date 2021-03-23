package com.app.bank.user.service;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;
import com.app.bank.model.Employee;

public interface UserLogIn {
	
	public Customer customerLogIn(String username, String userpassword) throws BusinessBankException;
	
	public Employee employeeLogIn(String employname, String employpassword) throws BusinessBankException;

}
