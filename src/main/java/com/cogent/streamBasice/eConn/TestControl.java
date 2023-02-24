package com.cogent.streamBasice.eConn;

import jakarta.servlet.ServletException;

public class TestControl {

	public static void main(String[] args) throws ServletException {
		// TODO Auto-generated method stub
		DBConn conn = new DBConn();
		conn.dbConnect();
		conn.creatTable();
		
		conn.insert(101, "Dress101", 100f, 0.9f, true, 9);
		conn.insert(102, "Dress102", 100f, 0.6f, true, 3);
		conn.insert(103, "Dress103", 100f, 0.7f, true, 2);
		conn.insert(104, "Dress104", 70f, 0.34f, true, 5);
		conn.insert(105, "Coat101", 70f, 0.57f, true, 15);
		conn.insert(106, "Coat102", 70f, 0.98f, true, 7);
		conn.insert(107, "Coat103", 100f, 0.9f, true, 36);
		conn.insert(108, "Coat104", 100f, 0.9f, true, 9);
		conn.insert(109, "Skirt101", 200f, 0.32f, true, 25);
		conn.insert(110, "Skirt102", 200f, 0.36f, true, 10);
		conn.insert(111, "Skirt103", 200f, 0.74f, true, 11);
		conn.insert(112, "Skirt104", 100f, 0.62f, true, 9);
		
		conn.searchAll();

	}

}
