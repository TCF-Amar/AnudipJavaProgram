package com.advancejava;
import java.sql.*;


public class DatabseDemo {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/test";
		  String user = "root"; 
	        String password = ""; 

	       try {
			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.println("Databse Connected");
			conn.close();
		} catch (SQLException e) {
			 System.out.println("❌ Connection Failed!");
//	            e.printStackTrace();
		}
	}

}
