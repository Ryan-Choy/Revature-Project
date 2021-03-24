package com.app.bank.user.service.dao.impl;

import java.math.BigDecimal;
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
import com.app.bank.model.Account;
import com.app.bank.model.Transactions;
import com.app.bank.user.service.dao.AccountCRUDDAO;



public class AccountCRUDDAOImpl implements AccountCRUDDAO {
	private static Logger log = Logger.getLogger(UserCRUDDAOImpl.class);

	@Override
	public int createBankAccount(Account account, int id) throws BusinessBankException {
		int c = 0;
		int aid = 0;
		String aStatus = " ";
		Connection connect = null;
		
			try {
				connect = BankConnection.getConnection();
				String sql = "insert into bank_schema.account(customerid,balance) values(?,?)";
				connect.setAutoCommit(false);
				PreparedStatement prep = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				prep.setInt(1, id);
				prep.setBigDecimal(2, account.getBalance());
				c = prep.executeUpdate();
				ResultSet rs = prep.getGeneratedKeys();
				if(rs.next()) {
					aid = rs.getInt("accountid");
					aStatus = rs.getString("accountstatus");
					account.setAccountid(aid);
					account.setAccountstatus(aStatus);
				}
				
					connect.commit();
					connect.close();
				
				
				
			} catch (ClassNotFoundException|SQLException e) {
				try {
					connect.rollback();
					throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					log.info(e1.getMessage());
				}
			} 
			
		return c;
	}

	@Override
	public List<Account> getBankAccount() throws BusinessBankException {
		List<Account> viewBankAccount = new ArrayList<>();
		
		try(Connection connect = BankConnection.getConnection()){
			String sql = "select customerid,accountid,balance,accountstatus from bank_schema.account";
			PreparedStatement prep = connect.prepareStatement(sql);
			ResultSet rSet = prep.executeQuery();
			if(rSet.next()) {
				Account account = new Account();
				account.setCustomerid(rSet.getInt("customerid"));
				account.setAccountid(rSet.getInt("accountid"));
				account.setBalance(new BigDecimal(rSet.getString("balance").replaceAll("[$,]", "")));
				account.setAccountstatus(rSet.getString("accountstatus"));
				viewBankAccount.add(account);
			}
			
			
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
		}
		
		return viewBankAccount;
	}

	@Override
	public Account accountUpdate(int accountid, int balance) throws BusinessBankException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int makeTransac(Transactions transactions) throws BusinessBankException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Transactions> getTransac(int transacid) throws BusinessBankException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transactions> getTransac() throws BusinessBankException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateTransac(String tStatus, int transacid) {
		// TODO Auto-generated method stub
		return null;
	}

}
