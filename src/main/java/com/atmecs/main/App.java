package com.atmecs.main;

import java.io.IOException;
import com.atmecs.controller.ReadExcel;
import com.atmecs.util.Revenue;

/*
 * This a bookmyshow application for booking movie tickets.
 * @author Rahul Isai
 * @version 1.0
 */
		
public class App {

	/*
	 * This method calls ReadExcel class to read the data from excel sheet
	 */
	public static void main(String[] args) {
		
		ReadExcel read = new ReadExcel();
		try {
			read.getExcelData();
		} catch (IOException e) {
			System.out.println("File Not Found");
		}
		System.out.println("Total Revenue: " + Revenue.profit);
	}
}
