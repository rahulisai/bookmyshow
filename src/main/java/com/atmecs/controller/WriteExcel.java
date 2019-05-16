package com.atmecs.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	// Create row object
	XSSFRow row;

	public void addUserDetails(Map<Integer, Object[]> empinfo, XSSFWorkbook workbook, XSSFSheet secondSheet)
			throws IOException {

		// Iterate over data and write to sheet
		Set<Integer> keyid = empinfo.keySet();
		int rowid = 0;

		for (Integer key : keyid) {
			row = secondSheet.createRow(rowid++);
			Object[] objectArr = empinfo.get(key);
			int cellid = 0;

			for (Object obj : objectArr) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue(String.valueOf(obj));
			}
		}
		FileOutputStream out = new FileOutputStream(new File("ExcelDemo.xlsx"));

		workbook.write(out);
		out.close();
	}

}
