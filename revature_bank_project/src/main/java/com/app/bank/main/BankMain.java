package com.app.bank.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.bank.customer.service.CustomerCRUD;
import com.app.bank.customer.service.impl.CustomerCRUDImpl;
import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.User;



public class BankMain {
	private static Logger log = Logger.getLogger(BankMain.class);

	public static void main(String[] args) {
		log.info("Welcome to Ryan Choy's Banking App version 1.0");
		log.info("=============================================");
		int us = 0;
		Scanner scanner = new Scanner(System.in);
		CustomerCRUD customerCRUD = new CustomerCRUDImpl();
		User customer = new User();

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
				log.info("under construction");
				break;
				
			//log in as employee
			case 2:
				log.info("under construction");
				break;
			case 3:
				//customer creation, account status
				log.info("Enter the following details to create a customer account.");
				log.info("Enter your first name");
				customer.setFirstname(scanner.nextLine());
				log.info("Enter your last name");
				customer.setLastname(scanner.nextLine());
				log.info("Enter your user name");
				customer.setUsername(scanner.nextLine());
				log.info("Enter your password with a minimum length of 8");
				customer.setPassword(scanner.nextLine());
				// reenter your password
				log.info(
						"Enter your email in the following format: example@example.com, all characters except #$%&'*+-/=? are allowed and . are not allowed at the start and the end of the portion before the @");
				customer.setEmail(scanner.nextLine());

				try {
					if (customerCRUD.createCustomer(customer) == 1) {
						log.info("Customer account created successfully with the below details, please wait for an employee to approve it");
						log.info(customer);
					}
				} catch (BusinessBankException e) {
					log.info(e.getMessage());
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
