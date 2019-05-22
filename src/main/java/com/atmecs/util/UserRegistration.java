package com.atmecs.util;

import com.atmecs.db.DbOperation;
import com.atmecs.pojo.User;

public class UserRegistration {
	DbOperation db = new DbOperation();

	public int userLoginSignUpChoice(User user) {
		switch (user.getLoginChoice().toUpperCase()) {
		case "SIGNUP":
			if(userSignUp(user)==0) {
				System.out.println(user.getName() +" successfully registered\n\n");
			}
			break;
		case "LOGIN":
			return userLogin(user);
		default:
			System.out.println("Invalid Choice\n\n");
			break;
		}
		return 1;
	}

	public int userSignUp(User user) {
		System.out.println("BookMyShow");
		System.out.println("1.Login 2.SignUp");
		System.out.println(user.getLoginChoice());
		System.out.println("Enter your Id:");
		System.out.println(user.getId());
		System.out.println("Enter your Name:");
		System.out.println(user.getName());
		System.out.println("Enter your Last Name:");
		System.out.println(user.getLname());
		System.out.println("Enter your Password:");
		System.out.println(user.getPassword());
		return db.addUser(user);
	}

	public int userLogin(User user) {
		System.out.println("BookMyShow");
		System.out.println("1.Login 2.SignUp");
		System.out.println(user.getLoginChoice());
		System.out.println("Enter your Id:");
		System.out.println(user.getId());
		System.out.println("Enter your Password:");
		System.out.println(user.getPassword());

		// Created the object for the entry available in the database to compare it with
		// object get from the excel.
		User userdb = db.getSpecificUser(user.getId());
		try {
			if (userdb.getPassword().equals(user.getPassword()) && (userdb.getId() == user.getId())) {
				System.out.println(user.getName() + " Successfully logged in...\n");
				return 0;
			}
		} catch (NullPointerException e) {
			System.out.println("User not Registered\n\n");
		}

		return 1;
	}
}
