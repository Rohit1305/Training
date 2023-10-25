package com.aurionpro.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.aurionpro.jdb.LoginDbUtil;
import com.aurionpro.model.Admin;

import com.aurionpro.model.User;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDbUtil loginDbUtil;

	public LoginController() {
		super();
	}
	@Resource(name = "jdbc/bankdb")
	private DataSource datasource;

	@Override
	public void init() throws ServletException {
		super.init();
		loginDbUtil = new LoginDbUtil(datasource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userType = request.getParameter("userType");

		if (userType == null) {
			userType = "LOGIN";
		}
		System.out.println(userType);

		switch (userType) {
		case "ADMIN":
			checkAdminCredentials(request, response);
			break;
		case "USER":
			checkUserCredentials(request, response);
			break;
		case "LOGIN":
			RequestDispatcher dispature = request.getRequestDispatcher("login.jsp");
			dispature.forward(request, response);
		}
	}

	private void checkUserCredentials(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		User user = new User(email, pass);
		User isUser = loginDbUtil.checkUserCredentials(user);
		System.out.println(isUser);

		if (isUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("isUser", isUser);

			request.setAttribute("balance", isUser.getBalance());
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-dashboard.jsp");
			dispatcher.forward(request, response);
		} else {
			String msg = "Invalid username or password";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void checkAdminCredentials(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		Admin admin = new Admin(email, pass);
		Admin isAdmin = loginDbUtil.checkAdminCredentials(admin);
		System.out.println(isAdmin);

		if (isAdmin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("isAdmin", isAdmin);

			RequestDispatcher dispatcher = request.getRequestDispatcher("admin-dashboard.jsp");
			dispatcher.forward(request, response);
		} else {
			String msg = "Invalid username or password.";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}