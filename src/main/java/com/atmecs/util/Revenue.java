package com.atmecs.util;

//A revenue class will return the total revenue based on the number of tickets booked.
public class Revenue {
	public static int profit = 0;

	public static int getProfit(int amount) {
		profit = profit + amount;
		return profit;
	}
}
