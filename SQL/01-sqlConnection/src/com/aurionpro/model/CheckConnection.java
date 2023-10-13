package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckConnection {
	public static void main(String[] args) {
		String jdbc = "jdbc:mysql://localhost:3306/school";
		String username = "root";
		String password = "root@123";

		try {
			Connection conn = DriverManager.getConnection(jdbc, username, password);
			System.out.println("Connected to the database");
			conn.close();
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
	}
}
