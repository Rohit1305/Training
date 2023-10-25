<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Database</title>
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
	<div class="container">
		<h1>Student DB</h1>
		<form action="StudentController" method="get" class="mb-3">
		<!-- <label for="search" >Search by:</label>  -->
			<input type="hidden" name="action" value="search" >
			<div class="input-group">
				
				<select class="form-select" name="searchBy">
					<option value="id">ID</option>
					<option value="firstname">First Name</option>
					<option value="lastname">Last Name</option>
					<option value="email">Email</option>
				</select> <input type="text" class="form-control"
					placeholder="Search by First Name" name="searchTerm" id ="search">
				<button type="submit" class="btn btn-primary">Search</button>
			</div>
		</form>
		<table class="table table-striped table-hover">

			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<c:forEach var="student" items="${allStud}">

				<c:url var="updateLink" value="StudentController">
					<c:param name="action" value="update" />
					<c:param name="id" value="${student.id}" />
				</c:url>
				<c:url var="deleteLink" value="StudentController">
					<c:param name="action" value="delete" />
					<c:param name="id" value="${student.id}" />
				</c:url>
				<tr>
					<td>${student.id}</td>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.email}</td>
					<td><a href="${updateLink}" class="btn btn-warning">Update</a>
						<a href="${deleteLink}" class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</table>

		<a href="add-student.jsp" class="btn btn-primary">Add Student</a>
	</div>


</body>

</html>