package com.atmecs.util;

import com.atmecs.controller.ReadExcel1;
import com.atmecs.pojo.User;

public class SeatOperation {

	int amount = 0;

	public int getSeatChoice(User user) {
		switch (user.getChoice()) {
		case "Gold":
			amount = 200;
			break;
		case "Silver":
			amount = 150;
			break;
		case "Platinum":
			amount = 300;
			break;
		case "Choice":
			break;
		default:
			System.out.println("Please enter a valid choice...");
			amount = 0;
			break;
		}
		return amount;
	}

	public int seatAvailability(User user) {
		int flag = 1;
		switch (user.getChoice()) {
		case "Gold":
			if (ReadExcel1.goldSeatsAvailable == 0) {
				flag = 3;
			} else if (user.getSeatcount() > ReadExcel1.goldSeatsAvailable) {
				flag = 0;
			}
			break;

		case "Silver":
			if (ReadExcel1.silverSeatsAvailable == 0) {
				flag = 3;
			} else if (user.getSeatcount() > ReadExcel1.silverSeatsAvailable) {
				flag = 0;
			}
			break;

		case "Platinum":
			if (ReadExcel1.platinumSeatsAvailable == 0) {
				flag = 3;
			} else if (user.getSeatcount() > ReadExcel1.platinumSeatsAvailable) {
				flag = 0;
			}
			break;

		default:
			flag = 2;
			break;
		}
		return flag;
	}

	public void seatStatus(User user) {
		switch (user.getChoice()) {
		case "Gold":
			ReadExcel1.goldSeatsAvailable = ReadExcel1.goldSeatsAvailable - user.getSeatcount();
			break;
		case "Silver":
			// int silverSeatAvailable=150;
			ReadExcel1.silverSeatsAvailable = ReadExcel1.silverSeatsAvailable - user.getSeatcount();
			break;
		case "Platinum":

			// int platinumSeatAvailable=200;
			ReadExcel1.platinumSeatsAvailable = ReadExcel1.platinumSeatsAvailable - user.getSeatcount();
			break;
		}

	}

	public static void displaySeatStatus() {

		if (ReadExcel1.goldSeatsAvailable == 0 && ReadExcel1.silverSeatsAvailable == 0
				&& ReadExcel1.platinumSeatsAvailable == 0) {

			System.out.println("1.Gold : HouseFull 2.Silver : HouseFull 3.Platinum : HouseFull");

		} else if (ReadExcel1.goldSeatsAvailable == 0 && ReadExcel1.silverSeatsAvailable == 0) {

			System.out.println(
					"1.Gold : HouseFull 2.Silver : HouseFull 3.Platinum : " + ReadExcel1.platinumSeatsAvailable);

		} else if (ReadExcel1.goldSeatsAvailable == 0 && ReadExcel1.platinumSeatsAvailable == 0) {

			System.out.println(
					"1.Gold : HouseFull 2.Silver : " + ReadExcel1.silverSeatsAvailable + " 3.Platinum : HouseFull");

		} else if (ReadExcel1.silverSeatsAvailable == 0 && ReadExcel1.platinumSeatsAvailable == 0) {

			System.out.println(
					"1.Gold :" + ReadExcel1.goldSeatsAvailable + "2.Silver : HouseFull 3.Platinum : HouseFull");

		} else if (ReadExcel1.goldSeatsAvailable == 0) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.Gold : HouseFull  2.Silver : " + ReadExcel1.silverSeatsAvailable + " 3.Platinum : "
					+ ReadExcel1.platinumSeatsAvailable);
			System.out.println("------------------------------------------------------");
		} else if (ReadExcel1.silverSeatsAvailable == 0) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.Gold :" + ReadExcel1.goldSeatsAvailable + " 2.Silver : HouseFull 3.Platinum : "
					+ ReadExcel1.platinumSeatsAvailable);
			System.out.println("------------------------------------------------------");
		} else if (ReadExcel1.platinumSeatsAvailable == 0) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.Gold :" + ReadExcel1.goldSeatsAvailable + " 2.Silver : "
					+ ReadExcel1.silverSeatsAvailable + " 3.Platinum : HouseFull");
			System.out.println("------------------------------------------------------");
		} else {
			System.out.println("------------------------------------------------------");
			System.out.println("1.Gold :" + ReadExcel1.goldSeatsAvailable + " 2.Silver : "
					+ ReadExcel1.silverSeatsAvailable + " 3.Platinum : " + ReadExcel1.platinumSeatsAvailable);
			System.out.println("------------------------------------------------------");

		}
	}

}
