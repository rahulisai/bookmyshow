package com.atmecs.controller;

import org.apache.poi.ss.usermodel.Cell;

import com.atmecs.db.DbOperation;
import com.atmecs.pojo.User;

public class ExcelOperation {
	DbOperation db = new DbOperation();

	private Object getCellValue(Cell cell) {
		switch (cell.getCellTypeEnum()) {
		case STRING:
			return cell.getStringCellValue();

		case BOOLEAN:
			return cell.getBooleanCellValue();

		case NUMERIC:
			return cell.getNumericCellValue();

		default:
			break;
		}

		return null;
	}

	public User excelToObject(User user, int columnIndex, Cell nextCell) {

			switch (columnIndex) {
			case 0:
				double id;
				id = (double) getCellValue(nextCell);
				user.setId((int) id);
				break;
			case 1:
				user.setName((String) getCellValue(nextCell)); 
				break;
			case 2:
				user.setLname((String) getCellValue(nextCell));
				break;
			case 3:
				user.setChoice((String) getCellValue(nextCell));
				break;
			case 4:
				double seatCount;
				seatCount = (double) getCellValue(nextCell);
				user.setSeatcount((int) seatCount);
				break;
			case 5:
				user.setBalance((double) getCellValue(nextCell));
				break;
			case 6:
				user.setBillprint((String) getCellValue(nextCell));
				break;
			case 7:
				user.setLoginChoice((String) getCellValue(nextCell));
				break;
			case 8:
				user.setPassword((String) getCellValue(nextCell));
				break;
			case 9:
				user.setPaymentMode((String) getCellValue(nextCell));
				break;
			case 10:
				double bankAccount;
				bankAccount = (double) getCellValue(nextCell);
				user.setBankAccount((int) bankAccount);
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			return user;
	
	}
}
