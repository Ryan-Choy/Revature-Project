package com.app.bank.user.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Account;
import com.app.bank.model.Transactions;
import com.app.bank.user.service.AccountCRUD;
import com.app.bank.user.service.dao.AccountCRUDDAO;
import com.app.bank.user.service.dao.impl.AccountCRUDDAOImpl;
import com.app.bank.validations.BankValidations;

public class AccountCRUDImpl implements AccountCRUD {
	
	private AccountCRUDDAO accountcruddao = new AccountCRUDDAOImpl();

	@Override
	public int createBankAccount(Account account, int id) throws BusinessBankException {
		if(!BankValidations.isValidBalance(account.getBalance())) {
			throw new BusinessBankException("Entered balance value "+ account.getBalance()+" is invalid.");
		}
		if(!BankValidations.isValidId(id)) {
			throw new BusinessBankException("Entered id "+ id + " is invalid");
		}
		
		
		return accountcruddao.createBankAccount(account, id);
	}

	@Override
	public List<Account> getBankAccount() throws BusinessBankException {
//		if(!BankValidations.isValidId(customerid)) {
//			throw new BusinessBankException("Entered customer id "+ customerid + " is invalid");
//		}
//		
//		if(!BankValidations.isValidStatus(accstatus)) {
//			throw new BusinessBankException("Entered status "+ accstatus + " is invalid");
//
//		}
		return accountcruddao.getBankAccount();
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
