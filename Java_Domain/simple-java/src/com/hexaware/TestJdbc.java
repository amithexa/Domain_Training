package com.hexaware;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestJdbc {

	public static void main(String[] args) {
		try {
			/*Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/domaindb", "root", "Password123");*/
			Connection con = DBUtility.establishConnection();
			//System.out.println("Connected: "+con);
			String query = "{call Employee(?,?,?)}";
//			PreparedStatement pstmt = con.prepareStatement(query);
			CallableStatement pstmt = con.prepareCall(query);
			pstmt.setInt(1, 500);
			pstmt.setString(2, "Allen");
			pstmt.setDouble(3, 500000);
			int c = pstmt.executeUpdate();
			System.out.println("Row affected: "+c);
			
			pstmt.close();
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
