<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Name:
	<%=request.getParameter("username")%><br> Email:
	<%=request.getParameter("useremail")%><br> Graduation Degree:
	<%=request.getParameter("userdegree")%><br> Gender:
	<%=request.getParameter("usergender")%><br> Favorite Subjects:
	<br>
	<%
		String[] FavouriteSubject = request.getParameterValues("favoritesubjects");
		if (FavouriteSubject != null) {
			for (int i = 0; i < FavouriteSubject.length; i++) {
				out.println(FavouriteSubject[i]);
			}
		}
	%>

</body>
</html>