package com.hexaware;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
 
	public int store(Employee emp) {
		int c=0;
		try {
			Connection con = DBUtility.establishConnection();
			System.out.println("Connected: "+con);
			String query = "{call Employee(?,?,?)}";
//			PreparedStatement pstmt = con.prepareStatement(query);
			CallableStatement pstmt = con.prepareCall(query);
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setDouble(3, emp.getSalary());
			c = pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return c;
		

	}
	public int delete (int id) {
		int c=0;
		try {
			Connection con = DBUtility.establishConnection();
			String query ="delete from employee where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			c = pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
		
	}
	public  Employee findById(int id) {
		Employee emp=null;
		try {
			Connection con = DBUtility.establishConnection();
			String query ="select * from employee where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				emp = new Employee(rs.getInt(1),rs.getString(2),null,rs.getDouble(3));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			
		}
		return emp;
		
	}
	public   int UpdateSalary(int id,double salary) {
		int c=0;
        try {
        	Connection con = DBUtility.establishConnection();
			String query ="update employee set salary=? where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, salary);
			pstmt.setInt(2, id);
			c = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			
		}
		return c;
	}
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			Connection con = DBUtility.establishConnection();
			String query = "select * from employee";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			Employee emp = new Employee(rs.getInt(1),rs.getString(2),null,rs.getDouble(3));
			employees.add(emp);
			}
			rs.close();
			pstmt.close();
			con.close();
			} catch (Exception e) {
		}
		return employees;
		
	}
}
