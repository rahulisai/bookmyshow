package com.atmecs.util;

import com.atmecs.bookmyshow.FinalBilling;
import com.atmecs.bookmyshow.Revenue;
import com.atmecs.bookmyshow.SeatSelection;
import com.atmecs.bookmyshow.User;
import com.atmecs.bookmyshow.UserRegistration;

public class UserInteraction {
	double charge = 0;

	public void getUserInfo(User user) {
		System.out.println("Enter your name: ");
		System.out.println(user.getName() + " " + user.getLname());
		System.out.println("Enter your choice: 1.Gold 2.Silver 3.Platinum");
		System.out.println(user.getChoice());
		System.out.println("Enter number of seats: ");
		System.out.println(user.getSeatcount());
		SeatSelection seat = new SeatSelection();
		double amount = seat.getSeatChoice(user);
		if (amount == 0) {
			System.out.println("Please try again later...\n\n");
		} else {
			FinalBilling bill = new FinalBilling();
			user.setTicketcharge(bill.getTotalCharge(user, amount));
			if (user.getBalance() < amount) {
				System.out.println("Insufficient Balance...\n\n");

			} else {
				int ConvenienceCharges = 20;
				Revenue.getProfit(ConvenienceCharges);
				UserRegistration reg = new UserRegistration();
				if (reg.paymentMode(user) == 1) {
					System.out.println("Do you want to print ticket: 1.Yes 2. No");
					System.out.println(user.getBillprint());
					if (user.getBillprint().equals("Yes")) {
						printBill(user);
					}
				}
				System.out.println("\n\n");
			}
		}
	}

	public void printBill(User user) {
		System.out.println("* * * * * * * * * INOX MULTIPLEX * * * * * * * *");
		System.out.println("*  Name : " + user.getName() + " " + user.getLname() + " \t\t\t\t*");
		System.out.println("*  SeatChoice: " + user.getChoice() + "              \t\t*");
		System.out.println("*  Amount: " + user.getTicketcharge() + "            \t\t\t*");
		System.out.println("*  Number Of Seats: " + user.getSeatcount() + "      \t\t\t*");
		System.out.println("*  ShowTime: " + "6.00 pm                          \t*");
		System.out.println("* * * * * * * * * * * * * * * * * * *  * * * * *\n\n");

	}

}
