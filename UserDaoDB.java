package com.revature.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.revature.beans.Users;

/**
 * Implementation of UserDAO that reads/writes to a relational database
 */
public class UserDaoDB implements UserDao {
	
		private static Connection conn;
		private static Statement stmt;
		private static PreparedStatement pstmt;
		private static ResultSet rs;
		
		public void getConnection() {
			try{
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revbank", "root", "Meroe#@nehisi");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	public Users addUser(Users user) {
		// TODO Auto-generated method stub
		getConnection();
		String query = "INSERT INTO revbank.buser (idnum,Fname,Lname,Uname,Pword,Usertype) values (?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getFirstName());
			pstmt.setString(3, user.getLastName());
			pstmt.setString(4, user.getUsername());
			pstmt.setString(5, user.getPassword());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public Users getUser(Integer idnum) {
		// TODO Auto-generated method stub
		getConnection();
		String query = "select * from buser where id="+idnum;
		Users buser = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				buser.getId(rs.getInt(idnum));
				buser.getFirstName(rs.getString("Fname"));
				buser.getLastName(rs.getString("Lname"));
				buser.getUserName(rs.getString("Uname"));
				buser.getPassword(rs.getString("Pword"));
				buser.getUserType(rs.getString("Usertype"));
				buser.getId(rs.getInt("Acctid"));
			}
	}catch(Exception e) {
		e.printStackTrace();
	}
		return buser;
	}
	
	public Users getUser(String Uname, String Pword) {
		// TODO Auto-generated method stub
		getConnection();
		Users buser=null;
		String query = "select * from buser where username="+Uname;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		    if(rs.next()) {
			  buser.getId(rs.getId("idnum"));
			  buser.getFirstName(rs.getString("Fname"));
			  buser.getLastName(rs.getString("Lname"));
			  buser.getUserName(rs.getString("Uname"));
			  buser.getPassword(rs.getString("Pword"));
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return buser;
}

	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		getConnection();
		List<Users>bankList = new ArrayList<Users>();
		String query = "select * from buser";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				Users buser = new Users();
				String query = "insert into buser(idnum,Fname,Lname,Uname,Pword) values (?,?,?,?,?)";
			    pstmt = conn.prepareStatement(query);
				pstmt.setInt(1,e.getId(idnum));
				pstmt.setString(2,e.getFirstName(Fname));
				pstmt.setString(3,e.getLastName(Lname));
				pstmt.setString(4,e.getUserName(Uname));
				pstmt.setString(5,e.getPassword(Pword));
				pstmt.executeUpdate();
				}
		}catch(SQLException e) {
					e.printStackTrace();
		
			}
		return null;
	}

	public Users updateUser(Users u) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeUser(Users u) {
		// TODO Auto-generated method stub
		getConnection();
		String query = "delete from user where id =" u.getId();
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
}