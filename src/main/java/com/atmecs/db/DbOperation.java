package com.atmecs.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.atmecs.pojo.User;
import com.mysql.jdbc.PreparedStatement;

/*
 * This class provides the CRUD operations for database.
 */
public class DbOperation {
	DbConnection connect = new DbConnection();
	private Connection con = null;
	private PreparedStatement pstmt = null;
	Statement stmt = null;


	// Method to get a specific user as per id
	public User getSpecificUser(int id) {
		ResultSet rs = null;
		String query = "select * from user where id=? ";
		con = connect.getConnection();
		User user = new User();
		try {
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setBankAccount(rs.getInt(4));
				
			}
			pstmt.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return user;
	}

	// Method to insert the user in database
	public int addUser(User user) {
		con = connect.getConnection();
		String query = "insert into user values(?,?,?,?)";

		try {
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setDouble(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(4, user.getBankAccount());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			return 0;
		} catch (SQLException e) {
			System.out.println("User account already exist\n\n");
			return 1;
		}
	}
}
