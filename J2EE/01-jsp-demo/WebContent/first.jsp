<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date,com.aurionpro.model.StringUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WEBPAGE</title>
</head>
<body>
	<h1>hello world!!!!</h1>
	<h2>Expression Tag</h2>
	<h3>
		todays date
		<%=new Date()%></h3>
	<h3>
		my name rohit to upper case
		<%=new String("rohit to upper case").toUpperCase()%></h3>

	<br>
	<h2>Scriptlet Tag</h2>
	<%
		for (int i = 0; i <= 10; i++) {
			out.println("i : " + i + "<br>");
		}
	%>
	<br>
	<h2>Declaration Tag</h2>
<%-- 	<%!String stringToLower(String str) {
		return str.toLowerCase();
	}%> --%>
	<h3>HELLO WORLD IN LOWER CASE   <%= StringUtil.stringToLower("HELLO WORLD IN lower casee")%></h3>
</body>
</html>