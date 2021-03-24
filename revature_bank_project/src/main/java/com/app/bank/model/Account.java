package com.app.bank.model;

import java.math.BigDecimal;


public class Account {
	private int customerid;
	private int accountid;
	private BigDecimal balance;
	private String accountstatus;
	
	

	public Account() {
		// TODO Auto-generated constructor stub
	}



	public Account(int customerid, int accountid, BigDecimal balance, String accountstatus) {
		super();
		this.customerid = customerid;
		this.accountid = accountid;
		this.balance = balance;
		this.accountstatus = accountstatus;
	}



	@Override
	public String toString() {
		return "Account [customerid=" + customerid + ", accountid=" + accountid + ", balance=" + balance
				+ ", accountstatus=" + accountstatus + "]";
	}



	public int getCustomerid() {
		return customerid;
	}



	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}



	public int getAccountid() {
		return accountid;
	}



	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}



	public BigDecimal getBalance() {
		return balance;
	}



	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}



	public String getAccountstatus() {
		return accountstatus;
	}



	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}





}
