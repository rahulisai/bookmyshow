package com.atmecs.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atmecs.bookmyshow.User;

public class readdata {

	public static void main(String[] args) {
		try {

			int rownumberone = 0;
			List<User> list = new ArrayList<User>();
			FileInputStream file = new FileInputStream(new File("ExcelDemo2.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			int rownum=1;
			// Iterate through each rows one by one
			try {
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				customer customer = new customer();
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				int columnum=0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly 
					ExcelToObject(workbook,rownum,columnum,customer);
				//	workbook.getSheetAt(0).getRow(rownum).getCell(columnum);
					columnum++;
				}
				rownum++;
				System.out.println(customer);
			}
			}catch(NullPointerException e) {
				
			}

			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	static public void ExcelToObject(XSSFWorkbook workbook,int rownum, int columnnum,customer c) {
		try {
		switch(columnnum) {
		case 0:
			XSSFCell cell1=workbook.getSheetAt(0).getRow(rownum).getCell(0);
			double cellValue = (double) cell1.getNumericCellValue();
			c.setId(cellValue);
			break;
		case 1:
			XSSFCell cell2=workbook.getSheetAt(0).getRow(rownum).getCell(1);
			String cellValue2 = (String) cell2.getStringCellValue();
			c.setName(cellValue2);
			break;
		case 2:
			XSSFCell cell3=workbook.getSheetAt(0).getRow(rownum).getCell(2);
			String cellValue3 = (String) cell3.getStringCellValue();
			c.setLname(cellValue3);
			break;
			default:
				System.out.println("Enter valid details...");
				break;
			
		}
		
		}catch(IllegalStateException e){
			System.out.println("Please enter a valid detail...");
		}
	}
	
}


