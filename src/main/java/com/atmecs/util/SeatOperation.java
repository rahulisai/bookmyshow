package com.atmecs.util;

import com.atmecs.controller.ReadExcel1;
import com.atmecs.pojo.User;

public class SeatOperation {
	public static final String GOLD = "Gold";
	public static final String SILVER = "Silver";
	public static final String PLATINUM = "Platinum";
	static final String LINE = "------------------------------------------------------";

	public int getSeatChoice(User user) {
		switch (user.getChoice()) {
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

	public int seatAvailability(User user) {
		int flag = 1;
		switch (user.getChoice()) {
		case GOLD:
			if (ReadExcel1.goldSeatsAvailable == 0) {
				flag = 3;
			} else if (user.getSeatcount() > ReadExcel1.goldSeatsAvailable) {
				flag = 0;
			} else if (user.getSeatcount() == 0) {
				flag = 4;
			}
			break;

		case SILVER:
			if (ReadExcel1.silverSeatsAvailable == 0) {
				flag = 3;
			} else if (user.getSeatcount() > ReadExcel1.silverSeatsAvailable) {
				flag = 0;
			} else if (user.getSeatcount() == 0) {
				flag = 4;
			}
			break;

		case PLATINUM:
			if (ReadExcel1.platinumSeatsAvailable == 0) {
				flag = 3;
			} else if (user.getSeatcount() > ReadExcel1.platinumSeatsAvailable) {
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

	public static void seatStatus(User user) {
		switch (user.getChoice()) {
		case GOLD:
			ReadExcel1.goldSeatsAvailable = ReadExcel1.goldSeatsAvailable - user.getSeatcount();
			break;
		case SILVER:
			ReadExcel1.silverSeatsAvailable = ReadExcel1.silverSeatsAvailable - user.getSeatcount();
			break;
		case PLATINUM:
			ReadExcel1.platinumSeatsAvailable = ReadExcel1.platinumSeatsAvailable - user.getSeatcount();
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}

	}

	public static void displaySeatStatus() {

		if (ReadExcel1.goldSeatsAvailable == 0 && ReadExcel1.silverSeatsAvailable == 0
				&& ReadExcel1.platinumSeatsAvailable == 0) {

			System.out.println("1. GOLD : HouseFull 2.SILVER : HouseFull 3.PLATINUM : HouseFull");

		} else if (ReadExcel1.goldSeatsAvailable == 0 && ReadExcel1.silverSeatsAvailable == 0) {

			System.out.println(
					"1.GOLD : HouseFull 2.SILVER : HouseFull 3.PLATINUM : " + ReadExcel1.platinumSeatsAvailable);

		} else if (ReadExcel1.goldSeatsAvailable == 0 && ReadExcel1.platinumSeatsAvailable == 0) {

			System.out.println(
					"1. GOLD: HouseFull 2.SILVER : " + ReadExcel1.silverSeatsAvailable + " 3.PLATINUM : HouseFull");

		} else if (ReadExcel1.silverSeatsAvailable == 0 && ReadExcel1.platinumSeatsAvailable == 0) {

			System.out.println(
					"1.GOLD: " + ReadExcel1.goldSeatsAvailable + "2.SILVER : HouseFull 3.PLATINUM : HouseFull");

		} else if (ReadExcel1.goldSeatsAvailable == 0) {
			System.out.println(LINE);
			System.out.println("1. GOLD : HouseFull  2.SILVER : " + ReadExcel1.silverSeatsAvailable + " 3.PLATINUM : "
					+ ReadExcel1.platinumSeatsAvailable);
			System.out.println(LINE);

		} else if (ReadExcel1.silverSeatsAvailable == 0) {
			System.out.println(LINE);
			System.out.println("1. GOLD :" + ReadExcel1.goldSeatsAvailable + " 2.SILVER : HouseFull 3.PLATINUM : "
					+ ReadExcel1.platinumSeatsAvailable);

			System.out.println(LINE);
		} else if (ReadExcel1.platinumSeatsAvailable == 0) {
			System.out.println(LINE);
			System.out.println("1.GOLD :" + ReadExcel1.goldSeatsAvailable + " 2.SILVER : "
					+ ReadExcel1.silverSeatsAvailable + " 3.PLATINUM : HouseFull");
			System.out.println(LINE);

		} else {
			System.out.println(LINE);
			System.out.println("1.GOLD :" + ReadExcel1.goldSeatsAvailable + " 2.SILVER : "
					+ ReadExcel1.silverSeatsAvailable + " 3.PLATINUM : " + ReadExcel1.platinumSeatsAvailable);
			System.out.println(LINE);

		}
	}

}
