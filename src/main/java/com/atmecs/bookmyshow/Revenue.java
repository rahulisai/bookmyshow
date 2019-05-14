package com.atmecs.bookmyshow;

public class Revenue {
	static int revenue=0;
	public static int getProfit(int amount) {
	  revenue=revenue+amount;
	  return revenue;
	}
}
