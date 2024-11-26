package com.easypurse.ecommerce.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class DatabaseUtility {
	
	Connection conn;
	
	public void getConnection(String url, String username, String password) {
		try {
			Driver edriver = new Driver();
			DriverManager.registerDriver(edriver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			
		}
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ResultSet executeQuery(String Query) {
		ResultSet resultSet =null;
		try {
			Statement stat = conn.createStatement();
			resultSet = stat.executeQuery(Query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultSet;
	}
		

	public int executenonselectQuery(String Query) {
		int i=0;
		try {
			Statement stat = conn.createStatement();
			i = stat.executeUpdate(Query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}
	
	public void getConnection() {
		try {
			Driver edriver = new Driver();
			DriverManager.registerDriver(edriver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
	

}
