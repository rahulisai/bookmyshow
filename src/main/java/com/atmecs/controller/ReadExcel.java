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

public class ReadExcel {
	// Seat availability variables made static to get accessed by all the methods.
	public static int goldSeatsAvailable = 100;
	public static int silverSeatsAvailable = 150;
	public static int platinumSeatsAvailable = 200;
	int counter = 2;

	public void getExcelData() throws IOException {
		FileInputStream inputStream = new FileInputStream("ExcelDemo.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

		// here removing sheet at 1 to remove previously saved data.
		workbook.removeSheetAt(1);
		XSSFSheet firstSheet = workbook.getSheetAt(0);
		workbook.createSheet("Booked User");

		XSSFSheet secondSheet = workbook.getSheetAt(1);
		try {
			// Creating a collection to store the booked user details.
			Map<Integer, Object[]> empinfo = new TreeMap<>();
			empinfo.put(1, new Object[] { "Name", "Seat Type", "Total Charges", "Number of Seats", "Time" });

			// Here reading excel sheet data row by row
			Iterator<Row> rowIterator = firstSheet.iterator();
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

					// excelObject instance calls the excelToObject method which returns object row
					// by row.
					ExcelOperation excelObject = new ExcelOperation();
					user = excelObject.excelToObject(user, columnIndex, nextCell);
				} // column ending

				// Get the choice from sheet to login or to signup.
				UserRegistration registration = new UserRegistration();
				int flag = registration.userLoginSignUpChoice(user);

				if (flag == 0) {
					// Will check the user information and if user successfully booked the ticket
					// then it will return user object to add into the collection.
					UserInteractionOperation ui = new UserInteractionOperation();
					user = ui.getUserInfo(user);

					if (user != null) {
						empinfo.put(counter, new Object[] { user.getName(), user.getChoice(), user.getTicketcharge(),
								user.getSeatcount(), "6:00" });
						counter++;

					}
				}
			} // row ending

			// After saving booked user detail into collection, adding one more row to
			// display net profit.
			empinfo.put(counter, new Object[] { "Revenue:", Revenue.profit, "", " ", " " });
			// Writing data into the excel sheet
			WriteExcel write = new WriteExcel();
			write.addUserDetails(empinfo, workbook, secondSheet);
		} finally {
			workbook.close();
			inputStream.close();
		}
	}
}
