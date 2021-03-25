package com.app.bank.user.service;

import java.math.BigDecimal;
import java.util.List;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Account;
import com.app.bank.model.Transactions;

public interface AccountCRUD {
	//create bank account
	public int createBankAccount(Account account, int id) throws BusinessBankException;
	
	//view bank account
	public List<Account> getBankAccount() throws BusinessBankException;
	
	//customer deposit or withdrawal
	public String accountUpdate(int accountid, BigDecimal balance) throws BusinessBankException;
	
	//account process
	public String accountProcess(String statup, int aid) throws BusinessBankException;
	
	//make customer transactions
	public int makeTransac(Transactions transactions) throws BusinessBankException;
		
	//view transaction log as employee
	public List<Transactions> getTransac() throws BusinessBankException;
	
	//process transactions as customer
	public String updateTransac(String tStatus, int transacid) throws BusinessBankException;

}
