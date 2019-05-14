package com.atmecs.bookmyshow;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class AppTest{
	@Test
	public void testFinalBilling() {
		User user=new User();
		user.setBalance(15000);
		user.setSeatcount(4);
		int amount=200;
		FinalBilling bill=new FinalBilling();
		double TotalCharge=bill.getTotalCharge(user, amount);
		assertEquals(TotalCharge, 820.0);
	}
	
	@Test
	public void testRevenue() {
		int Amount=20,Total=0;
		for(int i=0;i<4;i++) {
			Total=Revenue.getProfit(Amount);
		}
		assertEquals(Total, 80);
	}
	
	@Test
	public void testSeatSelection() {
		User user=new User();
		user.setChoice("Gold");
		SeatSelection seat=new SeatSelection();
		int amount=seat.getSeatChoice(user);
		assertEquals(amount, 200);
	}
}

