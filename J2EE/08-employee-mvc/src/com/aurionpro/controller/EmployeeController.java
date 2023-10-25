package com.aurionpro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.aurionpro.jdbc.EmployeeDbUtil;
import com.aurionpro.model.Employee;
import com.aurionpro.model.Gender;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	@Resource(name = "jdbc/employee-source")
	private DataSource datasource;

	private EmployeeDbUtil dbutil;
	private static final long serialVersionUID = 1L;

	public EmployeeController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		dbutil = new EmployeeDbUtil(datasource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			action = "list";
		}

		switch (action) {
		case "list":
			try {
				listEmployee(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "add":
			try {
				addEmployee(request, response);
			} catch (ParseException | SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case "delete":
			try {
				deleteEmployee(request, response);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case "update":
			try {
				getEmployeeforUpdate(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "update-save":
			try {
				updateEmployee(request, response);
			} catch (SQLException | ParseException e1) {
				e1.printStackTrace();
			}
			break;
		case "search":
			try {
				searchEmployee(request, response);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		default:
			try {
				listEmployee(request, response);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	private void searchEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String searchBy = request.getParameter("searchBy");
		String searchTerm = request.getParameter("searchTerm");
		List<Employee> searchedEmployees = dbutil.searchEmployees(searchBy, searchTerm);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employees.jsp");
		request.setAttribute("allEmp", searchedEmployees);
		dispatcher.forward(request, response);
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, SQLException, IOException, ServletException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String dobStr = request.getParameter("dob");
		String genderStr = request.getParameter("gender");
		String designation = request.getParameter("designation");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dob = dateFormat.parse(dobStr);
		Gender gender = Gender.valueOf(genderStr);

		Employee newEmployee = new Employee(id, name, email, password, dob, gender, designation);
		dbutil.updateEmployee(newEmployee);
		response.sendRedirect(request.getContextPath() + "/EmployeeController");

	}

	private void getEmployeeforUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee employee = dbutil.getEmployeeById(id);
		request.setAttribute("employee", employee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-employee.jsp");
		dispatcher.forward(request, response);

	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		int newid = Integer.parseInt(request.getParameter("id"));
		dbutil.deleteEmployee(newid);
		listEmployee(request, response);
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, SQLException, IOException, ServletException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String dobStr = request.getParameter("dob");
		String genderStr = request.getParameter("gender");
		String designation = request.getParameter("designation");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dob = dateFormat.parse(dobStr);
		Gender gender = Gender.valueOf(genderStr);

		Employee employee = new Employee(name, email, password, dob, gender, designation);
		dbutil.addEmployee(employee);
		response.sendRedirect(request.getContextPath() + "/EmployeeController");

	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Employee> employeeList = dbutil.getAllEmployees();
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-employees.jsp");
		request.setAttribute("allEmp", employeeList);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
