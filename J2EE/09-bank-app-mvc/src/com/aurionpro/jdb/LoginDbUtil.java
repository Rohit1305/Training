package com.aurionpro.jdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.aurionpro.model.Admin;
import com.aurionpro.model.User;

public class LoginDbUtil {
	private DataSource dataSource;
	public LoginDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public Admin checkAdminCredentials(Admin admin) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		Admin isAdmin = null;
		
//		System.out.println(admin);
		try {
			con = dataSource.getConnection();
			String sql = "select * from admin where email=? and pass=?;";
			stmt = con.prepareStatement(sql);

//			System.out.println(sql);
			stmt.setString(1, admin.getEmail());
			stmt.setString(2, admin.getPass());

			result = stmt.executeQuery();
//			System.out.println(result);

			if (result.next()) {
				int id = result.getInt("id");
				String admin_name = result.getString("admin_name");
				String email = result.getString("email");
				String pass = result.getString("pass");
				String mob = result.getString("mob");
				isAdmin = new Admin(id, admin_name, email, pass, mob);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, result);
		}
		return isAdmin;
	}

	public User checkUserCredentials(User user) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		User isUser = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "select * from user where email=? and pass=?;";
			stmt = con.prepareStatement(sql);

			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPass());

			result = stmt.executeQuery();
			if (result.next()) {
				String user_name = result.getString("user_name");
				String email = result.getString("email");
				String pass = result.getString("pass");
				int acc_no = result.getInt("acc_no");
				String mob = result.getString("mob");
				double balance = result.getDouble("balance");
				isUser = new User(acc_no, user_name, email, pass, mob, balance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, result);
		}
		return isUser;
	}

	private void close(Connection con, Statement stmt, ResultSet result) {

		try {
			if (con != null) {
				con.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (result != null) {
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}