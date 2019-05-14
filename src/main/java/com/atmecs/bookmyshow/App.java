package com.atmecs.bookmyshow;

public class App 
{
    public static void main( String[] args )
    {
    	ReadExcel read=new ReadExcel();
    	read.getExcelData();
    	
    	System.out.println(Revenue.revenue);
    }
}
