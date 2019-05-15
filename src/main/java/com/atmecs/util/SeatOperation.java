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
					if(ReadExcel1.goldSeatAvailable==0) {
						flag=3;
					}else if(user.getSeatcount()>ReadExcel1.goldSeatAvailable) {
						flag=0;
					}
					break;
					
				case "Silver":
					if(ReadExcel1.silverSeatAvailable==0) {
						flag=3;
					}else if(user.getSeatcount()>ReadExcel1.silverSeatAvailable) {
						flag=0;
					}
					break;
					
				case "Platinum":
					if(ReadExcel1.platinumSeatAvailable==0) {
						flag=3;
					}
					else if(user.getSeatcount()>ReadExcel1.platinumSeatAvailable) {
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
		
		public static void displaySeatStatus() {
			if(ReadExcel1.goldSeatAvailable==0) {
				System.out.println("------------------------------------------------------");
				System.out.println("1.Gold : HouseFull  2.Silver : "+ReadExcel1.silverSeatAvailable+ " 3.Platinum : "+ReadExcel1.platinumSeatAvailable);
				System.out.println("------------------------------------------------------");
			}else if(ReadExcel1.silverSeatAvailable==0) {
				System.out.println("------------------------------------------------------");
				System.out.println("1.Gold :" +ReadExcel1.goldSeatAvailable+" 2.Silver : HouseFull 3.Platinum : "+ReadExcel1.platinumSeatAvailable);
				System.out.println("------------------------------------------------------");
			}else if(ReadExcel1.platinumSeatAvailable==0 ) {
				System.out.println("------------------------------------------------------");
				System.out.println("1.Gold :" +ReadExcel1.goldSeatAvailable+" 2.Silver : "+ReadExcel1.silverSeatAvailable+ " 3.Platinum : HouseFull");
				System.out.println("------------------------------------------------------");
			}else {
				System.out.println("------------------------------------------------------");
				System.out.println("1.Gold :" +ReadExcel1.goldSeatAvailable+" 2.Silver : "+ReadExcel1.silverSeatAvailable+ " 3.Platinum : "+ReadExcel1.platinumSeatAvailable);
				System.out.println("------------------------------------------------------");
				
			}
		}
		
}
