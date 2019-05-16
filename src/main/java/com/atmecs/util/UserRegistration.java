package com.atmecs.util;

import com.atmecs.controller.ReadExcel1;
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

		User userdb = db.getSpecificUser(user.getId());
		if (userdb.getPassword().equals(user.getPassword()) && (userdb.getId() == user.getId())) {
			System.out.println(user.getName() + " Successfully logged in...\n\n");
			return 0;
		} else {
			System.out.println("Invalid Id or password...\n\n");
			return 1;
		}
		
	}
}
