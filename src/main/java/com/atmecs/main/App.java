package com.atmecs.main;

import java.io.IOException;

import com.atmecs.controller.ReadExcel1;
import com.atmecs.util.Revenue;

public class App 
{
    public static void main( String[] args )
    {
    	ReadExcel1 read=new ReadExcel1();
    	try {
			read.getExcelData();
		} catch (IOException e) {
			System.out.println("Exception Occurred");
		}
    	System.out.println("Total Revenue: "+Revenue.revenue);
    }
}
