package com.atmecs.util;

import com.atmecs.db.DbOperation;
import com.atmecs.pojo.User;

public class UserRegistration {
	DbOperation db = new DbOperation();

	public int userLoginSignUpChoice(User user) {
		switch (user.getLoginChoice()) {
		case "SignUp":
			return userSignUp(user);
		case "Login":
			return userLogin(user);
		default:
			System.out.println("Invalid Choice");
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
			if (userdb.getPassword().equals(user.getPassword()) && (userdb.getId() == user.getId())
					&& userdb.getName().equals(user.getName()) && userdb.getName().equals(user.getName())
					&& userdb.getLname().equals(user.getLname())) {
				System.out.println(user.getName() + " Successfully logged in...\n\n");
				return 0;
			} else if (userdb.getName() != user.getName() || userdb.getLname() != user.getLname()) {
				System.out.println("Please enter a valid name\n\n");
			} else {
				System.out.println("Invalid Id or password...\n\n");

			}
		} catch (NullPointerException e) {
			System.out.println("Invalid Id\n\n");
		}

		return 1;
	}
}
