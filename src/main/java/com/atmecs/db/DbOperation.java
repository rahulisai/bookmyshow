package com.atmecs.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.atmecs.bookmyshow.User;
import com.mysql.jdbc.PreparedStatement;

/*
 * This class provides the CRUD operations for database.
 */
public class DbOperation {
	DbConnection connect = new DbConnection();
	List<User> list = new ArrayList<User>();
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	Statement stmt = null;

	// Method to retrieve all the employees
	public List<User> getEmployees() {
		String query = "select * from employee";
		con = connect.getConnection();

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setBankAccount(rs.getInt(4));
				list.add(user);
			}

			rs.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Method to get a specific employee as per id
	public User getSpecificUser(int id) {
		String query = "select * from user where id=? ";
		con = connect.getConnection();
		User user = new User();
		try {
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				user.setId(rs.getInt(1));
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

	// Method to insert the employee in database
	public void addUser(User user) {
		con = connect.getConnection();
		String query = "insert into user values(?,?,?,?)";

		try {
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setDouble(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(4, user.getBankAccount());
			pstmt.executeUpdate();
			System.out.println("Data inserted successfully");
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
	/*
	 * //Method to update the details of the employee public void
	 * updateEmployee(User user) { con = connect.getConnection(); String query =
	 * "update employee set name=?,age=?,city=? where id=?";
	 * 
	 * try { pstmt = (PreparedStatement) con.prepareStatement(query);
	 * pstmt.setString(1, user.getName()); pstmt.setInt(2, user.getAge());
	 * pstmt.setString(3, user.getCity()); pstmt.setInt(4, user.getId());
	 * pstmt.executeUpdate();
	 * 
	 * System.out.println("Data updated successfully"); pstmt.close(); con.close();
	 * } catch (SQLException e) { System.out.println(e); }
	 * 
	 * }
	 * 
	 * //Method to delete the details of the employee public void
	 * deleteEmployee(User user) { con = connect.getConnection(); String query =
	 * "delete from employee where id=?"; try { pstmt = (PreparedStatement)
	 * con.prepareStatement(query); pstmt.setInt(1, user.getId());
	 * pstmt.executeUpdate(); System.out.println("Data deleted successfully");
	 * pstmt.close(); con.close(); } catch (SQLException e) { System.out.println(e);
	 * }
	 * 
	 * }
	 */
}