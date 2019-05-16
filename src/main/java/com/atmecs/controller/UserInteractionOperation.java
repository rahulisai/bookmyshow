package com.atmecs.controller;

import com.atmecs.pojo.User;
import com.atmecs.util.AccountVerification;
import com.atmecs.util.FinalBilling;
import com.atmecs.util.Revenue;
import com.atmecs.util.SeatOperation;

public class UserInteractionOperation {
	double charge = 0;

	public User getUserInfo(User user) {
		System.out.println("Enter your name: ");
		System.out.println(user.getName() + " " + user.getLname());
		System.out.println("Number of seats available: ");
		SeatOperation.displaySeatStatus();

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
				AccountVerification account = new AccountVerification();
				if (account.paymentMode(user) == 1) {
					Revenue.getProfit(ConvenienceCharges);
					seat.seatStatus(user);
					System.out.println("Do you want to print ticket: 1.Yes 2. No");
					System.out.println(user.getBillprint());
					if (user.getBillprint().equals("Yes")) {
						FinalBilling.printBill(user);
					}
					System.out.println("\n\n");
					return user;
				}else {
					System.out.println("Please enter valid payment option");
				}
				System.out.println("\n\n");
			} else {
				System.out.println("Insufficient Balance...\n\n");
			}
		}
		return null;
	}
}
