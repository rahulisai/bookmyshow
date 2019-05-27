package com.atmecs.util;

import com.atmecs.db.DbOperation;
import com.atmecs.pojo.User;

//This class verify the operation display the message accordingly.
public class Verification {
	DbOperation db = new DbOperation();

	// PaymentMode will be verify and if its proper then verify the bank account
	// number with database.
	public int paymentMode(User user) {
		if (user.getPaymentMode().equalsIgnoreCase("NetBanking")
				|| user.getPaymentMode().equalsIgnoreCase("CreditCard")) {

			System.out.println("Enter bank account number: ");
			System.out.println(user.getBankAccount());
			User userdb = db.getSpecificUser(user.getId());

			if (userdb.getBankAccount() == user.getBankAccount() && userdb.getName().equals(user.getName())) {
				System.out.println("Account Verified...");
				return 0;
			} else {
				return 1;
			}
		}
		return 2;
	}

	// This method will check the flag status and print the message accordingly.
	public int seatVerification(User user, int flag) {
		switch (flag) {
		case 0:
			System.out.println("You exceed the seat limit...\n\n");
			break;

		case 1:
			return 0;

		case 2:
			System.out.println("Invalid seat choice...\n\n");
			break;

		case 3:
			System.out.println(user.getChoice() + " is HouseFull.");
			System.out.println("Please choose another seat option\n\n");
			break;
		case 4:
			System.out.println("Seat cannot be zero\n\n");
			break;
		default:
			System.out.println("Invalid option");
			break;
		}
		return 1;
	}

	// This method will check the flag status and print the message accordingly.
	public int verifyWronginput(User user) {

		switch (paymentMode(user)) {
		case 0:
			return 0;
		case 1:
			System.out.println("Invalid Account Number\n\n");
			break;
		case 2:
			System.out.println("Please enter valid payment option\n\n");
			break;
		default:
			System.out.println("Invalid option\n\n");
			break;
		}
		return 1;
	}

	public static int checkData(User user) {
		switch (user.getLoginChoice().toUpperCase()) {
		case "SIGNUP":
			if (!user.getName().matches("[a-zA-Z]*") || !user.getLname().matches("[a-zA-Z]*")) {
				System.out.print("Invalid input. Enter name: \n\n");
				return 1;
			}
			if (user.getId() == 0.0 || user.getBankAccount() == 0.0 || user.getName() == null || user.getName() == null
					|| user.getLname() == null || user.getLoginChoice() == null || user.getPassword() == null) {
				System.out.println("Please enter valid information\n\n");
				return 1;
			}
			break;
			
		case "LOGIN":
			if (user.getId() == 0.0 || user.getBankAccount() == 0.0 || user.getName() == null || user.getName() == null
					|| user.getLname() == null || user.getLoginChoice() == null || user.getBillprint() == null
					|| user.getPassword() == null || user.getPaymentMode() == null || user.getSeatcount() == 0.0) {
				System.out.println("Please enter valid information\n\n");
				return 1;
			}
			break;
		}
		return 0;
	}
}
