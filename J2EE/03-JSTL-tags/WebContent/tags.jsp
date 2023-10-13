<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page
	import="java.util.ArrayList,java.util.List,com.aurionpro.model.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="curDate" value="<%=new java.util.Date()%>" />
	current Date = ${curDate}
	<br>
	<%
		String names[] = { "rohit", "virat", "sachin" };
		pageContext.setAttribute("students", names);
	%>
	<c:forEach var="name" items="${students}"> ${name} </c:forEach>


	<%
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Rohit", "rohit@gmail.com", 80));
		students.add(new Student(2, "Virat", "virat@gmail.com", 90));
		students.add(new Student(3, "Sachin", "sachin@gmail.com", 100));
		
		pageContext.setAttribute("listOfStudent", students);
	%>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>percentage</th>
				<th>remark</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="student" items="${listOfStudent}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.email}</td>
					<td>${student.percentage}</td>
					<td>
					<c:if test="${student.percentage > 85}"> distinction </c:if>
					<c:if test="${student.percentage < 85}"> pass</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
<br>
<c:set var="number" value="5" />
<c:choose>
<c:when test="${number > 0}">
The number is positive.
</c:when>
<c:when test="${number < 0}">
The number is negative.
</c:when>
<c:otherwise>
The number is zero.
</c:otherwise>
</c:choose>
<br>
<br>


<c:set var="text" value="Hey, I am Rohit " />

Length of string- ${fn:length(text)}<br>
Lowercase- ${fn:toLowerCase(text)}<br>
Uppercase- ${fn:toUpperCase(text)}<br>
Trimmed- ${fn:trim(text)}<br>
Substring- ${fn:substring(text,10,15)}<br>




	
</body>
</html>