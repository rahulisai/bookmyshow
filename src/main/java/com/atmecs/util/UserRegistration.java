package com.atmecs.util;

import com.atmecs.db.DbOperation;
import com.atmecs.pojo.User;

public class UserRegistration {
	DbOperation db = new DbOperation();
	 
	public void userLoginSignUpChoice(User user) {
		switch(user.getLoginChoice()){
			case "SignUp":
				userSignUp(user);
				break;
			case "Login":
				userLogin(user);
				break;
		}
	}
	
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
			System.out.println(user.getName()+" Successfully logged in...\n\n");
		}else {
			System.out.println("Invalid Id or password...\n\n");
		}
	}
}

	

		
	