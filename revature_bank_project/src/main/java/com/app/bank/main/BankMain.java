package com.app.bank.main;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Account;
import com.app.bank.model.Customer;
import com.app.bank.model.Employee;
import com.app.bank.model.User;
import com.app.bank.user.service.AccountCRUD;
import com.app.bank.user.service.UserCRUD;
import com.app.bank.user.service.UserLogIn;
import com.app.bank.user.service.impl.AccountCRUDImpl;
import com.app.bank.user.service.impl.UserCRUDImpl;
import com.app.bank.user.service.impl.UserLogInImpl;

public class BankMain {
	private static Logger log = Logger.getLogger(BankMain.class);

	public static void main(String[] args) {
		log.info("Welcome to Ryan Choy's Banking App version 1.0");
		log.info("=============================================");
		int us = 0;
		Scanner scanner = new Scanner(System.in);
		UserCRUD userCRUD = new UserCRUDImpl();
		UserLogIn userLogIn = new UserLogInImpl();
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
											log.info("5) Log out");
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
												log.info("Please enter the desired balance for your new bank account in the format #.##");
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
											case 3:
												log.info("in construction");

												break;
											case 4:
												log.info("in construction");

												break;
											case 5:
												log.info("Logging out...");

												break;

											default:
												log.info(
														"Invalid choice, please enter a proper choice between 1-4 only...");
												break;
											}
										} while (cu != 5);

									}

								}
							}
						}
					}
					if(login == false) {
						log.info("Login failed");
					}

				} catch (BusinessBankException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
//====================================================================================
			case 2:

				try {
					List<User> listUsers = userCRUD.getUsers();
					List<Employee> listEmployee = userCRUD.getEmployees();
					log.info("Please enter your user name");
					String employname = scanner.nextLine();
					log.info("Please enter your password");
					String employpassword = scanner.nextLine();

					for (int i = 0; i < listUsers.size(); i++) {
						User u = listUsers.get(i);
						if (u.getUsername().matches(employname) && u.getUserpassword().matches(employpassword)) {
							for (int j = 0; j < listEmployee.size(); j++) {
								Employee e = listEmployee.get(j);
								if (u.getFirstname().matches(e.getFirstname())
										&& u.getLastname().matches(e.getLastname())
										&& u.getUsername().matches(e.getUsername())) {
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
												int pendcust = upCustomer.size();
												int pendbank = 0;
												log.info("You have " + pendcust + " customer accounts and " + pendbank
														+ " bank accounts waiting to be to be approved or rejected");
												log.info("Enter one of the following to navigate the menu");
												log.info("1) Process Customer accounts");
												log.info("2) Process Bank accounts");
												log.info("3) Return to the employee submenu");

												try {
													up = Integer.parseInt(scanner.nextLine());
												} catch (NumberFormatException e1) {

													e1.printStackTrace();
												}

												switch (up) {
												case 1:
													if (pendcust == 0) {
														log.info(
																"There are no pending customer accounts to be processed");
													} else {
														log.info("Please enter the customer account between 1 - "
																+ (upCustomer.size()));
														int ccount = 1;
														for (int i1 = 0; i1 < upCustomer.size(); i1++) {
															if (upCustomer.get(i1).getCustomerstatus() == "Pending") {
																log.info((ccount) + ")" + upCustomer.get(i1));
																ccount++;
															}
														}
														log.info((ccount + 1) + ") Cancel the process");
														int selc = 0;
														try {

															selc = Integer.parseInt(scanner.nextLine());
														} catch (NumberFormatException e1) {

														}
														if (selc > 0 && selc <= upCustomer.size() + 1) {
															if (selc == upCustomer.size() + 1) {
																break;
															} else {
																// update customer account here
																int arc = 0;
																int custid = upCustomer.get((selc - 1)).getCustomerid();
																String cstat = " ";
																do {
																	log.info(
																			"Enter the following to approve or reject the account.");
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
																			+ (upCustomer.size() + 1) + " only...");
														}

													}
													break;

												// bank accounts
												case 2:

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

											log.info(
													"Choose from the following customer accounts to view their bank accounts.");

											int vib = 0;
											do {
												List<Customer> viewCustomer = userCRUD.getCustomer();
												if (viewCustomer.size() == 0) {
													log.info("There are no approved customer accounts to view");
													vib = 1;
												} else {
													log.info("Please enter the customer account between 1 - "
															+ (viewCustomer.size()));
													for (int i1 = 0; i1 < viewCustomer.size(); i1++) {
														log.info((i1 + 1) + ") " + viewCustomer.get(i1));
													}
													log.info(
															(viewCustomer.size() + 1) + ") Return to employee submenu");
													int selc = 0;
													try {
														selc = Integer.parseInt(scanner.nextLine());
													} catch (NumberFormatException e1) {

													}

													if (selc > 0 && selc <= viewCustomer.size() + 1) {
														if (selc == viewCustomer.size() + 1) {
															break;
														} else {
															int aid = viewCustomer.get((selc - 1)).getCustomerid();
															int acount = 0;
															List<Account> viewAccount = accountCRUD.getBankAccount();
															for (int i1 = 0; i1 < viewAccount.size(); i1++) {
																if (viewAccount.get(i1).getAccountstatus() == "Approved"
																		&& viewAccount.get(i1).getCustomerid() == aid) {
																	log.info(viewAccount.get(i1));
																	acount++;
																}
															}
															if (acount == 0) {
																log.info("This customer has no approved accounts");
															}

														}

													} else {
														log.info(
																"Invalid choice, please enter a proper choice between 1-"
																		+ (viewCustomer.size() + 1) + " only...");
													}
												}

											} while (vib != 1);

											break;

										// ==========================================================================================================
										case 3:
											log.info("in construction");
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

								} else {
									log.info("Login failed");
								}

							}

						} else {
							log.info("Login failed");
						}
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
