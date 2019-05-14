package com.atmecs.util;

import com.atmecs.bookmyshow.FinalBilling;
import com.atmecs.bookmyshow.Revenue;
import com.atmecs.bookmyshow.SeatSelection;
import com.atmecs.bookmyshow.User;
import com.atmecs.bookmyshow.UserRegistration;

public class UserInteraction {
	double charge=0;
	
	public void getUserInfo(User user) {
		System.out.println("Enter your name: ");
		System.out.println(user.getName() + " " + user.getLname());
		System.out.println("Enter your choice: 1.Gold 2.Silver 3.Platinum");
		System.out.println(user.getChoice());
		System.out.println("Enter number of seats: ");
		System.out.println(user.getSeatcount());
		SeatSelection seat = new SeatSelection();
		double amount = seat.getSeatChoice(user);
		if (user.getBalance() < amount) {
			System.out.println("Insufficient Balance...\n\n");
			
		} else {
			double ConvenienceCharges=20;
			FinalBilling bill = new FinalBilling();
		/*	charge = bill.getTotalCharge(user, amount);
			System.out.println("Your total ticket charge: " + charge);*/
			user.setTicketcharge(bill.getTotalCharge(user, amount));
			Revenue.getProfit(ConvenienceCharges);
			UserRegistration reg=new UserRegistration();
			if(reg.paymentMode(user)==1) {
			System.out.println("Do you want to print bill: 1.Yes 2. No");
			System.out.println(user.getBillprint());
			 if(user.getBillprint().equals("Yes")) {
			 printBill(user);
			 }else {
				 System.out.println("\n\n");
			 }
			}
		}
	}

	public void printBill(User user) {
	  System.out.println("******INOX MULTIPLEX********");
	  System.out.println("Name : "+user.getName()+" "+user.getLname());
	  System.out.println("SeatChoice: "+user.getChoice());
	  System.out.println("Amount: "+user.getTicketcharge());
	  System.out.println("Number Of Seats: "+user.getSeatcount());
	  System.out.println("ShowTime: "+"6.00 pm\n\n");
	  
	  }

}
