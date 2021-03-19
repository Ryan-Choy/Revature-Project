package com.app.bank.model;

public class User {
	private String firstname;
	private String lastname;
	private String username;
	private String userpassword;
	private String usertype;
	
	public User(String firstname, String lastname, String username, String userpassword, String usertype) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.userpassword = userpassword;
		this.usertype = usertype;
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
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", userpassword="
				+ userpassword + ", usertype=" + usertype + "]";
	}
	

	

}
