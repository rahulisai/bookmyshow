package com.atmecs.bookmyshow;

public class SeatSelection {

	int amount=0;
	 
		public int getSeatChoice(User user) {
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
				amount=0;
				break;
			}
		return amount;
		}
		

		public int seatAvailability(User user, double amount) {
			int flag=1;
				switch(user.getChoice()) {
				case "Gold":
					int goldSeatAvailable=100;
					if(user.getSeatcount()>goldSeatAvailable) {
						flag=0;
					}
					break;
				case "Silver":
					int silverSeatAvailable=150;
					if(user.getSeatcount()>silverSeatAvailable) {
						flag=0;
					}
					break;
				case "Platinum":
					int platinumSeatAvailable=200;
					if(user.getSeatcount()>platinumSeatAvailable) {
						flag=0;
					}
					break;
					
				default:
					System.out.println("Invalid choice...");
					flag=2;
					break;
				}
			return flag;
		}
		
}
