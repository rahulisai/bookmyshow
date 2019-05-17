package com.atmecs.bookmyshow;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.atmecs.controller.ReadExcel1;
import com.atmecs.pojo.User;
import com.atmecs.util.FinalBilling;
import com.atmecs.util.Revenue;
import com.atmecs.util.SeatOperation;
import com.atmecs.util.UserRegistration;
import com.atmecs.util.Verification;

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
	
	@Test
	public void testSeatStatus() {
		User user = new User();
		user.setChoice("Gold");
		user.setSeatcount(2);
		SeatOperation checkStatus = new SeatOperation();
		checkStatus.seatStatus(user);
		assertEquals(ReadExcel1.goldSeatsAvailable, 98);
	}
	
	@Test
	public void testuserLoginSignUpChoice() {
		User user = new User();
		user.setName("abc");
		user.setLoginChoice("Login");
		user.setId(1);
		user.setPassword("abc123");
		UserRegistration register=new UserRegistration();
		int choice=register.userLoginSignUpChoice(user);
		assertEquals(choice, 0);
	}
	
	@Test
	public void testPaymentbMode() {
		User user = new User();
		user.setId(1);
		user.setName("Ramesh");
		user.setBankAccount(1111);
		user.setPaymentMode("NetBanking");

		Verification verify=new Verification();
		int number=verify.paymentMode(user);
		assertEquals(number, 0);
	}
	
	@Test
	public void testSeatVerification() {
		User user = new User();
		Verification verify=new Verification();
		assertEquals(verify.SeatVerification(user, 4), 1);
	}
}
