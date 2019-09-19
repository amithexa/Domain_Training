package com.hexaware;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestSelect {

	public static void main(String[] args) {
		try {
			Connection con = DBUtility.establishConnection();
			String query = "select * from employee";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee(rs.getInt(1), rs.getString(2), null, rs.getDouble(3));
				System.out.println(emp);
				
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

}
