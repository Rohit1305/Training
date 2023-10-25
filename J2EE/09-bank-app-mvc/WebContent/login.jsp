<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banking APP</title>
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
    <div class="container mt-5">
        <h1 class="text-center text-black"></h1>
        <div class="container p-4">
            <form name="registration" action="LoginController" onsubmit="return formValidation();" method="post">
                <h2 class="text-left">Login</h2><br>
                <div class="mb-3">
                    <div class="form-check form-check-inline">
                        <input type="radio" id="admin" name="userType" value="ADMIN" class="form-check-input" required>
                        <label for="admin" class="form-check-label">Admin</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input type="radio" id="user" name="userType" value="USER" class="form-check-input" required>
                        <label for="user" class="form-check-label">User</label>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="text" class="form-control" name="email" id="email" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" class="form-control" name="password" id="password" required>
                </div>
                <div class="text-left">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
                <c:out value="${msg}" />
            </form>
        </div>
    </div>
</body>
</html>