package com.app.bank.user.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.bank.dao.dbutil.BankConnection;
import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;
import com.app.bank.model.Employee;
import com.app.bank.model.User;
import com.app.bank.user.service.dao.UserCRUDDAO;

public class UserCRUDDAOImpl implements UserCRUDDAO {
	private static Logger log = Logger.getLogger(UserCRUDDAOImpl.class);

	@Override
	public int createCustomer(User user, Customer customer) throws BusinessBankException {
		int cid = 0;
		int c1 = 0;
		int c2 = 0;
		int confirm = 0;
		Connection connection = null;
		try {
			connection = BankConnection.getConnection();
			String sql1 = "insert into bank_schema.users(firstname,lastname,username,userpassword,usertype) values (?,?,?,?,'Customer')";
			String sql2 = "insert into bank_schema.customer(city,state,phone,email,firstname,lastname,username) values(?,?,?,?,?,?,?)";
			connection.setAutoCommit(false);

			PreparedStatement preparedStatement = connection.prepareStatement(sql1);
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getUserpassword());
			c1 = preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, customer.getCity());
			preparedStatement.setString(2, customer.getState());
			preparedStatement.setString(3, customer.getPhone());
			preparedStatement.setString(4, customer.getEmail());
			preparedStatement.setString(5, user.getFirstname());
			preparedStatement.setString(6, user.getLastname());
			preparedStatement.setString(7, user.getUsername());
			user.setUsertype("Customer");
			customer.setCustomerstatus("Pending");
			c2 = preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				cid = rs.getInt("customerid");
				customer.setCustomerid(cid);
			}

			confirm = c1 + c2;
			if (confirm == 2) {
				connection.commit();
				connection.close();
			}

		} catch (ClassNotFoundException | SQLException e) {
			// log.info(e);// development only
			try {
				connection.rollback();
				throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				log.info(e1);
			}

		}
		return confirm;
	}

	@Override
	public List<Customer> getCustomer() throws BusinessBankException {
		List<Customer> listCustomer = new ArrayList<>();
		Connection connect = null;
		try {
			connect = BankConnection.getConnection();
			String sql1 = "select customerid,firstname,lastname,username,city,state,phone,email,customerstatus from bank_schema.customer order by customerid";
			connect.setAutoCommit(false);

			PreparedStatement prep = connect.prepareStatement(sql1);
			ResultSet rSet = prep.executeQuery();
			while (rSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerid(rSet.getInt("customerid"));
				customer.setFirstname(rSet.getString("firstname"));
				customer.setLastname(rSet.getString("lastname"));
				customer.setUsername(rSet.getString("username"));
				customer.setCity(rSet.getString("city"));
				customer.setState(rSet.getString("state"));
				customer.setPhone(rSet.getString("phone"));
				customer.setEmail(rSet.getString("email"));
				customer.setCustomerstatus(rSet.getString("customerstatus"));
				listCustomer.add(customer);
			}

			connect.commit();
			connect.close();

		} catch (ClassNotFoundException | SQLException e) {
			try {
				connect.rollback();
				throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
			} catch (SQLException e1) {

				log.info(e1);
			}

		}
		return listCustomer;
	}

	@Override
	public String upPendCustomer(String statup, int cid) throws BusinessBankException {
		String result = " ";
		int c = 0;
		Connection connect = null;
		try {
			connect = BankConnection.getConnection();
			connect.setAutoCommit(false);
			String sql = "update bank_schema.customer set customerstatus=? where customerid=?";
			PreparedStatement prep = connect.prepareStatement(sql);
			prep.setString(1, statup);
			prep.setInt(2, cid);
			c = prep.executeUpdate();

			if (c == 1) {
				result = "Customer account updated successfully";
				connect.commit();
				connect.close();
			} else {
				result = "Update has failed";
				connect.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			try {
				connect.rollback();
				throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				log.info(e1);
			}
		}

		return result;
	}

	@Override
	public List<User> getUsers() throws BusinessBankException {
		List<User> listUsers = new ArrayList<>();
		try (Connection connect = BankConnection.getConnection()) {

			String sql = "select firstname,lastname,username,userpassword,usertype from bank_schema.users order by firstname";
			PreparedStatement prep = connect.prepareStatement(sql);
			ResultSet rSet = prep.executeQuery();
			while (rSet.next()) {
				User user = new User();
				user.setFirstname(rSet.getString("firstname"));
				user.setLastname(rSet.getString("lastname"));
				user.setUsername(rSet.getString("username"));
				user.setUserpassword(rSet.getString("userpassword"));
				user.setUsertype(rSet.getString("usertype"));
				listUsers.add(user);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
		}
		return listUsers;
	}



	@Override
	public List<Employee> getEmployees() throws BusinessBankException {
		List<Employee> listEmployees = new ArrayList<>();
		try (Connection connect = BankConnection.getConnection()) {

			String sql = "select employid,firstname,lastname,username from bank_schema.employee order by employid";
			PreparedStatement prep = connect.prepareStatement(sql);
			ResultSet rSet = prep.executeQuery();
			while (rSet.next()) {
				Employee employee = new Employee();
				employee.setEmployid(rSet.getString("employid"));
				employee.setFirstname(rSet.getString("firstname"));
				employee.setLastname(rSet.getString("lastname"));
				employee.setUsername(rSet.getString("username"));
				listEmployees.add(employee);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
		}
		return listEmployees;
	}

}
