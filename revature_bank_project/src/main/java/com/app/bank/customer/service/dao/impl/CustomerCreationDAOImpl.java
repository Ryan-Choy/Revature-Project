package com.app.bank.customer.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.bank.customer.service.dao.CustomerCreationDAO;
import com.app.bank.dao.dbutil.BankConnection;
import com.app.bank.exception.BusinessBankException;

import com.app.bank.model.User;

public class CustomerCreationDAOImpl implements CustomerCreationDAO {
	private static Logger log = Logger.getLogger(CustomerCreationDAOImpl.class);

	// @Override
	public int createCustomer(User customer) throws BusinessBankException {
		int c = 0;
		int nextID_from_seq = 0;
		try (Connection connection = BankConnection.getConnection()) {
			//String sql = "with ins as (insert into bank_schema.customer(
					//"insert into bank_schema.customer(id,firstname,lastname,username,password,email,customerstatus) values(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, nextID_from_seq);
			preparedStatement.setString(2, customer.getFirstname());
			preparedStatement.setString(3, customer.getLastname());
			preparedStatement.setString(4, customer.getUsername());
			preparedStatement.setString(5, customer.getPassword());
			preparedStatement.setString(6, customer.getEmail());
			preparedStatement.setBoolean(7, false);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.trace(e);//development only
			throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
		}
		return c;
	}

}
