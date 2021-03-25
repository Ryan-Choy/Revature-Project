package com.app.bank.main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Account;
import com.app.bank.model.Customer;
import com.app.bank.model.Employee;
import com.app.bank.model.Transactions;
import com.app.bank.model.User;
import com.app.bank.user.service.AccountCRUD;
import com.app.bank.user.service.UserCRUD;
import com.app.bank.user.service.impl.AccountCRUDImpl;
import com.app.bank.user.service.impl.UserCRUDImpl;

public class BankMain {
	private static Logger log = Logger.getLogger(BankMain.class);

	public static void main(String[] args) {
		log.info("Welcome to Ryan Choy's Banking App version 1.0");
		log.info("=============================================");
		int us = 0;
		Scanner scanner = new Scanner(System.in);
		UserCRUD userCRUD = new UserCRUDImpl();
		AccountCRUD accountCRUD = new AccountCRUDImpl();
		do {
			log.info("Hello user");
			log.info("Please enter a number from 1 to 4 to navigate the menu:");
			log.info("1) Log in as a customer");
			log.info("2) Log in as an employee");
			log.info("3) Apply for a new customer account");
			log.info("4) Exit the application");

			try {
				us = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				us = 0;
			}

			switch (us) {
//=================================================================================================================
			case 1:

				try {
					List<Customer> listCustomers = userCRUD.getCustomer();
					List<User> listUsers = userCRUD.getUsers();
					log.info("Please enter your user name");
					String username = scanner.nextLine();
					log.info("Please enter your password");
					String userpassword = scanner.nextLine();
					boolean login = false;

					// login in for customers
					for (int i = 0; i < listUsers.size(); i++) {
						User u = listUsers.get(i);
						if (u.getUsername().matches(username) && u.getUserpassword().matches(userpassword)) {
							for (int j = 0; j < listCustomers.size(); j++) {
								Customer c = listCustomers.get(j);
								if (u.getFirstname().matches(c.getFirstname())
										&& u.getLastname().matches(c.getLastname())
										&& u.getUsername().matches(c.getUsername())) {
									if (c.getCustomerstatus().matches("Pending")) {
										log.info(
												"Sorry, your account is not approved yet, please try again or contact an employee");
										login = true;
									} else if (c.getCustomerstatus().matches("Rejected")) {
										log.info(
												"Sorry, your account is rejected, please contact an employee for details");
										login = true;
									} else if (c.getCustomerstatus().matches("Approved")) {
										// customer login successful
										login = true;
										log.info("Login successful! Welcome Customer " + c.getFirstname() + " "
												+ c.getLastname());
										int cu = 0;
										do {

											log.info("Please enter a number from 1 to 4 to navigate the menu:");
											log.info("1) Approve or Reject transfers");
											log.info("2) Apply for a bank account");
											log.info("3) View the balance of an account");
											log.info("4) Make a withdrawal or deposit to an account.");
											log.info("5) Make a transfer");
											log.info("6) Log out");
											cu = Integer.parseInt(scanner.nextLine());

											switch (cu) {
											case 1:
												log.info("in construction");

												int transfer = 0;
												log.info("You have " + transfer
														+ " transfers from other accounts waiting to be accepted or rejected");
												break;
											case 2:
												// bank account creation
												log.info(
														"Please enter the desired balance for your new bank account in the format #.##");
												Account account = new Account();
												int idc = c.getCustomerid();
												BigDecimal newbal = new BigDecimal(scanner.nextLine());

												account.setCustomerid(idc);
												account.setBalance(newbal);

												if (accountCRUD.createBankAccount(account, idc) == 1) {
													log.info(
															"Bank account successfully created, please wait for an employee to approve or reject it.");
													log.info(account);
												}

												break;

											// view account balance
											case 3:
												List<Account> viewCAccount = accountCRUD.getBankAccount();
												log.info("Choose the account that you want to see the balance of");
												LinkedHashMap<Integer, Integer> viewAMap = new LinkedHashMap<>();
												int acid = c.getCustomerid();
												int atrack = 0;
												Account a = null;
												for (int k = 0; k < viewCAccount.size(); k++) {
													a = viewCAccount.get(k);
													if (a.getCustomerid() == acid
															&& a.getAccountstatus().matches("Approved")) {
														log.info((atrack + 1) + ") Account Id: " + a.getAccountid());
														viewAMap.put(atrack, k);
														atrack++;
													}
												}
												if (atrack == 0) {
													log.info("You have no approved bank accounts to view");
												} else {
													log.info((atrack + 1) + ") Return to customer submenu");

													int selba = 0;

													try {
														selba = Integer.parseInt(scanner.nextLine());
													} catch (NumberFormatException e) {
														selba = 0;
													}

													if (selba > 0 && selba <= (atrack + 1)) {
														if (selba == (atrack + 1)) {
															break;
														} else {
															int apoint = viewAMap.get(selba - 1);
															log.info("Printing account balance");
															log.info("Account id: "
																	+ viewCAccount.get(apoint).getAccountid()
																	+ ", Balance: $"
																	+ viewCAccount.get(apoint).getBalance() + "\n");
														}
													} else {
														log.info("Invalid input, please enter a number between 1-"
																+ (atrack + 1));
													}
												}

												break;
											case 4:
												// deposit/withdrawal
												List<Account> updateAccount = accountCRUD.getBankAccount();
												log.info("Choose the account that you want to see the balance of");
												LinkedHashMap<Integer, Integer> updateAMap = new LinkedHashMap<>();
												int cid = c.getCustomerid();
												int uatrack = 0;
												Account ua = null;
												for (int k = 0; k < updateAccount.size(); k++) {
													ua = updateAccount.get(k);
													if (ua.getCustomerid() == cid
															&& ua.getAccountstatus().matches("Approved")) {
														log.info((uatrack + 1) + ") Account Id: " + ua.getAccountid());
														updateAMap.put(uatrack, k);
														uatrack++;
													}
												}
												if (uatrack == 0) {
													log.info("You have no approved bank accounts to view");
												} else {
													log.info((uatrack + 1) + ") Return to customer submenu");

													int selua = 0;

													try {
														selua = Integer.parseInt(scanner.nextLine());
													} catch (NumberFormatException e) {
														selua = 0;
													}

													if (selua > 0 && selua <= (uatrack + 1)) {
														if (selua == (uatrack + 1)) {
															break;
														} else {
														
															int apoint = updateAMap.get(selua - 1);
															log.info("Printing account balance");
															log.info("Account id: "
																	+ updateAccount.get(apoint).getAccountid()
																	+ ", Balance: $"
																	+ updateAccount.get(apoint).getBalance() + "\n");

															int wdflag = 0;
															do {
																log.info("Choose the following");
																log.info("1) Make a deposit");
																log.info("2) Make a withdrawal");
																log.info("3) Cancel");
																BigDecimal pBal = updateAccount.get(apoint).getBalance();
																int aid = updateAccount.get(apoint).getAccountid();
																BigDecimal fBal = new BigDecimal(0);
																BigDecimal wBal = null;
																Transactions dwTransac = new Transactions();
																dwTransac.setCustomerid(cid);
																dwTransac.setAccountid(aid);
																dwTransac.setTargetid(aid);
																dwTransac.setTransacstatus("Approved");
																
																
																try {
																	wdflag = Integer.parseInt(scanner.nextLine());
																} catch (NumberFormatException e) {
																
																}
																
																switch (wdflag) {
																case 1:
																	log.info("Please enter the amount you want to deposit, the amount must be positive and has two decimal places");
																	BigDecimal nBald = new BigDecimal(scanner.nextLine());
																	if(nBald.compareTo(fBal) <= -1){
																		log.info("Entered amount "+ nBald+ " is invalid");
																	} else {
																		BigDecimal dBal = pBal.add(nBald);
																		dwTransac.setTrasacamount(nBald);
																		dwTransac.setTransactype("Deposit");
																		log.info("The new balance is: $"+ dBal);
																		log.info(accountCRUD.accountUpdate(aid, dBal));
																		accountCRUD.makeTransac(dwTransac);
																		
																	}

																	break;
																case 2:
																	log.info("Please enter the amount you want to withdraw, the amount must be positive and has two decimal places");
																	BigDecimal nBalw = new BigDecimal(scanner.nextLine());
																	if(nBalw.compareTo(fBal) <= -1 && pBal.subtract(nBalw).compareTo(fBal) <= -1){
																		log.info("Entered amount "+ nBalw+ " is invalid");
																	} else {
																		wBal = pBal.subtract(nBalw);
																		log.info("The new balance is: $"+ wBal);
																		log.info(accountCRUD.accountUpdate(aid, wBal));
																		dwTransac.setTrasacamount(nBalw);
																		dwTransac.setTransactype("Withdraw");
																		accountCRUD.makeTransac(dwTransac);
																		
																	}

																	break;
																case 3:

																	break;
																default:
																	log.info("Invalid input, please enter a number between 1-3");
																	break;
																}

															} while (wdflag != 3);
														}
													} else {
														log.info("Invalid input, please enter a number between 1-"
																+ (uatrack + 1));
													}
												}

												break;
											case 5:
												int tflag = 0;
												do {
												List<Account> tAccount = accountCRUD.getBankAccount();
												int ctid = c.getCustomerid();
												Account at = new Account();
												BigDecimal cBal = null;
												BigDecimal zer = new BigDecimal(0);
												
												log.info("Please enter the following details");
												Transactions transacN = new Transactions();
												log.info("Entering customer id "+ ctid);
												transacN.setCustomerid(ctid);
												log.info("Enter the account id you want to withdraw money from");
												int tnid = Integer.parseInt(scanner.nextLine());
												transacN.setAccountid(tnid);
												
												log.info("Enter the target bank acount id you want to transfer the money to");
												transacN.setTargetid(Integer.parseInt(scanner.nextLine()));
												
												for (int k = 0; k < tAccount.size(); k++) {
													at = tAccount.get(k);
													if(at.getAccountid()== tnid) {
														cBal = at.getBalance();
													}
													
												}
												log.info("Enter the amount of money you want to transfer, it must be positive and contain 2 decimal places");
												BigDecimal tnBal = new BigDecimal(scanner.nextLine());
												if(tnBal.compareTo(zer) <= -1 && cBal.subtract(tnBal).compareTo(zer) <= -1) {
													log.info("Entered balance "+ tnBal+" is invalid");
												} else {
													transacN.setTrasacamount(tnBal);
												}
												
												
												
												transacN.setTransacstatus("Pending");
												transacN.setTransactype("Transfer");
												
												if(accountCRUD.makeTransac(transacN) == 1) {
													log.info("Transaction posted successfully, please wait for approval");
													log.info(transacN);
													//update bank account
													log.info(accountCRUD.accountUpdate(ctid, cBal.subtract(tnBal)));
													
													tflag = 1;
												}
												
												}while(tflag != 1);
												break;
											case 6:
												log.info("Logging out...");

												break;

											default:
												log.info(
														"Invalid choice, please enter a proper choice between 1-4 only...");
												break;
											}
										} while (cu != 6);

									}

								}
							}
						}
					}
					if (login == false) {
						log.info("Login failed");
					}

				} catch (BusinessBankException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
//====================================================================================================================================================
			case 2:

				try {
					List<User> listUsers = userCRUD.getUsers();
					List<Employee> listEmployee = userCRUD.getEmployees();
					log.info("Please enter your user name");
					String employname = scanner.nextLine();
					log.info("Please enter your password");
					String employpassword = scanner.nextLine();
					boolean login = false;

					for (int i = 0; i < listUsers.size(); i++) {
						User u = listUsers.get(i);
						if (u.getUsername().matches(employname) && u.getUserpassword().matches(employpassword)) {
							for (int j = 0; j < listEmployee.size(); j++) {
								Employee e = listEmployee.get(j);
								if (u.getFirstname().matches(e.getFirstname())
										&& u.getLastname().matches(e.getLastname())
										&& u.getUsername().matches(e.getUsername())) {
									login = true;
									log.info("Login successful! Welcome Employee " + e.getFirstname() + " "
											+ e.getLastname());
									int em = 0;
									do {
										log.info("Please enter a number from 1 to 4 to navigate the menu:");
										log.info("1) Approve or Reject accounts");
										log.info("2) View customer's bank accounts");
										log.info("3) View transaction log");
										log.info("4) Log out");

										try {
											em = Integer.parseInt(scanner.nextLine());
										} catch (NumberFormatException e1) {
										}

										switch (em) {
										// ==========================================================================================================

										case 1:
											// result set, list, update
											int up = 0;

											do {

												List<Customer> upCustomer = userCRUD.getCustomer();
												List<Account> upAccount = accountCRUD.getBankAccount();
												int pendcust = 0;
												int pendbank = 0;

												for (int k = 0; k < upCustomer.size(); k++) {
													Customer c = upCustomer.get(k);

													if (c.getCustomerstatus().matches("Pending")) {
														pendcust += 1;
													}
												}
												for (int k = 0; k < upAccount.size(); k++) {
													Account a = upAccount.get(k);
													if (a.getAccountstatus().matches("Pending")) {
														++pendbank;
													}
												}
												log.info("You have " + pendcust + " customer accounts and " + pendbank
														+ " bank accounts waiting to be to be approved or rejected");
												log.info("Enter one of the following to navigate the menu");
												log.info("1) Process Customer accounts");
												log.info("2) Process Bank accounts");
												log.info("3) Return to the employee submenu");

												try {
													up = Integer.parseInt(scanner.nextLine());
												} catch (NumberFormatException e1) {
												}

												switch (up) {
												case 1:
													if (pendcust == 0) {
														log.info(
																"There are no pending customer accounts to be processed");
													} else {
														log.info(
																"Please enter the appropriate number to process a customer account");
														LinkedHashMap<Integer, Integer> pendcmap = new LinkedHashMap<>();

														int ccount = 1;
														for (int i1 = 0; i1 < upCustomer.size(); i1++) {
															if (upCustomer.get(i1).getCustomerstatus()
																	.matches("Pending")) {
																log.info((ccount) + ") " + upCustomer.get(i1));
																pendcmap.put(ccount,
																		upCustomer.get(i1).getCustomerid());
																ccount++;
															}
														}
														log.info((ccount) + ") Cancel the process");
														int selc = 0;
														try {

															selc = Integer.parseInt(scanner.nextLine());
														} catch (NumberFormatException e1) {

														}
														if (selc > 0 && selc <= (ccount)) {
															if (selc == (ccount)) {
																break;
															} else {
																// update customer account here
																int arc = 0;
																int custid = pendcmap.get(selc);
																String cstat = " ";
																do {
																	log.info(
																			"Enter the following to approve or reject the customer account.");
																	log.info("1) Approve");
																	log.info("2) Reject");
																	log.info("3) Cancel");

																	try {
																		arc = Integer.parseInt(scanner.nextLine());
																	} catch (NumberFormatException e1) {

																	}
																	switch (arc) {
																	case 1:
																		// approve
																		cstat = "Approved";
																		log.info(
																				userCRUD.upPendCustomer(cstat, custid));
																		arc = 3;
																		break;
																	case 2:
																		// reject
																		cstat = "Rejected";
																		log.info(
																				userCRUD.upPendCustomer(cstat, custid));
																		arc = 3;
																		break;
																	case 3:
																		// cancel

																		break;
																	default:
																		log.info(
																				"Invalid choice, please enter a proper choice between 1-3 only...");
																		break;
																	}
																} while (arc != 3);
															}
														} else {
															log.info(
																	"Invalid choice, please enter a proper choice between 1-"
																			+ (ccount) + " only...");
														}

													}
													break;

												// bank accounts
												case 2:
													if (pendbank == 0) {
														log.info("There are no pending bank accounts");
													} else {
														log.info(
																"Please enter the appropriate number to process a bank account");
														LinkedHashMap<Integer, Integer> pendbmap = new LinkedHashMap<>();

														int bcount = 1;
														for (int i1 = 0; i1 < upAccount.size(); i1++) {
															if (upAccount.get(i1).getAccountstatus()
																	.matches("Pending")) {
																log.info((bcount) + ") " + upAccount.get(i1));
																pendbmap.put(bcount, upAccount.get(i1).getAccountid());
																bcount++;
															}
														}
														log.info((bcount) + ") Cancel the process");
														int selb = 0;

														try {
															selb = Integer.parseInt(scanner.nextLine());
														} catch (NumberFormatException e1) {
															selb = 0;
														}
														if (selb > 0 && selb <= (bcount)) {
															if (selb == (bcount)) {
																break;
															} else {
																int arb = 0;
																int bankid = pendbmap.get(selb);
																String bstat = " ";
																do {
																	log.info(
																			"Enter the following to approve or reject the customer account.");
																	log.info("1) Approve");
																	log.info("2) Reject");
																	log.info("3) Cancel");

																	try {
																		arb = Integer.parseInt(scanner.nextLine());
																	} catch (NumberFormatException e1) {

																	}
																	switch (arb) {
																	case 1:
																		// approve
																		bstat = "Approved";
																		log.info(accountCRUD.accountProcess(bstat,
																				bankid));

																		arb = 3;
																		break;
																	case 2:
																		// reject
																		bstat = "Rejected";
																		log.info(accountCRUD.accountProcess(bstat,
																				bankid));

																		arb = 3;
																		break;
																	case 3:
																		// cancel

																		break;
																	default:
																		log.info(
																				"Invalid choice, please enter a proper choice between 1-3 only...");
																		break;
																	}
																} while (arb != 3);

															}
														} else {
															log.info(
																	"Invalid choice, please enter a proper choice between 1-"
																			+ (bcount) + " only...");
														}

													}

													break;
												case 3:
													log.info("Returning to employee submenu...");
													break;
												default:
													log.info(
															"Invalid choice, please enter a proper choice between 1-3 only...");
													break;
												}
											} while (up != 3);

											break;
										// ==========================================================================================================
										// view customer bank accounts
										case 2:
											int vib = 0;

											do {
												List<Customer> viewCustomer = userCRUD.getCustomer();
												List<Account> viewAccount = accountCRUD.getBankAccount();
												int apccount = 0;
												LinkedHashMap<Integer, Integer> appcmap = new LinkedHashMap();

												log.info(
														"Choose from the following customer accounts to view their bank accounts.");
												for (int k = 0; k < viewCustomer.size(); k++) {
													Customer c = viewCustomer.get(k);
													if (c.getCustomerstatus().matches("Approved")) {
														log.info((apccount + 1) + ") Customer Id: " + c.getCustomerid()
																+ ": " + c.getFirstname() + " " + c.getLastname());
														appcmap.put(k, c.getCustomerid());
														apccount++;
													}
												}

												if (apccount == 0) {
													log.info("There are no approved customer accounts to view");
													vib = 1;
												} else {
													log.info((apccount + 1) + ") Return to employee submenu");
													int selapp = 0;

													try {
														selapp = Integer.parseInt(scanner.nextLine());
													} catch (NumberFormatException e1) {
														selapp = 0;
													}
													if (selapp > 0 && selapp <= (apccount + 1)) {
														if (selapp == apccount + 1) {
															break;
														} else {
															log.info("Printing account details for the customer");

															int point = appcmap.get(selapp - 1);
															int noapp = 0;
															for (int k = 0; k < viewAccount.size(); k++) {
																Account a = viewAccount.get(k);
																if (a.getCustomerid() == point
																		&& a.getAccountstatus().matches("Approved")) {
																	log.info("Account id: " + a.getAccountid()
																			+ ", Account Balance: $" + a.getBalance());
																	noapp++;
																}

															}
															if (noapp == 0) {
																log.info("Customer has no approved accounts");
															}
														}

													} else {
														log.info(
																"Invalid choice, please enter a proper choice between 1-"
																		+ (apccount) + " only...");
													}

												}

											} while (vib != 1);

											break;

										// ==========================================================================================================
										case 3:

											log.info("Loading transaction log");
											log.info("Loading successfull!");

											break;

										// ==========================================================================================================

										case 4:
											log.info("Logging out...");

											break;
										default:
											log.info(
													"Invalid choice, please enter a proper choice between 1-4 only...");
											break;
										}

									} while (em != 4);

								}

							}

						}

					}
					if (login == false) {
						log.info("Login failed");
					}

				} catch (BusinessBankException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				break;
			case 3:
				// customer creation, account status
				log.info("Please enter the following details below");
				User user = new User();
				Customer customer = new Customer();

				log.info("Enter your first name");
				user.setFirstname(scanner.nextLine());
				log.info("Enter your last name");
				user.setLastname(scanner.nextLine());
				log.info("Enter your user name, this is what you will be using to log in.");
				user.setUsername(scanner.nextLine());
				log.info("Enter your password with at least 8 characters, do not share it with anyone");
				user.setUserpassword(scanner.nextLine());
				log.info("Enter your city");
				customer.setCity(scanner.nextLine());
				log.info("Enter your state");
				customer.setState(scanner.nextLine());
				log.info("Enter your 10 digit phone number in the format +1-##########");
				customer.setPhone(scanner.nextLine());
				log.info("Enter your email, it must contain at least an @ and a website");
				customer.setEmail(scanner.nextLine());

				try {
					if (userCRUD.createCustomer(user, customer) == 2) {
						log.info(
								"Customer account successfully created, please wait for an employee to approve or reject it.");
						log.info(user);
						log.info(customer);
					}

				} catch (BusinessBankException e) {
					// TODO Auto-generated catch block
					log.info(e);
				}

				break;

			case 4:
				log.info("Thank you for using the Banking App version 1.0, exiting the program...");
				break;

			default:
				log.info("Invalid choice, please enter a proper choice between 1-4 only...");
				break;
			}

		} while (us != 4);

	}

}
