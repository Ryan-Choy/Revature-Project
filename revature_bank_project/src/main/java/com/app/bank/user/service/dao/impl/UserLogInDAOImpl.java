package com.app.bank.user.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.app.bank.dao.dbutil.BankConnection;
import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;
import com.app.bank.model.Employee;
import com.app.bank.user.service.dao.UserLogInDAO;

public class UserLogInDAOImpl implements UserLogInDAO {
	
	@Override
	public Customer customerLogIn(String username, String userpassword) throws BusinessBankException{
		Customer customer = null;
		
		try(Connection connection = BankConnection.getConnection()){
			String sql = "select c.customerid,c.firstname,c.lastname,c.username,c.city,c.state,c.phone,c.email,c.customerstatus from bank_schema.customer c join bank_schema.users u on c.username=u.username where u.username=? and u.userpassword=? and u.usertype = 'Customer'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, userpassword);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				customer = new Customer();
				customer.setFirstname(rs.getString("firstname"));
				customer.setLastname(rs.getString("lastname"));
				customer.setCustomerstatus(rs.getString("customerstatus"));
				customer.setCustomerid(rs.getInt("customerid"));
				customer.setCity(rs.getString("city"));
				customer.setPhone(rs.getString("email"));
			}
		} catch(ClassNotFoundException | SQLException e){
			throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
		}
		return customer;
		
	}

	@Override
	public Employee employeeLogIn(String employname, String employpassword) throws BusinessBankException {
		Employee employee = null;
		
		try(Connection connection = BankConnection.getConnection()){
			String sql1 = "select e.employid,e.firstname,e.lastname,e.username from bank_schema.employee e join bank_schema.users u on e.username=u.username where u.username=? and u.userpassword=? and u.usertype = 'Employee'";
			PreparedStatement ps1 = connection.prepareStatement(sql1);
			ps1.setString(1, employname);
			ps1.setString(2, employpassword);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) {
				employee = new Employee();
				employee.setEmployid(rs1.getString("employid"));
				employee.setFirstname(rs1.getString("firstname"));
				employee.setLastname(rs1.getString("lastname"));
				employee.setUsername(rs1.getString("username"));
			}
		} catch (ClassNotFoundException|SQLException e) {
			throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
		} 
		return employee;
	}

}
