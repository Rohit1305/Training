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
	
	<form action="AdminController" name="myform" method="post"
		onsubmit="return validateform()">
		<div class="container p-3 my-3 border bg-light text-dark">
		<button type="button" name="back" onclick="history.back()"
				class="btn btn-dark">
				<i class="fas fa-arrow-left"></i> Back
			</button>
			<center>
				<h1 class="text-Secondary">Add New User</h1>
			</center>
			<hr>

			<label for="acc_no">Account Number : </label>
			<input type="number" name="acc_no" class="form-control" id="acc_no" required><br>
			<label for="name">Name : </label>
			<input type="text" name="user_name" class="form-control" id="user_name" required><br>
			<label for="email">Email : </label>
			<input type="text" name="email" class="form-control" id="email" onkeyup="validateEmail()" required><br>
			<label for="password">Password : </label>
			<input type="password" name="pass" class="form-control" id="pass" onkeyup="validatePassword()" required><br>
			<label for="mobile">Mobile Number : </label>
			<input type="text" name="mob" class="form-control" id="mob" onkeyup="validateMobile()" required><br>
			<label for="balance">Balance : </label>
			<input type="number" name="balance" class="form-control" id="balance" onkeyup="validateBalance()" required><br>

			<div class="text-left">
				<input type="hidden" name="command" value="add">
				<input type="submit" class="btn btn-primary" value="Submit">
			</div>
			<br>

		</div>
	</form>
	<br>
</body>


<script src="script.js"></script>
</html>
