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
			String sqla = "select a.customerid,a.accountid,a.accountstatus,a.balance from bank_schema.account a order by accountid";
			PreparedStatement prep = connect.prepareStatement(sqla);
			ResultSet rSet = prep.executeQuery();
			while(rSet.next()) {
				Account account = new Account();
				account.setCustomerid(rSet.getInt("customerid"));
				account.setAccountid(rSet.getInt("accountid"));
				account.setAccountstatus(rSet.getString("accountstatus"));
				account.setBalance(new BigDecimal(rSet.getString("balance").replaceAll("[$,]", "")));
				viewBankAccount.add(account);
			}
			
			
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
		}
		
		return viewBankAccount;
	}

	@Override
	public String accountUpdate(int accountid, BigDecimal balance) throws BusinessBankException {
		String upresult = " ";
		int c = 0;
		Connection connect = null;
		try {
			connect = BankConnection.getConnection();
			connect.setAutoCommit(false);
			String sql = "update bank_schema.account set balance=? where accountid=?";
			PreparedStatement prep = connect.prepareStatement(sql);
			prep.setBigDecimal(1, balance);
			prep.setInt(2, accountid);
			c = prep.executeUpdate();
			
			if(c == 1) {
				upresult = "Bank account updated successfully";
				connect.commit();
				connect.close();
			}else {
				upresult = "Bank account update failed";
				connect.close();
			}
			
			
		}catch(ClassNotFoundException | SQLException e) {
			
			try {
				connect.rollback();
				throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				log.info(e1);
			}
			
		}
		
		return upresult;
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
		return null;
	}

	@Override
	public String accountProcess(String statup, int aid) throws BusinessBankException {
		String result = " ";
		int c = 0;
		Connection connect = null;
		try {
			connect = BankConnection.getConnection();
			connect.setAutoCommit(false);
			String sql = "update bank_schema.account set accountstatus=? where accountid=?";
			PreparedStatement prep = connect.prepareStatement(sql);
			prep.setString(1, statup);
			prep.setInt(2, aid);
			c = prep.executeUpdate();
			
			if(c == 1) {
				result = "Bank account processed successfully";
				connect.commit();
				connect.close();
			}else {
				result = "Process has failed";
				connect.close();
			}
			
		} catch(ClassNotFoundException | SQLException e) {
			try {
				connect.rollback();
				throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
			} catch (SQLException e1) {
				log.info(e1);
			}
		}
		return result;
		
	}

}
