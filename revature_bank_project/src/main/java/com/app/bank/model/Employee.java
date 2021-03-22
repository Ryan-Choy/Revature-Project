package com.app.bank.model;

public class Employee {
	private String employid;
	private String firstname;
	private String lastname;
	private String username;
	
	public Employee(String employid, String firstname, String lastname, String username) {
		super();
		this.employid = employid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [employid=" + employid + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + "]";
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmployid() {
		return employid;
	}
	public void setEmployid(String employid) {
		this.employid = employid;
	}


	
	
}
