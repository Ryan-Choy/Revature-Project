package com.app.bank.user.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.bank.dao.dbutil.BankConnection;
import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;
import com.app.bank.model.User;
import com.app.bank.user.service.dao.UserCRUDDAO;

public class UserCRUDDAOImpl implements UserCRUDDAO {
	private static Logger log = Logger.getLogger(UserCRUDDAOImpl.class);

	// @Override
	public int createCustomer(User user, Customer customer) throws BusinessBankException {
		int c = 0;
		try (Connection connection = BankConnection.getConnection()) {
			String sql1 = "insert into bank_schema.users(firstname,lastname,username,userpassword,usertype) values (?,?,?,?,'Customer')";
			PreparedStatement preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getUserpassword());
			preparedStatement.executeUpdate();
			//(select firstname from bank_schema.users),(select lastname from bank_schema.users),(select username from bank_schema.users) old code delete if wrong
			String sql2 = "insert into bank_schema.customer(city,state,phone,email,firstname,lastname,username) values(?,?,?,?,?,?,?) returning customerid";
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
			preparedStatement1.setString(1, customer.getCity());
			preparedStatement1.setString(2, customer.getState());
			preparedStatement1.setString(3, customer.getPhone());
			preparedStatement1.setString(4, customer.getEmail());
			preparedStatement1.setString(5, user.getFirstname());
			preparedStatement1.setString(6, user.getLastname());
			preparedStatement1.setString(7, user.getUsername());
			ResultSet rs = preparedStatement1.executeQuery();
			if(rs.next()) {
				c = rs.getInt("customerid");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);;// development only
			throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
		}
		return c;
	}

}
