package com.app.bank.user.service.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.user.service.dao.UserCRUDDAO;

public class UserCRUDDAOImplTest {
	UserCRUDDAO test = new UserCRUDDAOImpl();

	@Test
	public void testupCustomer() {
		try {
			assertEquals("Customer account updated successfully", test.upPendCustomer("Approved", 1000));
		} catch (BusinessBankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	public void testgetCustomer() {
		try {
			assertNotNull(test.getCustomer());
		} catch (BusinessBankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testgetusers() {
		try {
			assertNotNull(test.getUsers());
		} catch (BusinessBankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testgetemployees() {
		try {
			assertNotNull(test.getEmployees());
		} catch (BusinessBankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
