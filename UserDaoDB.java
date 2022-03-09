package com.revature.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.ArrayList;
import com.revature.beans.Employee;
import com.revature.beans.User;

/**
 * Implementation of UserDAO that reads/writes to a relational database
 */
public class UserDaoDB implements UserDao {
	
	public class BankCRUD {
		private static Connection conn;
		private static Statement stmt;
		private static PreparedStatement pstmt;
		private static ResultSet rs;
		
		public void getConnection() {
			try{
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revbank", "root", "root");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	public User addUser(User user) {
		// TODO Auto-generated method stub
		getConnection();
		String query = "insert into user (id,firstname,lastname,usertype,acctid) values (?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, firstname.getfirstName());
			pstmt.setString(3, lastname.getlastName());
			pstmt.setString(4, usertype.getUserType());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		return User;
	}

	public User getUser(Integer userId) {
		// TODO Auto-generated method stub
		getConnection();
		String query = "select * from buser where id="+id;
		buser = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				buser.setId(rs.getInt("id"));
				buser.setFirstName(rs.getString("firstname"));
				buser.setLastName(rs.getString("lastname"));
				buser.setUserName(rs.getString("username"))
				buser.setUserType(rs.getString("usertype"));
			}
	}catch(Exception e) {
	}
		return null;
	}

	public User getUser(String username, String pass) {
		// TODO Auto-generated method stub
		getConnection();
		buser=null;
		String query = "select * from buser where username="+username;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		    if(rs.next()) {
			  buser.setId(rs.getId("id"));
			  buser.setFirstName(rs.getString("firstname"));
			  buser.setLastName(rs.getString("lastname"));
			  buser.setUserName(rs.getString("username"));
			  buser.setUserType(rs.getString("usertype"));
		}catch(Exception e) {
		}	
		return null;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		getConnection();
		List<User>bankList = new ArrayList<User>();
		String query = "select * from buser";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				User buser = new User();
				String query = "insert into buser(id,firstname,lastname,username) values (?,?,?,?)";
			    pstmt = conn.prepareStatement(query);
				pstmt.setInt(1,e.getId());
				pstmt.setString(2,e.getFirstName());
				pstmt.setString(3,e.getLastName());
				pstmt.setString(4,e.getUserName());
				pstmt.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
			}
		return null;
	}

	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeUser(User u) {
		// TODO Auto-generated method stub
		getConnection();
		String query = "delete from user where id =" +id;
		return false;
	}
	
	public void closeResource() {
		try {
		if (rs!=null) 
			rs.close();  
		if(stmt!=null) 
			stmt.close();
		if(conn!=null) 
			conn.close();				
	}catch(Exception e) {
		e.printStackTrace();
	}
}
