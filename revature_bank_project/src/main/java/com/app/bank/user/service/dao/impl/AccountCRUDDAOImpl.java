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
		int c = 0;
		String date = " ";
		int tid = 0;
		Connection connect = null;
		try {
			connect = BankConnection.getConnection();
			String sql = "insert into bank_schema.transactions(customerid,accountid,targetid,transacamount,transacstatus,transactype) values(?,?,?,?,?,?)";
			connect.setAutoCommit(false);
			
			PreparedStatement prep = connect.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			prep.setInt(1, transactions.getCustomerid());
			prep.setInt(2, transactions.getAccountid());
			prep.setInt(3, transactions.getTargetid());
			prep.setBigDecimal(4, transactions.getTrasacamount());
			prep.setString(5, transactions.getTransacstatus());
			prep.setString(6, transactions.getTransactype());
			
			c = prep.executeUpdate();
			ResultSet rSet = prep.getGeneratedKeys();
			if(rSet.next()) {
				tid = rSet.getInt("transacid");
				date = rSet.getString("transacdate");
				transactions.setTransacid(tid);
				transactions.setTransacdate(date);
			}
			
			connect.commit();
			connect.close();
			
		}catch(ClassNotFoundException | SQLException e) {
			throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
		}
		
		return c;
	}


	@Override
	public List<Transactions> getTransac() throws BusinessBankException {
		List<Transactions> viewTLog = new ArrayList<>();
		
		try {
			Connection connect = BankConnection.getConnection();
			String sql = "select transacdate,customerid,accountid,targetid,transacamount,transacstatus,transacid,transactype from bank_schema.transactions order by transacid";
			PreparedStatement prep = connect.prepareStatement(sql);
			ResultSet rSet = prep.executeQuery();
			while(rSet.next()) {
				Transactions transac = new Transactions();
				transac.setTransacdate(rSet.getString("transacdate"));
				transac.setCustomerid(rSet.getInt("customerid"));
				transac.setAccountid(rSet.getInt("accountid"));
				transac.setTargetid(rSet.getInt("targetid"));
				transac.setTrasacamount(new BigDecimal(rSet.getString("transacamount").replaceAll("[$,]", "")));
				transac.setTransacstatus(rSet.getString("transacstatus"));
				transac.setTransacid(rSet.getInt("transacid"));
				transac.setTransactype(rSet.getString("transactype"));
				viewTLog.add(transac);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
		} 
				
		return viewTLog;
	}

	@Override
	public String updateTransac(String tStatus, int transacid) throws BusinessBankException {
		String result = " ";
		int c = 0;
		Connection connect = null;
		
		try {
			connect = BankConnection.getConnection();
			connect.setAutoCommit(false);
			String sql = "update bank_schema.transactions set transacstatus=? where transacid=?";
			PreparedStatement prep = connect.prepareStatement(sql);
			prep.setString(1, tStatus);
			prep.setInt(2, transacid);
			c = prep.executeUpdate();
			
			if(c == 1) {
				result = "Transaction processed successfully";
				connect.commit();
				connect.close();
			}else {
				result = "Process has failed";
				connect.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			try {
				connect.rollback();
				throw new BusinessBankException("Internal error occured...Please contact SYS ADMIN.");
			} catch (SQLException e1) {

			}
			
		}
		
		return result;
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
