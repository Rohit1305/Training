<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
Integer counter = (Integer) application.getAttribute("counter");
if(counter==null){
	application.setAttribute("counter", 0);
	counter=0;
}else{
	counter++;
	application.setAttribute("counter", counter);
}
%>
<p>Counter Value for application: <%= counter %></p>
</body>
</html>