<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banking Application</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container p-3 my-3 border bg-light text-dark">
		<div class="text-right">
			<a href="LogoutController" class="btn btn-danger">Logout</a>
		</div>
		<center>
			<h1>User Details</h1>
		</center>
		<button type="button" name="back" onclick="history.back()"
			class="btn btn-dark">
			<a type="button" href="admin-dashboard.jsp" class="text-light"> <i
				class="fas fa-arrow-left"></i> Back
			</a>
		</button>

		<br> <br>
		<form action="AdminController">
			<input type="hidden" name="command" value="search"> <input
				type="text" placeholder="Enter Acc_No " name="search" required>
			<span><input type="submit" value="Search"
				class="btn btn-primary"></span> <br>
			<c:out value="${msg1}"></c:out>
		</form>
		<br>
		<table
			class="table table-striped table-hover table-light table-borderless">
			<tr>
				<th>Account No</th>
				<th>User Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Mobile Number</th>
				<th>Balance</th>
				<th>Delete</th>
			</tr>

			<c:forEach var="user" items="${listUser}">
				<c:url var="deleteLink" value="AdminController">
					<c:param name="command" value="delete"></c:param>
					<c:param name="acc_no" value="${user.acc_no}"></c:param>
				</c:url>
				<tr>
					<td>${user.acc_no}</td>
					<td>${user.user_name}</td>
					<td>${user.email}</td>
					<td>${user.pass}</td>
					<td>${user.mob}</td>
					<td>${user.balance}</td>
					<td><a href="${deleteLink}">
							<button type="button" class="btn btn-danger">Delete</button>
					</a></td>
				</tr>
			</c:forEach>
		</table>
		<input type="button" value="Add User" class="btn btn-primary"
			onclick="window.location.href='add-user-form.jsp';">

	</div>
</body>
</html>
