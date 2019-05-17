package com.atmecs.util;

import com.atmecs.pojo.User;

public class FinalBilling {

	int convenienceCharges = 20;
	double totalCharge = 0;

	public double getTotalCharge(User user, double amount) {

		totalCharge = user.getSeatcount() * amount + convenienceCharges;

		return totalCharge;
	}

	public static void printBill(User user) {
		System.out.println("* * * * * * * * * INOX MULTIPLEX * * * * * * * *");
		System.out.println("*  Name : " + user.getName() + " " + user.getLname() + "     \t\t\t*");
		System.out.println("*  SeatChoice: " + user.getChoice() + "              \t\t*");
		System.out.println("*  Amount: " + user.getTicketcharge() + "            \t\t\t*");
		System.out.println("*  Number Of Seats: " + user.getSeatcount() + "      \t\t\t*");
		System.out.println("*  ShowTime: " + "6.00 pm                          \t*");
		System.out.println("* * * * * * * * * * * * * * * * * * *  * * * * *");
		System.out.println("------------------------------------------------------------");
	}

}
