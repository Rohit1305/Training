package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadSchool {
	public static void main(String[] args) {
		String jdbc = "jdbc:mysql://localhost:3306/school";
		String username = "root";
		String password = "root@123";
		ArrayList<Student> studentList = new ArrayList();

		try (Connection conn = DriverManager.getConnection(jdbc, username, password);
				PreparedStatement Statement = conn.prepareStatement("select * from student");
				ResultSet result = Statement.executeQuery()) {

			while (result.next()) {
				Student stu = new Student();

				stu.setId(result.getInt("id"));
				stu.setFirstName(result.getString("first_name"));
				stu.setLastName(result.getString("last_name"));
				stu.setEmail(result.getString("email"));
				stu.setPhoneNumber(result.getString("phone_number"));
				stu.setCity(result.getString("city"));
				stu.setDateOfBirth(result.getString("date_of_birth"));

				studentList.add(stu);

				// System.out.println("Student ID: " + id);
				// System.out.println("First Name: " + firstName);
				// System.out.println("Last Name: " + lastName);
				// System.out.println("Email: " + email);
				// System.out.println("Phone Number: " + phoneNumber);
				// System.out.println("City: " + city);
				// System.out.println("Date of Birth: " + dateOfBirth);
				// System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
		studentList.forEach((student)->{
			System.out.println(student);
		});
	}
}
