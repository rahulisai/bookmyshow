package com.atmecs.db;

/*
 * Database Connection class 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//This method will create the jdbc connection and return its object.
public class DbConnection {
	Connection con = null;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyshow", "root", "");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return con;
	}

}
