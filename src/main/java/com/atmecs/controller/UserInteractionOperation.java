package com.atmecs.controller;

import com.atmecs.pojo.User;
import com.atmecs.util.AccountVerification;
import com.atmecs.util.FinalBilling;
import com.atmecs.util.Revenue;
import com.atmecs.util.SeatOperation;

public class UserInteractionOperation {
	double charge = 0;

	public void getUserInfo(User user) {
		System.out.println("Enter your name: ");
		System.out.println(user.getName() + " " + user.getLname());
		System.out.println("Number of seats available: ");
		System.out.println("------------------------------------------------------");
		System.out.println("1.Gold :" +ReadExcel1.goldSeatAvailable+" 2.Silver : "+ReadExcel1.silverSeatAvailable+ " 3.Platinum : "+ReadExcel1.platinumSeatAvailable);
		System.out.println("------------------------------------------------------");
		System.out.println("Enter your choice: 1.Gold 2.Silver 3.Platinum");
		System.out.println(user.getChoice());
		System.out.println("Enter number of seats: ");
		System.out.println(user.getSeatcount());

		SeatOperation seat = new SeatOperation();
		int flag = seat.seatAvailability(user);
		
		AccountVerification verify = new AccountVerification();
		boolean value = verify.SeatVerification(user, flag);
		
		if (value) {
			FinalBilling bill = new FinalBilling();
			double amount = seat.getSeatChoice(user);
			user.setTicketcharge(bill.getTotalCharge(user, amount));

			if (user.getBalance() > amount) {
				int ConvenienceCharges = 20;
				Revenue.getProfit(ConvenienceCharges);
				AccountVerification account = new AccountVerification();
				if (account.paymentMode(user) == 1) {
					seat.seatStatus(user);
					System.out.println("Do you want to print ticket: 1.Yes 2. No");
					System.out.println(user.getBillprint());
					if (user.getBillprint().equals("Yes\n\n")) {
						FinalBilling.printBill(user);
					}
				}
				System.out.println("\n\n");
			} else {
				System.out.println("Insufficient Balance...\n\n");
			}
		}
	}
}
