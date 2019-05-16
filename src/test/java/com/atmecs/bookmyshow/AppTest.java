package com.atmecs.bookmyshow;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.atmecs.pojo.User;
import com.atmecs.util.FinalBilling;
import com.atmecs.util.Revenue;
import com.atmecs.util.SeatOperation;

public class AppTest {
	@Test
	public void testFinalBilling() {
		User user = new User();
		user.setBalance(15000);
		user.setSeatcount(4);
		user.setChoice("Gold");
		int amount = 200;
		FinalBilling bill = new FinalBilling();
		double TotalCharge = bill.getTotalCharge(user, amount);
		assertEquals(TotalCharge, 820.0);
	}

	@Test
	public void testRevenue() {
		int Amount = 20, Total = 0;
		for (int i = 0; i < 4; i++) {
			Total = Revenue.getProfit(Amount);
		}
		assertEquals(Total, 80);
	}

	@Test
	public void testSeatSelection() {
		User user = new User();
		user.setChoice("Gold");
		SeatOperation seat = new SeatOperation();
		int amount = seat.getSeatChoice(user);
		assertEquals(amount, 200);
	}

	@Test
	public void testSeatAvailability() {
		User user = new User();
		user.setSeatcount(4);
		user.setChoice("Platinum");
		SeatOperation selectSeat = new SeatOperation();
		int flag = selectSeat.seatAvailability(user);
		assertEquals(flag, 1);
	}

}
