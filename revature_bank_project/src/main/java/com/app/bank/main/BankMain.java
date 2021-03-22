package com.app.bank.main;

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
		UserLogIn userLogIn = null;

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
				userLogIn = new UserLogInImpl();
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
					}

				} catch (BusinessBankException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				break;

			// log in as employee
			case 2:
				userLogIn = new UserLogInImpl();
				try {
				log.info("Please enter your user name");
				String username = scanner.nextLine();
				log.info("Please enter your password");
				String userpassword = scanner.nextLine();
				Employee employ = userLogIn.employeeLogIn(username, userpassword);
				log.info("Login successful! Welcome Employee "+employ.getFirstname()+" "+employ.getLastname());
				} catch (BusinessBankException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
