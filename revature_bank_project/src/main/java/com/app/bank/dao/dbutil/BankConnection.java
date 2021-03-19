package com.app.bank.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankConnection {
	
	private static Connection connection;
	
	private BankConnection() {
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "R3v@Ture"; // DB user name and password.
		connection = DriverManager.getConnection(url, username, password);
		
		return connection;
	}

}
