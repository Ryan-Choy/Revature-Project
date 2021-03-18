package com.app.bank.model;

public class Account {
	private String id;
	private String accountid;
	private int balance;
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountid=" + accountid + ", balance=" + balance + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}




}
