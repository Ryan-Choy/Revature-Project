package com.app.bank.user.service.dao.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.user.service.dao.AccountCRUDDAO;


public class AccountCRUDDAOImplTest {
	
	
	AccountCRUDDAO test = new AccountCRUDDAOImpl();
	@Test
	public void testgetbank() {
		try {
			assertNotNull(test.getBankAccount());
		} catch (BusinessBankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testgettransac() {
		try {
			assertNotNull(test.getTransac());
		} catch (BusinessBankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testaccountProcess() {
//		try {
//			assertEquals("Bank account processed successfully", test.accountProcess("Pending", 500));
//		} catch (BusinessBankException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			assertEquals("Bank account processed successfully", test.accountProcess("Approved", 1000));
		} catch (BusinessBankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testupdatetransac() {
		try {
			assertEquals("Transaction processed successfully", test.updateTransac("Approved", 1000));
		} catch (BusinessBankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testaccountupdate() {
		try {
			assertEquals("Bank account updated successfully", test.accountUpdate(1000, new BigDecimal(100.00)));
		} catch (BusinessBankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testcreatebankaccount() {
		try {
			assertEquals(1, test.createBankAccount(null, 1000));
		} catch (BusinessBankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
