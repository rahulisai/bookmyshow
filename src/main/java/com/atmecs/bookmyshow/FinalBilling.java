package com.atmecs.bookmyshow;

public class FinalBilling {

	int ConvenienceCharges = 20;
    double TotalCharge = 0;

	public double getTotalCharge(User user, double Amount) {

		if (user.getBalance() > Amount) {
			TotalCharge = user.getSeatcount() * Amount + ConvenienceCharges;
		}
		return TotalCharge;
	}
	
	
}
