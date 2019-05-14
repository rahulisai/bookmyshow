package com.atmecs.bookmyshow;

public class Revenue {
	static double revenue=0;
	public static double getProfit(double amount) {
	  revenue=revenue+amount;
	  return revenue;
	}
}
