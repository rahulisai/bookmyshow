package com.atmecs.util;

import com.atmecs.controller.ReadExcel1;
import com.atmecs.pojo.User;

public class SeatOperation {

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
		

		public int seatAvailability(User user) {
			int flag=1;
				switch(user.getChoice()) {
				case "Gold":
				//	int goldSeatAvailable=100;
					if(user.getSeatcount()>ReadExcel1.goldSeatAvailable) {
						flag=0;
					}
					break;
				case "Silver":
				//	int silverSeatAvailable=150;
					if(user.getSeatcount()>ReadExcel1.silverSeatAvailable) {
						flag=0;
					}
					break;
				case "Platinum":
					
				//	int platinumSeatAvailable=200;
					if(user.getSeatcount()>ReadExcel1.platinumSeatAvailable) {
						flag=0;
					}
					break;
					
				default:
					flag=2;
					break;
				}
			return flag;
		}


		public void seatStatus(User user) {
			switch(user.getChoice()) {
			case "Gold":
				ReadExcel1.goldSeatAvailable=ReadExcel1.goldSeatAvailable-user.getSeatcount();
				break;
			case "Silver":
			//	int silverSeatAvailable=150;
				ReadExcel1.silverSeatAvailable=ReadExcel1.silverSeatAvailable-user.getSeatcount();
				break;
			case "Platinum":
				
			//	int platinumSeatAvailable=200;
				ReadExcel1.platinumSeatAvailable=ReadExcel1.platinumSeatAvailable-user.getSeatcount();
				break;
			}
			
		}
		
}
