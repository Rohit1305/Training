package com.aurionpro.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello World");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("username");
//		System.out.println(userName);
		out.println("<h1>User Name: " + userName +"</h1>"+"<br>");
		
		String userEmail = request.getParameter("useremail");
//		System.out.println(userEmail);
		out.println("<h2>User Email:" + userEmail+"</h1>"+"<br>");
		
		String userDegree = request.getParameter("userdegree");
//		System.out.println(userDegree);
		out.println("User Degree: " + userDegree+"<br>");
		
		String userGender = request.getParameter("usergender");
//		System.out.println(userGender);
		out.println("User Gender: " + userGender+"<br>");
		
		String[] FavouriteSubject = request.getParameterValues("favoritesubjects");
		if (FavouriteSubject != null) {
			out.println("Favoutite Subject: ");
			for (int i = 0; i < FavouriteSubject.length; i++) {
				out.println(FavouriteSubject[i]);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
