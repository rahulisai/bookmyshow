package com.atmecs.bookmyshow;

public class FinalBilling {

	int ConvenienceCharges = 20;
    double TotalCharge = 0;

	public double getTotalCharge(User user, double amount) {

			SeatSelection seat=new SeatSelection();
			int flag=seat.seatAvailability(user, amount);
			if(flag==1) {
			TotalCharge = user.getSeatcount() * amount + ConvenienceCharges;
			}else if(flag==0) {
				System.out.println("You cross the limit of seat available");
		    }else {
		    	TotalCharge=0;
		    }
		return TotalCharge;
	}
	
	
}
