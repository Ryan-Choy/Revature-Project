package com.app.bank.model;

public class Account {
	private int customerid;
	private int accountid;
	private int balance;
	private String accountstatus;
	
	
	public Account(int id, int accountid, int balance, String accountstatus) {
		super();
		this.customerid = id;
		this.accountid = accountid;
		this.balance = balance;
		this.accountstatus = accountstatus;
	}

	@Override
	public String toString() {
		return "Account [customerid=" + customerid + ", accountid=" + accountid + ", balance=" + balance
				+ ", accountstatus=" + accountstatus + "]";
	}

	public int getId() {
		return customerid;
	}
	public void setId(int id) {
		this.customerid = id;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAccountstatus() {
		return accountstatus;
	}
	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}




}
