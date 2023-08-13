package com.smarteval.database;

import java.sql.*;  
/*
 * Program : DatabaseConnection class
 * Program By : Rahul Raha
 * Date : 17-07-2023
 */

public class DatabaseConnection {
	static Connection getConnection() {
		//setting up the driver for oracle
		Connection con = null;
		try {
			//setting up the driver for mysql
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			//setting up the driver for oracle
			Class.forName("oracle.jdbc.OracleDriver");
			
			//url for mysql
			//String url="jdbc:mysql://localhost:3306/industrialtraining";
			
			//url for oracle
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			//making string for database username and password
			String username="smarteval";
			String password="password";
			
			con = DriverManager.getConnection(url,username,password);
			return con;  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;	
	}
}