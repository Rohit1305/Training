<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction </title>
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
	<br><br>
	<div class="container p-3 my-3 border bg-light text-dark">
		<div class="text-right">
			<a href="LogoutController" class="btn btn-danger">Logout</a>
		</div>
		<center>
			<h1>Transaction</h1>
		</center>
		<hr>
		<button type="button" name="back" onclick="history.back()" class="btn btn-dark">
			<i class="fa-sharp fa-solid fa-arrow-left"></i>Back
		</button>
		<form action="UserController">
			<input type="hidden" value="${balance}" name="balance">
			<center>
<%-- 				<h6>
					Current Balance:&nbsp
					<c:out value="${balance}"></c:out>
				</h6> --%>
				<c:if test="${minimum==1000}">
					<c:out value="${msg4}" />
				</c:if>
				<br> Transaction Type : <select name="command" class="form-select">
					<option>Deposit</option>
					<option>Withdraw</option>
				</select><br> <br>
				<input type="hidden" name="acc_no" value="${acc_no}">
				<input type="text" name="amount" class="form-control" placeholder="Enter Amount"
					required><br> <br>
				<input class="btn btn-primary" type="submit" value="Submit">
			</center>
		</form>
		<hr>
	</div>
	<br>
</body>
</html>