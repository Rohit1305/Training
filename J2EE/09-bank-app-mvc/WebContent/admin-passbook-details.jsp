<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Passbook Page</title>
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
			<h1>Transaction Details</h1>
		</center>
		<button type="button" name="back" onclick="history.back()"
			class="btn btn-dark"><br>
			<i class="fa-sharp fa-solid fa-arrow-left"></i>Back
		</button>
		<br><br>

		<form action="AdminController">
			<input type="hidden" name="command" value="searchadminpassbook">
			<input type="text" placeholder="Enter acc_no" name="searchadmin"
				required> <span><input type="submit" value="Search"
				class="btn btn-primary"></span>
			<c:out value="${msg2}"></c:out>
		</form>
		<hr>
		<table
			class="table table-striped table-hover table-light table-borderless">
			<tr class="text-center">
				<th>ID</th>
				<th>Acc No</th>
				<th>Transaction Date</th>
				<th>Transaction Type</th>
				<th>Amount</th>
				<th>Balance</th>
			</tr>
			<c:forEach var="transactions" items="${listPassbook}">
				<tr class="text-center">
					<td>${transactions.sr_no}</td>
					<td>${transactions.acc_no}</td>
					<td>${transactions.trans_date}</td>
					<td>${transactions.trans_type}</td>
					<td>${transactions.amount}</td>
					<td>${transactions.balance}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>