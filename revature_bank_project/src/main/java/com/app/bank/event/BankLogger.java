package com.app.bank.event;

import org.apache.log4j.Logger;

public class BankLogger {
	private static Logger write = Logger.getLogger(BankLogger.class);
	
	public void customerAccountmake() {
		write.debug("Customer account created");
	}
	public void custAccountProcess() {
		write.debug("Customer account processed");
	}
	
	public void bankAccountmake() {
		write.debug("Bank account created");
	}
	
	public void bankAccountProcess() {
		write.debug("Bank account processed");
	}
	public void withdrawMake() {
		write.debug("Withdraw action made");
	}
	public void depositMake() {
		write.debug("Deposit action made");
	}
	public void transacMake() {
		write.debug("Transaction made");
	}
	public void transacProcess() {
		write.debug("Transaction processed");
	}

}
