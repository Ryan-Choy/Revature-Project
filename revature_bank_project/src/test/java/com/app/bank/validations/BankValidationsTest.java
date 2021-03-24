package com.app.bank.validations;

import static org.junit.Assert.*;

import java.math.BigDecimal;

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
	
	@Test
	public void testisValidBalance() {
		assertEquals(true, BankValidations.isValidBalance(new BigDecimal("100")));
	}
}
