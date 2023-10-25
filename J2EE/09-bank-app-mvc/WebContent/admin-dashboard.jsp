<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin Dashboard</title>
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

    <div class="container p-5 my-3 border bg-light text-dark">
        <div class="text-right">
            <a href="LogoutController" class="btn btn-danger">Logout</a>
        </div>
        <center>
            <h1 class="display-3">Welcome, Admin!</h1>
        </center>
        <br>
        <div class="row">
            <div class="col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <h2 class="card-title">Admin Information</h2>
                        <p><b>ID:</b> ${isAdmin.id}</p>
                        <p><b>Name:</b> ${isAdmin.admin_name}</p>
                        <p><b>Email:</b> ${isAdmin.email}</p>
                        <p><b>Mobile:</b> ${isAdmin.mob}</p>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h2 class="card-title">Actions</h2>
                        <form action="AdminController">
                            <button type="submit" class="btn btn-primary btn-lg btn-block mb-3" name="command" value="userDetail">User Information</button>
                            <button type="submit" class="btn btn-success btn-lg btn-block mb-3" name="command" value="passbookAdmin">Transaction Details</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
