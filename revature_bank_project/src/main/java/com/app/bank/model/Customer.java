package com.app.bank.model;

public class Customer {
	private int customerid;
	private String city;
	private String state;
	private String phone;
	private String email;
	private String usertype;
	private String customerstatus;
	
	
	public Customer(int customerid, String city, String state, String phone, String email, String usertype,
			String customerstatus) {
		super();
		this.customerid = customerid;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.email = email;
		this.usertype = usertype;
		this.customerstatus = customerstatus;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", city=" + city + ", state=" + state + ", phone=" + phone
				+ ", email=" + email + ", usertype=" + usertype + ", customerstatus=" + customerstatus + "]";
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
