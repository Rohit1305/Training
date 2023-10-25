<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PassBook INFO</title>
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
    <div class="text-center">
        <h1 class="mb-3">Passbook Info</h1>
    </div>
    <div class="d-flex justify-content-between mb-4">
        <button type="button" class="btn btn-primary" onclick="history.back()">Back</button>
        <form action="UserController" class="d-flex">
            <input type="hidden" name="acc_no" value="${isUser.acc_no}">
            <input type="hidden" name="command" value="filterByDate">
            <input type="date" name="fromDate" class="form-control" required>
            <input type="date" name="toDate" class="form-control" required>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
    </div>
    <hr>
    <table class="table table-striped table-hover">
        <thead class="table-light">
            <tr>
                <!-- <th class="text-center">Sr.No</th> -->
                <th class="text-center">Acc No</th>
                <th class="text-center">Transaction Date</th>
                <th class="text-center">Transaction Type</th>
                <th class="text-center">Transaction Amount</th>
                <th class="text-center">Account Balance</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="transactions" items="${transactions}">
                <tr class="text-center">
                   <%--  <td>${transactions.sr_no}</td> --%>
                    <td>${transactions.acc_no}</td>
                    <td>${transactions.trans_date}</td>
                    <td>${transactions.trans_type}</td>
                    <td>${transactions.amount}</td>
                    <td>${transactions.balance}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>