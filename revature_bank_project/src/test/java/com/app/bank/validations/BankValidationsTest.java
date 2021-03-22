package com.app.bank.validations;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankValidationsTest {

	@Test
	public void testisValidEmail() {
		assertEquals(true, BankValidations.isValidEmail("rchoy1@gmail.com"));
	}
	
	@Test
	public void testisValidPhone() {
		assertEquals(true, BankValidations.isValidPhone("+1-9995553322"));
	}
}
