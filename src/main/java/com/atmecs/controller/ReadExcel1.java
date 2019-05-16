package com.atmecs.controller;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atmecs.pojo.User;
import com.atmecs.util.Revenue;
import com.atmecs.util.UserRegistration;

public class ReadExcel1 {

	public static int goldSeatsAvailable = 100, silverSeatsAvailable = 150, platinumSeatsAvailable = 200, counter = 2, errObj=0;

	public void getExcelData() throws IOException {
		FileInputStream inputStream = new FileInputStream("ExcelDemo.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet firstSheet = workbook.getSheetAt(0);

		XSSFSheet SecondSheet = workbook.getSheetAt(1);

		Map<Integer, Object[]> empinfo = new TreeMap<Integer, Object[]>();
		empinfo.put(1, new Object[] { "Name", "Seat Type", "Total Charges", "Number of Seats", "Time" });
		Iterator<Row> rowIterator = firstSheet.iterator();
		try {
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			User user = new User();

			if (row.getRowNum() == 0) {
				continue;
			}

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();

				ExcelOperation excelObject = new ExcelOperation();
				user = excelObject.excelToObject(user, columnIndex, nextCell);
			}//column ending

			UserRegistration registration = new UserRegistration();
			int flag=registration.userLoginSignUpChoice(user);
			if(flag==0) {
			UserInteractionOperation ui = new UserInteractionOperation();
			user = ui.getUserInfo(user);
			if (user != null) {
				empinfo.put(counter, new Object[] { user.getName(), user.getChoice(), user.getTicketcharge(),
						user.getSeatcount(), "6:00" });
				counter++;
			
			}
			}
		}//row ending
		}catch(Exception e) {
			System.out.println("Please enter valid data...");
		}
		empinfo.put(counter, new Object[] { "Revenue:", Revenue.revenue, "", " ", " " });
		WriteExcel write = new WriteExcel();
		write.addUserDetails(empinfo, workbook, SecondSheet);

		workbook.close();
		inputStream.close();
	}

}

