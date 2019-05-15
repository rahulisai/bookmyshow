package com.atmecs.util;

import com.atmecs.db.DbOperation;
import com.atmecs.pojo.User;

public class AccountVerification {
	DbOperation db = new DbOperation();

	public int paymentMode(User user) {
		int flag = 0;
		if (user.getPaymentMode().equalsIgnoreCase("NetBanking")
				|| user.getPaymentMode().equalsIgnoreCase("CreditCard")) {
			System.out.println("Enter bank account number: ");
			System.out.println(user.getBankAccount());
			User userdb = db.getSpecificUser(user.getId());
			if (userdb.getBankAccount() == user.getBankAccount()) {
				System.out.println("Account Verfied...");
				flag = 1;
			} else {
				System.out.println("Invalid Account Number..");
			}

		}
		return flag;
	}

	public boolean SeatVerification(User user, int flag) {
		switch (flag) {
		case 0:
			System.out.println("You exceed the seat limit...\n\n");
			break;
			
		case 1:
			return true;

		case 2:
			System.out.println("Invalid seat choice...\n\n");
			break;

		case 3:
			System.out.println(user.getChoice()+" is HouseFull.");
			System.out.println("Please choose another seat option\n\n");
		
		}
		return false;
	}
}
