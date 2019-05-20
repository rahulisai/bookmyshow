package com.atmecs.controller;

import org.apache.poi.ss.usermodel.Cell;

import com.atmecs.db.DbOperation;
import com.atmecs.pojo.User;

/*
 * ExcelOperation class will perform operation of saving each cell data into the object. 
 */
public class ExcelOperation {
	DbOperation db = new DbOperation();

	// This method return a value based on its type.
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

	/*
	 * This method will create & return an object by saving each cell data in
	 * particular getter setter method of pojo class.
	 */
	public User excelToObject(User user, int columnIndex, Cell nextCell) {

		try {
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
		} catch (ClassCastException e) {
			System.out.println();
		}
		return user;

	}
}
