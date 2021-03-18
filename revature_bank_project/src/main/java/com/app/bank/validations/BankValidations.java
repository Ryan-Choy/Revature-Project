package com.app.bank.validations;

public class BankValidations {
	
	public static boolean isValidName(String name) {
		if (name != null && name.matches("[a-zA-Z]{3,20}")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidUserName(String username) {
		if(username != null && username.matches("\\w{8,15}")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean isValidPassword(String pass) {
		//[^\s] stands for no whitespace character, prevents spaces from being used
		if(pass != null && pass.matches("\\w{8,15}")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidEmail(String email) {
		if(email != null && email.matches("\\b\\w@\\w.com\\b")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidCustomerId(String customerid) {
		if(customerid != null && customerid.matches("C[0-9]{6}")) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean isValidAccountId(String accountid) {
		if(accountid != null && accountid.matches("A[0-9]{6}")) {
			return true;
		} else {
			return false;
		}
	}

	

}