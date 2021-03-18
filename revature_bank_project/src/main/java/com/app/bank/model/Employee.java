package com.app.bank.model;

public class Employee {
	private String employid;
	private String employfirstname;
	private String employlastname;
	private String employusername;
	private String employpass;
	public String getEmployid() {
		return employid;
	}
	public void setEmployid(String employid) {
		this.employid = employid;
	}
	public String getEmployfirstname() {
		return employfirstname;
	}
	public void setEmployfirstname(String employfirstname) {
		this.employfirstname = employfirstname;
	}
	public String getEmploylastname() {
		return employlastname;
	}
	public void setEmploylastname(String employlastname) {
		this.employlastname = employlastname;
	}
	public String getEmployusername() {
		return employusername;
	}
	public void setEmployusername(String employusername) {
		this.employusername = employusername;
	}
	public String getEmploypass() {
		return employpass;
	}
	public void setEmploypass(String employpass) {
		this.employpass = employpass;
	}
	@Override
	public String toString() {
		return "Employee [employid=" + employid + ", employusername=" + employusername + ", employfirstname="
				+ employfirstname + ", employlastname=" + employlastname + "]";
	}
	

	



	
	
}
