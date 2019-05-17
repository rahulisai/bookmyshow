package com.atmecs.util;

public class Revenue {
	public static int profit = 0;

	public static int getProfit(int amount) {
		profit = profit + amount;
		return profit;
	}
}
