package com.app.bank.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class BankMain {
	private static Logger log = Logger.getLogger(BankMain.class);

	public static void main(String[] args) {
		log.info("Welcome to Ryan Choy's Banking App version 1.0");
		log.info("=============================================");
		int us = 0;
		Scanner scanner = new Scanner(System.in);
		
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
		case 2:
			log.info("under construction");
			break;
		case 3:
			log.info("under construction");
			break;
		case 4:
			log.info("Thank you for using the Banking App version 1.0, exiting the program...");
			break;

		default:
			log.info("Invalid choice, please enter a proper choice between 1-4 only...");
			break;
		}
			
		} while (us != 4);
		
		//are you an employee or customer?
		//enter your username and password
				
	}

}
