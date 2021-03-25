package com.app.bank.user.service.dao.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.user.service.dao.AccountCRUDDAO;


public class AccountCRUDDAOImplTest {
	
	
	AccountCRUDDAO test = new AccountCRUDDAOImpl();
	@Test
	public void test() {
		try {
			assertNull(test.getBankAccount());
		} catch (BusinessBankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
