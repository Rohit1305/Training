<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passbook Details</title>
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
    
        <button type="button" name="back" onclick="history.back()" class="btn btn-dark">
            <i class="fa-sharp fa-solid fa-arrow-left"></i> Back
        </button>
    <form action="UserController" class="col-md-6 mx-auto">
        <h4>Update User</h4>
        <hr>
        <label for="user_name">Name : </label>
        <input type="text" class="form-control" name="user_name" value="${user.user_name}" required>

        <label for="email">Email : </label>
        <input type="text" class="form-control" name="email" value="${user.email}" id="email" onkeyup="validateEmail()" required>

        <label for="pass">Password :</label>
        <input type="text" class="form-control" name="pass" value="${user.pass}" id="pass" onkeyup="validatePassword()" required>

        <label for="mob">Mobile No :</label>
        <input type="text" class="form-control" name="mob" value="${user.mob}" id="mob" onkeyup="validateMobile()" required>

        <input type="hidden" name="command" value="update">
        <input type="hidden" name="acc_no" value="${user.acc_no}">

        <button type="submit" class="btn btn-outline-primary mt-3">Save Update</button>
    </form>
<!--     <div class="alert alert-danger mt-3">
        <small><em><strong>Note:</strong> Changing your email or password will redirect you to the login page. You must use your updated credentials for login.</em></small>
    </div> -->
</div>
</body>
<script src="script.js" ></script>
</html>