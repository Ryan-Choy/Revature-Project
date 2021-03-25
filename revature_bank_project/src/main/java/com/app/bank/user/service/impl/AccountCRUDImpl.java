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
		if (!BankValidations.isValidBalance(account.getBalance())) {
			throw new BusinessBankException("Entered balance value " + account.getBalance() + " is invalid.");
		}
		if (!BankValidations.isValidId(id)) {
			throw new BusinessBankException("Entered id " + id + " is invalid");
		}

		return accountcruddao.createBankAccount(account, id);
	}

	@Override
	public List<Account> getBankAccount() throws BusinessBankException {

		return accountcruddao.getBankAccount();
	}

	@Override
	public String accountUpdate(int accountid, BigDecimal balance) throws BusinessBankException {
		if (!BankValidations.isValidBalance(balance)) {
			throw new BusinessBankException("Entered balance " + balance + " is invalid");
		}
		if (!BankValidations.isValidId(accountid)) {
			throw new BusinessBankException("Entered account id " + accountid + " is invalid");
		}
		return accountcruddao.accountUpdate(accountid, balance);
	}

	@Override
	public int makeTransac(Transactions transactions) throws BusinessBankException {
		if (!BankValidations.isValidId(transactions.getAccountid())) {
			throw new BusinessBankException("Entered account id " + transactions.getAccountid()+ " is invalid");
		}
		if (!BankValidations.isValidId(transactions.getCustomerid())) {
			throw new BusinessBankException("Entered customer id " + transactions.getCustomerid()+ " is invalid");
		}
		if (!BankValidations.isValidId(transactions.getTargetid())) {
			throw new BusinessBankException("Entered target id " + transactions.getTargetid()+" is invalid");
		}
		if (!BankValidations.isValidBalance(transactions.getTrasacamount())) {
			throw new BusinessBankException("Entered balance " + transactions.getTrasacamount() + " is invalid");
		}
		if (!BankValidations.isValidStatus(transactions.getTransacstatus())) {
			throw new BusinessBankException("Entered status " + transactions.getTransacstatus() + " is invalid");
		}
		if(!BankValidations.isValidTransferType(transactions.getTransactype())) {
			throw new BusinessBankException("Entered transaction type "+ transactions.getTransactype()+" is invalid");
		}

		return accountcruddao.makeTransac(transactions);
	}


	@Override
	public List<Transactions> getTransac() throws BusinessBankException {
		
		return accountcruddao.getTransac();
	}

	@Override
	public String updateTransac(String tStatus, int transacid)throws BusinessBankException {
		if (!BankValidations.isValidStatus(tStatus)) {
			throw new BusinessBankException("Entered status " + tStatus + " is invalid");
		}
		if (!BankValidations.isValidId(transacid)) {
			throw new BusinessBankException("Entered transaction id " + transacid+ " is invalid");
		}
		return accountcruddao.updateTransac(tStatus, transacid);
	}

	@Override
	public String accountProcess(String statup, int aid) throws BusinessBankException {
		if (!BankValidations.isValidStatus(statup)) {
			throw new BusinessBankException("Entered status " + statup + " is invalid");
		}
		if (!BankValidations.isValidId(aid)) {
			throw new BusinessBankException("Entered account id " + aid + " is invalid");
		}
		return accountcruddao.accountProcess(statup, aid);
	}

}
