package com.app.bank.user.service.dao;

import java.util.List;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;
import com.app.bank.model.Employee;
import com.app.bank.model.User;

public interface UserCRUDDAO {
	public int createCustomer(User user, Customer customer) throws BusinessBankException;
	public List<Customer> getCustomer() throws BusinessBankException;
	public List<User> getUsers() throws BusinessBankException;
	public List<Employee> getEmployees() throws BusinessBankException;
	public String upPendCustomer(String statup, int cid) throws BusinessBankException;

	



}
