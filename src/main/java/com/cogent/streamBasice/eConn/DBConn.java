package com.cogent.streamBasice.eConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cogent.streamBasic.ReadMySQLData.Employee;

import jakarta.servlet.ServletException;

public class DBConn {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/batch65";
	static final String USER = "root";
	static final String PASS = "12345";
	Connection conn = null;
	ArrayList<Product> proList = new ArrayList<Product>();

	public void dbConnect() throws ServletException {
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}				
	}
	
	public void sortByDiscount() {
		System.out.println("");
		System.out.println("######sortByDiscount#######");
		List<Product> proBucket = proList.stream()
				.sorted(Comparator.comparing(Product::getDiscount))
				.map(pr -> pr).toList();
		System.out.println(proBucket);
		System.out.println("#############");			
	}
	
	public void sortBySold() {
		System.out.println("#######sortBySold######");
		List<Product> proBucket =  proList.stream()
				.sorted(Comparator.comparingInt(Product::getSold))
				.map(pr -> pr).toList();
		System.out.println(proBucket);
		System.out.println("#############");
		}

	public void sortByCost() {
		System.out.println("######sortByCost#######");
		List<Product> proBucket = proList.stream()
				.sorted(Comparator.comparing(Product::getCost))
				.map(pr -> pr).toList();
		System.out.println(proBucket);
		System.out.println("#############");		
	}
	
	public void changeDisplay() {
		System.out.println("######changeDisplay -0.1f#######");
//		// FindAny()
//		Optional<Product> proBucket = proList.stream()
//				.filter(productSold -> productSold.sold > 10)
//				.findAny(); // can not use Findany()!!!! it only returns 1 value
		
		List<Product> proBucket = proList.stream()
				.filter(productSold -> productSold.sold > 10)
				.map(pro -> new Product(
									pro.getId(), 
									pro.getName(), 
									pro.getCost(), 
									pro.getDiscount() - 0.1f, 
									pro.getAvailable(), 
									pro.getSold()))
				.collect(Collectors.toList());
		
		System.out.println(proBucket);
		System.out.println("#############");
		}
	
	public void searchAll() {
		try {
			Statement stmt = conn.createStatement();
			String QUERY = "SELECT * FROM eConn";
			ResultSet rs = stmt.executeQuery(QUERY);
			
//			ArrayList<Product> proList = new ArrayList<Product>();
//			int id, String name, float cost, float discount, boolean availabe, int sold
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				float cost = rs.getFloat("cost");	
				float discount = rs.getFloat("discount");	
				Boolean available = rs.getBoolean("available");	
				int sold = rs.getInt("sold");
				proList.add(new Product(id, name, cost, discount, available, sold));
				}	
			
			proList.stream().forEach(System.out::println);
			
			sortByDiscount();
			sortBySold();
			sortByCost();
			changeDisplay();
			
			rs.close();
			stmt.close();
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void creatTable() {
		try {
			Statement stmt = conn.createStatement();
			String QUERY1 = "USE batch65;";
			stmt.executeUpdate(QUERY1);
			
			String QUERY2 = "DROP TABLE IF EXISTS eConn;";
			stmt.executeUpdate(QUERY2);
			
			String QUERY3 = "CREATE TABLE eConn (id INTEGER, name VARCHAR(30), cost FLOAT, discount FLOAT, available BOOLEAN, sold INTEGER);";
			stmt.executeUpdate(QUERY3);
			System.out.println("DB Creation Success!");
//			stmt.close();
//			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}	
	
	public void insert(int id, String name, float cost, float discount, boolean available, int sold) {
		try {
			String QUERY = "INSERT INTO eConn VALUES(?, ?, ?, ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(QUERY);
	
	        pstmt.setInt(1, id);
	        pstmt.setString(2, name);
	        pstmt.setFloat(3, cost);
	        pstmt.setFloat(4, discount);
	        pstmt.setBoolean(5, available);
	        pstmt.setInt(6, sold);
	        
	        pstmt.executeUpdate();
//	        // Close all the connections
//	        pstmt.close();
//	        conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}	
	
}
