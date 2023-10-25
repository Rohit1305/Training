package com.aurionpro.jdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.aurionpro.model.Passbook;
import com.aurionpro.model.User;

public class UserDao {

	DataSource dataSource;

	public UserDao(DataSource dataSourse) {
		super();
		this.dataSource = dataSourse;
	}

	public List<User> listUsers() {

		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		List<User> users = new ArrayList<>();

		try {
			con = dataSource.getConnection();
			String sql = "select * from user;";
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);

			while (result.next()) {
				int acc_no = result.getInt("acc_no");
				String user_name = result.getString("user_name");
				String email = result.getString("email");
				String pass = result.getString("pass");
				String mob = result.getString("mob");
				double balance = result.getDouble("balance");

				users.add(new User(acc_no, user_name, email, pass, mob, balance));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, result);
		}
		return users;
	}

	public List<User> searchUser(int acc_no) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;

		List<User> user = new ArrayList<>();
		try {
			conn = dataSource.getConnection();
			String sql = "select * from user where acc_no like ? ;";
			String query = "%" + acc_no + "%";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, query);
			result = stmt.executeQuery();

			while (result.next()) {
				int acc_no1 = result.getInt("acc_no");
				String name = result.getString("user_name");
				String email = result.getString("email");
				String pass = result.getString("pass");
				String mob = result.getString("mob");
				int balance = result.getInt("balance");
				user.add(new User(acc_no1, name, email, pass, mob, balance));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, result);
		}
		return user;

	}

	public void addUser(User tempUser) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = dataSource.getConnection();
			String sql = "insert into user (acc_no,user_name,email,pass,mob,balance) values(?,?,?,?,?,?);";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, tempUser.getAcc_no());
			stmt.setString(2, tempUser.getUser_name());
			stmt.setString(3, tempUser.getEmail());
			stmt.setString(4, tempUser.getPass());
			stmt.setString(5, tempUser.getMob());
			stmt.setInt(6, (int) tempUser.getBalance());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		LocalDate transactionDate = LocalDate.now();
		String today = transactionDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		try {
			con = dataSource.getConnection();
			String sql = "insert into passbook (acc_no, trans_date, trans_type, amount, balance) values(?,?,?,?,?);";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, tempUser.getAcc_no());
			stmt.setString(2, today);
			stmt.setString(3, "deposit");
			stmt.setDouble(4, tempUser.getBalance());
			stmt.setDouble(5, tempUser.getBalance());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, null);
		}
	}

	public void deleteUser(int acc_no) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String sql = "delete from user where acc_no=?;";
			con = dataSource.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, acc_no);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con = dataSource.getConnection();
			String sql = "delete from passbook where acc_no=?;";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, acc_no);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, null);
		}
	}

	public List<Passbook> PassBook() {
		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		List<Passbook> userPassbook = new ArrayList<>();

		try {
			con = dataSource.getConnection();
			String sql = "select * from passbook ORDER BY sr_no desc;";
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			while (result.next()) {
				int sr_no = result.getInt("sr_no");
				int acc_no = result.getInt("acc_no");
				String trans_date = result.getString("trans_date");
				String trans_type = result.getString("trans_type");
				double amount = result.getInt("amount");
				double balance = result.getInt("balance");
				userPassbook.add(new Passbook(sr_no, acc_no, trans_date, trans_type, amount, balance));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, result);
		}
		return userPassbook;
	}

	public List<Passbook> searchPassbookUser(int acc_no) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Passbook> passbook = new ArrayList<>();
		try {
			conn = dataSource.getConnection();
			String sql = "select * from passbook where acc_no like ? order by sr_no desc ;";
			String query = "%" + acc_no + "%";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, query);
			result = stmt.executeQuery();

			while (result.next()) {
				int sr_no = result.getInt("sr_no");
				int acc_no1 = result.getInt("acc_no");
				String trans_date = result.getString("trans_date");
				String trans_type = result.getString("trans_type");
				double amount = result.getInt("amount");
				double balance = result.getInt("balance");
				passbook.add(new Passbook(sr_no, acc_no1, trans_date, trans_type, amount, balance));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, result);
		}
		return passbook;
	}

	public List<Passbook> getTransaction(int acc_no) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Passbook> transactions = new ArrayList<>();

		try {
			con = dataSource.getConnection();
			String sql = "select * from passbook where acc_no=? ORDER BY sr_no desc;";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, acc_no);
			result = stmt.executeQuery();

			while (result.next()) {
				int sr_no = result.getInt("sr_no");
				String trans_date = result.getString("trans_date");
				String trans_type = result.getString("trans_type");
				double amount = result.getInt("amount");
				double balance = result.getInt("balance");

				transactions.add(new Passbook(sr_no, acc_no, trans_date, trans_type, amount, balance));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, result);
		}
		return transactions;
	}

	public User getUserDetail(int acc_no) {
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet result = null;
		User user = null;

		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM user WHERE acc_no=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, acc_no);
			result = stmt.executeQuery();

			if (result.next()) {
				String name = result.getString("user_name");
				String email = result.getString("email");
				String pass = result.getString("pass");
				String mob = result.getString("mob");
				int balance = result.getInt("balance");
				user = new User(acc_no, name, email, pass, mob, balance);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<Passbook> filterTransactionByDate(int acc_no, String fromDate, String toDate) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		System.out.println(acc_no + " " + fromDate + " " + toDate);
		List<Passbook> transactions = new ArrayList<>();
		try {
			conn = dataSource.getConnection();
			String sql = "select * from passbook where trans_date between ? and ? and acc_no=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, fromDate);
			stmt.setString(2, toDate);
			stmt.setInt(3, acc_no);
			result = stmt.executeQuery();

			while (result.next()) {
				int sr_no = result.getInt("sr_no");
				String trans_date = result.getString("trans_date");
				String trans_type = result.getString("trans_type");
				double amount = result.getInt("amount");
				double balance = result.getInt("balance");
				transactions.add(new Passbook(sr_no, acc_no, trans_date, trans_type, amount, balance));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, result);
		}
		return transactions;
	}

	public User updateUserInformation(User user) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		User isuser = null;
		try {
			con = dataSource.getConnection();
			String sql = "update user set user_name=?,email=?,mob=?,pass=? where acc_no=?;";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getUser_name());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getMob());
			stmt.setString(4, user.getPass());
			stmt.setInt(5, user.getAcc_no());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM user WHERE acc_no=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, user.getAcc_no());
			result = stmt.executeQuery();

			if (result.next()) {
				String name = result.getString("user_name");
				String email = result.getString("email");
				String pass = result.getString("pass");
				String mob = result.getString("mob");
				int balance = result.getInt("balance");
				isuser = new User(user.getAcc_no(), name, email, pass, mob, balance);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(con, stmt, null);
		}
		return isuser;
	}

	public void depositAmount(Passbook passbook) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "update user set balance=? where acc_no=?;";
			stmt = con.prepareStatement(sql);
			stmt.setDouble(1, passbook.getBalance());
			stmt.setInt(2, passbook.getAcc_no());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con = dataSource.getConnection();
			String sql = "insert into passbook (acc_no,trans_date, trans_type, amount, balance) values(?,?,?,?,?);";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, passbook.getAcc_no());
			stmt.setString(2, passbook.getTrans_date());
			stmt.setString(3, passbook.getTrans_type());
			stmt.setDouble(4, passbook.getAmount());
			stmt.setDouble(5, passbook.getBalance());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			close(con, stmt, null);
		}

	}

	public void withdrawAmount(Passbook passbook) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "update user set balance=? where acc_no=?;";
			stmt = con.prepareStatement(sql);
			stmt.setDouble(1, passbook.getBalance());
			stmt.setInt(2, passbook.getAcc_no());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con = dataSource.getConnection();
			String sql = "insert into passbook (acc_no,trans_date, trans_type, amount, balance) values(?,?,?,?,?);";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, passbook.getAcc_no());
			stmt.setString(2, passbook.getTrans_date());
			stmt.setString(3, passbook.getTrans_type());
			stmt.setDouble(4, passbook.getAmount());
			stmt.setDouble(5, passbook.getBalance());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			close(con, stmt, null);
		}

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