package com.app.bank.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.bank.exception.BusinessBankException;
import com.app.bank.model.Customer;
import com.app.bank.model.User;
import com.app.bank.user.service.UserCRUD;
import com.app.bank.user.service.impl.UserCRUDImpl;



public class BankMain {
	private static Logger log = Logger.getLogger(BankMain.class);

	public static void main(String[] args) {
		log.info("Welcome to Ryan Choy's Banking App version 1.0");
		log.info("=============================================");
		int us = 0;
		Scanner scanner = new Scanner(System.in);
		UserCRUD customerCRUD = new UserCRUDImpl();
	

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
				log.info("Enter your phone number in the format +1-##########");
				customer.setPhone(scanner.nextLine());
				log.info("Enter your email, it must contain at least an @ and a website");
				customer.setEmail(scanner.nextLine());
				
				try {
					if(customerCRUD.createCustomer(user, customer)==1) {
						log.info(customer);
						log.info(user);
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
