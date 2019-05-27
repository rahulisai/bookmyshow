package com.atmecs.util;

import com.atmecs.controller.ReadExcel;
import com.atmecs.pojo.User;

/*
 * This class perform operations regarding seat. 
 */
public class SeatOperation {
	public static final String GOLD = "GOLD";
	public static final String SILVER = "SILVER";
	public static final String PLATINUM = "PLATINUM";
	static final String LINE = "------------------------------------------------------";

	// This method return seat rate based on user user choice.
	public int getSeatRate(User user) {
		switch (user.getChoice().toUpperCase()) {
		case GOLD:
			return 200;
		case SILVER:
			return 150;
		case PLATINUM:
			return 300;
		default:
			System.out.println("Please enter a valid choice...");
			break;
		}
		return 0;
	}

	// It will check the availability of seat and return the number according.
	public int seatAvailability(User user) {
		int flag = 1;
		switch (user.getChoice().toUpperCase()) {
		case GOLD:
			if (ReadExcel.goldSeatsAvailable == 0) {
				flag = 3;
			} else if (user.getSeatcount() > ReadExcel.goldSeatsAvailable) {
				flag = 0;
			} else if (user.getSeatcount() == 0) {
				flag = 4;
			}
			break;

		case SILVER:
			if (ReadExcel.silverSeatsAvailable == 0) {
				flag = 3;
			} else if (user.getSeatcount() > ReadExcel.silverSeatsAvailable) {
				flag = 0;
			} else if (user.getSeatcount() == 0) {
				flag = 4;
			}
			break;

		case PLATINUM:
			if (ReadExcel.platinumSeatsAvailable == 0) {
				flag = 3;
			} else if (user.getSeatcount() > ReadExcel.platinumSeatsAvailable) {
				flag = 0;
			} else if (user.getSeatcount() == 0) {
				flag = 4;
			}
			break;

		default:
			flag = 2;
			break;
		}
		return flag;
	}

	// It will calculate the number of seats available
	public static void seatStatus(User user) {
		switch (user.getChoice().toUpperCase()) {
		case GOLD:
			ReadExcel.goldSeatsAvailable = ReadExcel.goldSeatsAvailable - user.getSeatcount();
			break;
		case SILVER:
			ReadExcel.silverSeatsAvailable = ReadExcel.silverSeatsAvailable - user.getSeatcount();
			break;
		case PLATINUM:
			ReadExcel.platinumSeatsAvailable = ReadExcel.platinumSeatsAvailable - user.getSeatcount();
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}

	}

	// it will show the seat status to the console.
	public static void displaySeatStatus() {

		if (ReadExcel.goldSeatsAvailable == 0 && ReadExcel.silverSeatsAvailable == 0
				&& ReadExcel.platinumSeatsAvailable == 0) {

			System.out.println(LINE);
			System.out.println("1. GOLD : HouseFull 2.SILVER : HouseFull 3.PLATINUM : HouseFull");
			System.out.println(LINE);

		} else if (ReadExcel.goldSeatsAvailable == 0 && ReadExcel.silverSeatsAvailable == 0) {

			System.out.println(LINE);
			System.out.println(
					"1.GOLD : HouseFull 2.SILVER : HouseFull 3.PLATINUM : " + ReadExcel.platinumSeatsAvailable);
			System.out.println(LINE);

		} else if (ReadExcel.goldSeatsAvailable == 0 && ReadExcel.platinumSeatsAvailable == 0) {

			System.out.println(LINE);
			System.out.println(
					"1. GOLD: HouseFull 2.SILVER : " + ReadExcel.silverSeatsAvailable + " 3.PLATINUM : HouseFull");
			System.out.println(LINE);

		} else if (ReadExcel.silverSeatsAvailable == 0 && ReadExcel.platinumSeatsAvailable == 0) {

			System.out.println(LINE);
			System.out
					.println("1.GOLD: " + ReadExcel.goldSeatsAvailable + "2.SILVER : HouseFull 3.PLATINUM : HouseFull");
			System.out.println(LINE);

		} else if (ReadExcel.goldSeatsAvailable == 0) {

			System.out.println(LINE);
			System.out.println("1. GOLD : HouseFull  2.SILVER : " + ReadExcel.silverSeatsAvailable + " 3.PLATINUM : "
					+ ReadExcel.platinumSeatsAvailable);
			System.out.println(LINE);

		} else if (ReadExcel.silverSeatsAvailable == 0) {

			System.out.println(LINE);
			System.out.println("1. GOLD :" + ReadExcel.goldSeatsAvailable + " 2.SILVER : HouseFull 3.PLATINUM : "
					+ ReadExcel.platinumSeatsAvailable);
			System.out.println(LINE);

		} else if (ReadExcel.platinumSeatsAvailable == 0) {

			System.out.println(LINE);
			System.out.println("1.GOLD :" + ReadExcel.goldSeatsAvailable + " 2.SILVER : "
					+ ReadExcel.silverSeatsAvailable + " 3.PLATINUM : HouseFull");
			System.out.println(LINE);

		} else {

			System.out.println(LINE);
			System.out.println("1.GOLD :" + ReadExcel.goldSeatsAvailable + " 2.SILVER : "
					+ ReadExcel.silverSeatsAvailable + " 3.PLATINUM : " + ReadExcel.platinumSeatsAvailable);
			System.out.println(LINE);

		}
	}

}
