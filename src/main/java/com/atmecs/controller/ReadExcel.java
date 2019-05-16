package com.atmecs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atmecs.pojo.User;
import com.atmecs.util.UserRegistration;

public class ReadExcel {

	public void getExcelData() {
		try {
			int rownumberone = 0;
			FileInputStream file = new FileInputStream(new File("ExcelDemo.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				User user = new User();
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				int ColumnNumber = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					ColumnNumber++;
					// Check the cell type and format accordingly
					try {
						switch (cell.getCellTypeEnum()) {
						case NUMERIC:
							if (ColumnNumber == 1) {
								user.setId((int) cell.getNumericCellValue());
							} else if (ColumnNumber == 5) {
								user.setSeatcount((int) cell.getNumericCellValue());
							} else if (ColumnNumber == 6) {
								user.setBalance(cell.getNumericCellValue());
							} else if (ColumnNumber == 11) {
								user.setBankAccount((int) cell.getNumericCellValue());
							}
							break;
						case STRING:
							if (ColumnNumber == 2) {
								user.setName(cell.getStringCellValue());
							} else if (ColumnNumber == 3) {
								user.setLname(cell.getStringCellValue());
							} else if (ColumnNumber == 4) {
								user.setChoice(cell.getStringCellValue());
							} else if (ColumnNumber == 8) {
								user.setLoginChoice(cell.getStringCellValue());
							} else if (ColumnNumber == 9) {
								user.setPassword(cell.getStringCellValue());
							} else if (ColumnNumber == 7) {
								user.setBillprint(cell.getStringCellValue());
							} else if (ColumnNumber == 10) {
								user.setPaymentMode(cell.getStringCellValue());
							}
							break;

						default:
							break;
						}
					} catch (IllegalStateException e) {
						System.out.println("Enter valid details...");
						break;
					}
				}

				if (rownumberone == 0) {
					rownumberone = rownumberone + 1;
					continue;
				} else {
					UserRegistration registration = new UserRegistration();
					if (user.getLoginChoice().equals("SignUp")) {
						registration.userSignUp(user);
					} else if (user.getLoginChoice().equals("Login")) {
						registration.userLogin(user);
					}
					UserInteractionOperation ui = new UserInteractionOperation();
					ui.getUserInfo(user);
					rownumberone = rownumberone + 1;
				}

			}

			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
