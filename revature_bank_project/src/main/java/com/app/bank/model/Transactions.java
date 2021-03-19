package com.app.bank.model;

public class Transactions {
	private String transacdate;
	private int customerid;
	private int accountid;
	private int targetid;
	private int trasacamount;
	private String transacstatus;
	
	
	
	public Transactions(String transacdate, int customerid, int accountid, int targetid, int trasacamount,
			String transacstatus) {
		super();
		this.transacdate = transacdate;
		this.customerid = customerid;
		this.accountid = accountid;
		this.targetid = targetid;
		this.trasacamount = trasacamount;
		this.transacstatus = transacstatus;
	}
	@Override
	public String toString() {
		return "Transactions [transacdate=" + transacdate + ", customerid=" + customerid + ", accountid=" + accountid
				+ ", targetid=" + targetid + ", trasacamount=" + trasacamount + ", transacstatus=" + transacstatus
				+ "]";
	}
	public String getTransacdate() {
		return transacdate;
	}
	public void setTransacdate(String transacdate) {
		this.transacdate = transacdate;
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
	public int getTargetid() {
		return targetid;
	}
	public void setTargetid(int targetid) {
		this.targetid = targetid;
	}
	public int getTrasacamount() {
		return trasacamount;
	}
	public void setTrasacamount(int trasacamount) {
		this.trasacamount = trasacamount;
	}
	public String getTransacstatus() {
		return transacstatus;
	}
	public void setTransacstatus(String transacstatus) {
		this.transacstatus = transacstatus;
	}
	
	
}
