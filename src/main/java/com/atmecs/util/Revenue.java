package com.atmecs.util;

public class Revenue {
	public static int revenue = 0;

	public static int getProfit(int amount) {
		revenue = revenue + amount;
		return revenue;
	}
}
