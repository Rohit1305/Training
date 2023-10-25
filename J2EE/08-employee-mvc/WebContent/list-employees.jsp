<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<!-- <script src="validation.js"></script> -->
<body>
	<div class="container">
		<h1>Employee DB</h1>
		<form action="EmployeeController" method="get" class="mb-3" onsubmit="return validateSearchEmployeeForm()">
		<!-- <label for="search" >Search by:</label>  -->
			<input type="hidden" name="action" value="search" >
			<div class="input-group">
				
				<select class="form-select" name="searchBy">
					<option value="id">ID</option>
					<option value="name">Name</option>
					<option value="email">Email</option>
					<option value="dob">DOB</option>
					<option value="gender">Gender</option>
					<option value="designation">Designation</option>
				</select> <input type="text" class="form-control"
					placeholder="Search Here" name="searchTerm" id ="search">
				<button type="submit" class="btn btn-primary">Search</button>
			</div>
		</form>
		<table class="table table-hover">

			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>DOB</th>
				<th>Gender</th>
				<th>Designation</th>
				<th>Action</th>
			</tr>
			<c:forEach var="employee" items="${allEmp}">
				<c:url var="updateLink" value="EmployeeController">
					<c:param name="action" value="update" />
					<c:param name="id" value="${employee.id}" />
				</c:url>
				<c:url var="deleteLink" value="EmployeeController">
					<c:param name="action" value="delete" />
					<c:param name="id" value="${employee.id}" />
				</c:url>
				<tr>
					<td>${employee.id}</td>
					<td>${employee.name}</td>
					<td>${employee.email}</td>
					<td>${employee.dob}</td>
					<td>${employee.gender}</td>
					<td>${employee.designation}</td>
					<td><a href="${updateLink}" class="btn btn-warning">Update</a>
						<a href="${deleteLink}" class="btn btn-danger">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<a href="add-employee.jsp" class="btn btn-primary">Add Employee</a>

	</div>

</body>
</html>