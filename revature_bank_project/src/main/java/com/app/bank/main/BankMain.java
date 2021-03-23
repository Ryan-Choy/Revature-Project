package com.app.bank.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;
import com.app.bank.model.Employee;
import com.app.bank.model.User;
import com.app.bank.user.service.UserCRUD;
import com.app.bank.user.service.UserLogIn;
import com.app.bank.user.service.impl.UserCRUDImpl;
import com.app.bank.user.service.impl.UserLogInImpl;

public class BankMain {
	private static Logger log = Logger.getLogger(BankMain.class);

	public static void main(String[] args) {
		log.info("Welcome to Ryan Choy's Banking App version 1.0");
		log.info("=============================================");
		int us = 0;
		Scanner scanner = new Scanner(System.in);
		UserCRUD customerCRUD = new UserCRUDImpl();
		UserLogIn userLogIn = new UserLogInImpl();
		do {
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

			case 1:

				try {
					log.info("Please enter your user name");
					String username = scanner.nextLine();
					log.info("Please enter your password");
					String userpassword = scanner.nextLine();
					Customer custom = userLogIn.customerLogIn(username, userpassword);
					String check = userLogIn.customerLogIn(username, userpassword).getCustomerstatus();
					if (check.matches("Pending")) {
						log.info(
								"Sorry, your account is still being processed, please check back later or contact an employee");
					} else if (check.matches("Rejected")) {
						log.info("Sorry, your account is rejected, you may contact an employee for further details.");
					} else {
						log.info("Login successful! Welcome Customer " + custom.getFirstname() + " "
								+ custom.getLastname());
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
								log.info("in construction");

								break;
							case 3:
								log.info("in construction");

								break;
							case 4:
								log.info("in construction");

								break;
							case 5:
								log.info("in construction");

								break;

							default:
								log.info("Invalid choice, please enter a proper choice between 1-4 only...");
								break;
							}
						} while (cu != 5);

					}

				} catch (BusinessBankException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				break;

			case 2:

				try {
					log.info("Please enter your user name");
					String employname = scanner.nextLine();
					log.info("Please enter your password");
					String employpassword = scanner.nextLine();
					Employee employ = userLogIn.employeeLogIn(employname, employpassword);
					if (employ != null) {
						log.info("Login successful! Welcome Employee " + employ.getFirstname() + " "
								+ employ.getLastname());
						int em = 0;
						do {
							log.info("Please enter a number from 1 to 4 to navigate the menu:");
							log.info("1) Approve or Reject accounts");
							log.info("2) View customer's bank accounts");
							log.info("3) View transaction log");
							log.info("4) Log out");

							try {
								em = Integer.parseInt(scanner.nextLine());
							} catch (NumberFormatException e) {
							}

							switch (em) {
							case 1:
								// result set, list, update
								int up = 0;
								do {
									List<Customer> upCustomer = customerCRUD.getPendCustomer();
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
									} catch (NumberFormatException e) {

										e.printStackTrace();
									}

									switch (up) {
									case 1:
										if (pendcust == 0) {
											log.info("There are no pending customer accounts to be processed");
										} else {
											for (int i = 0; i < upCustomer.size(); i++) {
												log.info((i + 1) + ")" + upCustomer.get(i));
											}
											log.info((upCustomer.size() + 1) + ") Cancel the process");
											int selc = 0;
											try {
												log.info("Please enter the customer account between 1 - "
														+ (upCustomer.size() + 1));
												selc = Integer.parseInt(scanner.nextLine());
											} catch (NumberFormatException e) {

											}
											if (selc == 0) {
												log.info("Invalid choice, please enter a proper choice between 1-"
														+ (upCustomer.size() + 1) + " only...");
											}
											if (selc > 0 && selc <= upCustomer.size() + 1) {
												if (selc == upCustomer.size() + 1) {
													break;
												} else {
													// update account here
													int arc = 0;
													do {
														log.info(
																"Enter the following to approve or reject the account.");
														log.info("1) Approve");
														log.info("2) Reject");
														log.info("3) Cancel");

														try {
															arc = Integer.parseInt(scanner.nextLine());
														} catch (NumberFormatException e) {

														}
														switch (arc) {
														case 1:
															// approve
															break;
														case 2:
															// reject
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
												log.info("Invalid choice, please enter a proper choice between 1-"
														+ (upCustomer.size() + 1) + " only...");

											}

										}
										break;
									case 2:

										break;
									case 3:
										log.info("Returning to employee submenu...");
										break;
									default:
										log.info("Invalid choice, please enter a proper choice between 1-3 only...");
										break;
									}
								} while (up != 3);

								break;

							case 2:
								log.info("in construction");
								log.info("Enter the customer's id to view their bank accounts.");

								break;
							case 3:
								log.info("in construction");
								log.info("Loading transaction log");
								log.info("Loading successfull!");

								break;
							case 4:
								log.info("Logging out...");

								break;
							default:
								log.info("Invalid choice, please enter a proper choice between 1-4 only...");
								break;
							}

						} while (em != 4);

					} else {
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
					if (customerCRUD.createCustomer(user, customer) == 2) {
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
