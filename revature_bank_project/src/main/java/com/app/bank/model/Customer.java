package com.app.bank.model;

public class Customer {
	private int customerid;
	private String city;
	private String state;
	private String phone;
	private String email;
	private String usertype;
	private String customerstatus;
	private String firstname;
	private String lastname;
	private String username;
	
	
	public Customer(int customerid, String city, String state, String phone, String email, String usertype,
			String customerstatus, String firstname, String lastname, String username) {
		super();
		this.customerid = customerid;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.email = email;
		this.usertype = usertype;
		this.customerstatus = customerstatus;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", username=" + username + ", city=" + city + ", state=" + state + ", phone=" + phone + ", email="
				+ email + ", usertype=" + usertype + ", customerstatus=" + customerstatus + "]";
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
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getCustomerstatus() {
		return customerstatus;
	}
	public void setCustomerstatus(String customerstatus) {
		this.customerstatus = customerstatus;
	}
	
	
}
