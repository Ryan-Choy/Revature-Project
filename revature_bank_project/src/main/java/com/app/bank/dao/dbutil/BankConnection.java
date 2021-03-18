package com.app.bank.dao.dbutil;

import java.sql.Connection;
import java.sql.SQLException;

public class BankConnection {
	
	private static Connection connection;
	
	private BankConnection() {
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		
		
		return connection;
	}

}
