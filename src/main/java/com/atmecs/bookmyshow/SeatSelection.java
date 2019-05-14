package com.atmecs.bookmyshow;

public class SeatSelection {

	double amount=0;
	 
		public double getSeatChoice(User user) {
		switch(user.getChoice()) {
			case "Gold":
				amount=200;
				break;
			case "Silver":
				amount=150;
				break;
			case "Platinum":
				amount=300;
				break;
			case "Choice":
				break;
			default:
				System.out.println("Please enter a valid choice...");
				break;
			}
		return amount;
		}
		
}
