package com.atmecs.util;

import com.atmecs.db.DbOperation;
import com.atmecs.pojo.User;

public class Verification {
	DbOperation db = new DbOperation();

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

	public int SeatVerification(User user, int flag) {
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

		case 4:
			System.out.println("Seat cannot be zero");

		}
		return 1;
	}

	public int verifyWronginput(User user) {

		switch (paymentMode(user)) {
		case 0:
			return 0;
		case 1:
			System.out.println("Invalid Account Number or Name");
			break;
		case 2:
			System.out.println("Please enter valid payment option");
			break;
		}
		return 1;
	}
}
