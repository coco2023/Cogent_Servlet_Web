package com.cogent.streamBasic.ReadMySQLData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import jakarta.servlet.ServletException;

public class DBConnector {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/batch65";
	static final String USER = "root";
	static final String PASS = "12345";
	Connection conn = null;

	public void dbConnect(int limit) throws ServletException {
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
			
		try {
			
		Statement stmt = conn.createStatement();
		String QUERY = "SELECT * FROM employee";
		
		ResultSet rs = stmt.executeQuery(QUERY);
		
		ArrayList<Employee> empList = new ArrayList<Employee>();
		
		while(rs.next()) {
			int id = rs.getInt("empId");
			String name = rs.getString("empName");
			float salary = rs.getFloat("salary");
				
			empList.add(new Employee(id, name, salary));
			}	
		empList.stream().limit(limit).forEach(System.out::println);
		rs.close();
		stmt.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}		

		try {
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
}
