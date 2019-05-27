package com.atmecs.db;

import java.sql.Connection;
import java.sql.ResultSet;
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


	// Method to get a specific user as per id.
	public User getSpecificUser(int id) throws NullPointerException {
		ResultSet rs = null;
		String query = "select * from user1 where id=? ";
		con = connect.getConnection();
		User user = new User();
		try {
			
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setBankAccount(rs.getInt(5));
			}
			pstmt.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage()+"\n\n"); 
		} 
		return user;
	}

	// Method to insert the user in database
	public int addUser(User user) {
		con = connect.getConnection();
		String query = "insert into user1 values(?,?,?,?,?)";

		try {
			pstmt = (PreparedStatement) con.prepareStatement(query);
			System.out.println(user.getBankAccount());
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getLname());
			pstmt.setString(4, user.getPassword());
			pstmt.setInt(5, user.getBankAccount());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			return 0;
		} catch (Exception e) {
			System.out.println(e.getMessage()+"\n\n");
			return 1;
		}
	}
}
