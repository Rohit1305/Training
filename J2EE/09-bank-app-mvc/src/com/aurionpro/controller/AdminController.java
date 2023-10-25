package com.aurionpro.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.aurionpro.jdb.UserDao;
import com.aurionpro.model.Passbook;
import com.aurionpro.model.User;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminController() {
		super();
	}

	@Resource(name = "jdbc/bankdb")
	private DataSource dataSource;
	UserDao userDao;

	@Override
	public void init() throws ServletException {
		super.init();
		userDao = new UserDao(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println(command);

		HttpSession session = request.getSession();
		Object admin = (Object) session.getAttribute("isAdmin");

		if (admin != null) {
			switch (command) {
			case "userDetail":
				listUsers(request, response);
				break;
			case "add":
				addUser(request, response);
				break;
			case "delete":
				deleteUser(request, response);
				break;
			case "search":
				searchUser(request, response);
				break;
			case "passbookAdmin":
				printPassbookAdmin(request, response);
				break;
			case "searchadminpassbook":
				searchAdmin(request, response);
				break;
			case "logout":
				RequestDispatcher dispature = request.getRequestDispatcher("login.jsp");
				dispature.forward(request, response);
			}
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> listUsers = userDao.listUsers();

		if (listUsers.isEmpty()) {
			request.setAttribute("userList", null);
		}
		System.out.println(listUsers);
		request.setAttribute("listUser", listUsers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-details.jsp");
		dispatcher.forward(request, response);
	}



	private void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int acc_no = Integer.parseInt(request.getParameter("acc_no"));
		String user_name = request.getParameter("user_name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String mob = request.getParameter("mob");
		int balance = Integer.parseInt(request.getParameter("balance"));

		User tempUser = new User(acc_no, user_name, email, pass, mob, balance);
		userDao.addUser(tempUser);
		listUsers(request, response);
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int acc_no = Integer.parseInt(request.getParameter("acc_no"));
		userDao.deleteUser(acc_no);
		listUsers(request, response);
	}
	
	private void searchUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int acc_no = Integer.parseInt(request.getParameter("search"));
		List<User> user = userDao.searchUser(acc_no);

		System.out.println(user.isEmpty());
		if (user.isEmpty()) {
			String msg1 = "User not found !!";
			request.setAttribute("msg1", msg1);
		} else {
			request.setAttribute("listUser", user);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-details.jsp");
		dispatcher.forward(request, response);
	}

	private void printPassbookAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Passbook> listPass = userDao.PassBook();
		System.out.println(listPass);
		request.setAttribute("listPassbook", listPass);
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin-passbook-details.jsp");
		dispatcher.forward(request, response);

	}

	private void searchAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int acc_no = Integer.parseInt(request.getParameter("searchadmin"));
		System.out.println(acc_no);
		List<Passbook> passbook = userDao.searchPassbookUser(acc_no);
		System.out.println(passbook);
		if (passbook.isEmpty()) {
			String msg2 = "Transaction not found !!";
			request.setAttribute("msg2", msg2);
		} else {
			request.setAttribute("listPassbook", passbook);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin-passbook-details.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}