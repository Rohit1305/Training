<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<ul>
<%
String item = request.getParameter("todosItem");
List<String> itemlist = (List<String>) session.getAttribute("TodosList");
if (itemlist == null) {
	itemlist = new ArrayList<>();
}
if(item != null && item.trim().length()>0){
	itemlist.add(item);
	session.setAttribute("TodosList", itemlist);
}
%>
</ul>
</body>
</html>