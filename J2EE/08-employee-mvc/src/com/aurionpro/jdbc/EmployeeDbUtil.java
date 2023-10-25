package com.aurionpro.jdbc;

import javax.sql.DataSource;

import com.aurionpro.model.Employee;
import com.aurionpro.model.Gender;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDbUtil {
	private DataSource dataSource;

	public EmployeeDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Employee> getAllEmployees() throws SQLException {
		List<Employee> employees = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from employee";
			stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String email = result.getString("email");
				String password = result.getString("password");
				Date dob = result.getDate("dob");
				String genderStr = result.getString("gender");
				Gender gender = Gender.valueOf(genderStr);
				String designation = result.getString("designation");

				Employee tempEmployee = new Employee(id, name, email, password, dob, gender, designation);
				employees.add(tempEmployee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, result);
		}
		return employees;
	}

	private void close(Connection conn, Statement stmt, ResultSet result) throws SQLException {
		if (conn != null) {
			conn.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (result != null) {
			result.close();
		}
	}

	public void addEmployee(Employee employee) throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = dataSource.getConnection();

			String sql = "insert into employee (name, email, password, dob, gender, designation) values (?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getEmail());
			stmt.setString(3, employee.getPassword());
			stmt.setDate(4, new java.sql.Date(employee.getDob().getTime()));
			stmt.setString(5, employee.getGender().name());
			stmt.setString(6, employee.getDesignation());

			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}
	}

	public void deleteEmployee(int id) throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "delete from employee where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}
	}

	public void updateEmployee(Employee employee) throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "update employee set name=?, email=?, password=?, dob=?, gender=?, designation=? where id=?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getEmail());
			stmt.setString(3, employee.getPassword());
			stmt.setDate(4, new java.sql.Date(employee.getDob().getTime()));
			stmt.setString(5, employee.getGender().name());
			stmt.setString(6, employee.getDesignation());
			stmt.setInt(7, employee.getId());

			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}
	}

	public Employee getEmployeeById(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		Employee tempEmployee = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from employee where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			if (result.next()) {

				String name = result.getString("name");
				String email = result.getString("email");
				String password = result.getString("password");
				Date dob = result.getDate("dob");
				String genderStr = result.getString("gender");
				Gender gender = Gender.valueOf(genderStr);
				String designation = result.getString("designation");

				tempEmployee = new Employee(id, name, email, password, dob, gender, designation);

			}
			return tempEmployee;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, result);
		}
		return null;

	}

	public List<Employee> searchEmployees(String searchBy, String searchTerm) throws SQLException {
		List<Employee> employees = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			conn = dataSource.getConnection();
			String sql = "select * from employee where name like ?";
			switch (searchBy) {
			case "id":
				sql = "select * from employee where id like ?";
				break;
			case "name":
				sql = "select * from employee where name like ?";
				break;
			case "email":
				sql = "select * from employee where email like ?";
				break;
			case "dob":
				sql = "select * from employee where dob like ?";
				break;
			case "gender":
				sql = "select * from employee where gender like ?";
				break;
			case "designation":
				sql = "select * from employee where designation like ?";
				break;
			}
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + searchTerm + "%");
			result = stmt.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String email = result.getString("email");
				String password = result.getString("password");
				Date dob = result.getDate("dob");
				String genderStr = result.getString("gender");
				Gender gender = Gender.valueOf(genderStr);
				String designation = result.getString("designation");

				Employee tempEmployee = new Employee(id, name, email, password, dob, gender, designation);
				employees.add(tempEmployee);
			}
			return employees;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}
		return employees;
	}
}
