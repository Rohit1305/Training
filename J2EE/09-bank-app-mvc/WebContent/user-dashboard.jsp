<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User DashBoard</title>
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
    <div class="container p-5 my-3 border bg-light text-dark">
        <div class="text-right">
            <a href="LogoutController" class="btn btn-danger">Logout</a>
        </div>
        <center>
            <h1 class="display-3">Welcome, User!</h1>
        </center>
        <br>
        <div class="row">
            <div class="col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <h2 class="card-title">User Information</h2>
                        <p><b>Account Number:</b> ${isUser.acc_no}</p>
                        <p><b>Name:</b> ${isUser.user_name}</p>
                        <p><b>Email:</b> ${isUser.email}</p>
                        <p><b>Mobile Number:</b> ${isUser.mob}</p>
                        <p><b>Balance:</b> ${balance}</p>
                    </div>
                </div>
            </div>

            <c:set var="acc_no" value="${acc_no}" />
            <c:url var="printPassbookLink" value="UserController">
                <c:param name="command" value="passbook"></c:param>
                <c:param name="acc_no" value="${isUser.acc_no}"></c:param>
            </c:url>

            <c:url var="userTransactionLink" value="UserController">
                <c:param name="command" value="accInfo"></c:param>
                <c:param name="acc_no" value="${isUser.acc_no}"></c:param>
                <c:param name="balance" value="${balance}"></c:param>
            </c:url>

            <c:url var="loadUserLink" value="UserController">
                <c:param name="command" value="load"></c:param>
                <c:param name="acc_no" value="${isUser.acc_no}"></c:param>
            </c:url>

            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h2 class="card-title">Actions</h2>
                        <a href="${userTransactionLink}">
                            <button type="button" class="btn btn-primary btn-lg btn-block mb-3" name="command" value="transaction">Transaction </button>
                        </a>
                        <a href="${printPassbookLink}">
                            <button type="button" class="btn btn-success btn-lg btn-block mb-3" name="command" value="passbook">Passbook</button>
                        </a>
                        <a href="${loadUserLink}">
                            <button type="button" class="btn btn-success btn-lg btn-block mb-3">Update Details</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>