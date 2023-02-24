package com.cogent.streamBasic.ReadMySQLData;

import jakarta.servlet.ServletException;

public class Tester {

	public static void main(String[] args) throws ServletException {
		// TODO Auto-generated method stub
		DBConnector dbconn = new DBConnector();
		
		int limit = 4;
		dbconn.dbConnect(limit);
	}

}
