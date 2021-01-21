package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ERSDBConnection {
	private String URL = "jdbc:mariadb://database-1.cjjlktgocanw.us-east-2.rds.amazonaws.com:3306/ERSdb";
	private String username = "ERSuser";
	private String password = "mypassword";

	public Connection getDBConnection() throws SQLException{
		return DriverManager.getConnection(URL,username,password);
	}
}
