package com.atmecs.controller;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atmecs.pojo.User;
import com.atmecs.util.UserRegistration;

public class ReadExcel1 {

	public static int  goldSeatAvailable=100,silverSeatAvailable=150, platinumSeatAvailable=200;
	public void getExcelData() throws IOException {
		FileInputStream inputStream = new FileInputStream("ExcelDemo.xlsx");

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = firstSheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			User user = new User();
				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();
					
					ExcelOperation excelObject=new ExcelOperation();
					user=excelObject.excelToObject(user, columnIndex, nextCell);	
				}
				if(row.getRowNum()==0) {
					continue;
				}
				
				UserRegistration registration=new UserRegistration();
				registration.userLoginSignUpChoice(user);
		
				UserInteractionOperation ui=new UserInteractionOperation();
				ui.getUserInfo(user);
				}
		workbook.close();
		inputStream.close();
		}
		
	}

	