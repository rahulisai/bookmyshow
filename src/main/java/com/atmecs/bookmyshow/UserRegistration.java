package com.atmecs.bookmyshow;

import com.atmecs.db.DbOperation;

public class UserRegistration {
	DbOperation db = new DbOperation();
	 
	public void userSignUp(User user) {
		System.out.println("BookMyShow");
		System.out.println("1.Login 2.SignUp");
		System.out.println(user.getLoginChoice());
		System.out.println("Enter your Id:");
		System.out.println(user.getId());
		System.out.println("Enter your Name:");
		System.out.println(user.getName());
		System.out.println("Enter your Password:");
		System.out.println(user.getPassword() + "\n\n");
		
		db.addUser(user);
	}

	public void userLogin(User user) {
		System.out.println("BookMyShow");
		System.out.println("1.Login 2.SignUp");
		System.out.println(user.getLoginChoice());
		System.out.println("Enter your Id:");
		System.out.println(user.getId());
		System.out.println("Enter your Password:");
		System.out.println(user.getPassword());
		
		User userdb=db.getSpecificUser(user.getId());
		if(userdb.getPassword().equals(user.getPassword()) && (userdb.getId()==user.getId())) {
			System.out.println("User Successfully logged in...\n\n");
		}else {
			System.out.println("Invalid Id or password...\n\n");
		}
	}

	public int paymentMode(User user) {
		int flag=0;
		if(user.getPaymentMode().equalsIgnoreCase("NetBanking") || user.getPaymentMode().equalsIgnoreCase("CreditCard")) {
			System.out.println("Enter bank account number: ");
			System.out.println(user.getBankAccount());
			User userdb=db.getSpecificUser(user.getId());
			if(userdb.getBankAccount()==user.getBankAccount()) {
				System.out.println("Account Verfied...");
				flag=1;
			}else {
				System.out.println("Invalid Account Number..");
			}
			
		}
		return flag;
	}
}

	

		
	