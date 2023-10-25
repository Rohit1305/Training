<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<script src="validation.js"></script>
</head>
<body>
	<div class="container">
		<h1>Add Employee</h1>
		<form action="EmployeeController" method="get"
			onsubmit="return validateAddEmployeeForm()">
			<input type="hidden" name="action" value="add">
			<div class="form-group">
				<label for="name">Name:</label> <input type="text" id="name"
					name="name" class="form-control" required>
			</div>

			<div class="form-group">
				<label for="email">Email:</label> <input type="email" id="email"
					name="email" class="form-control" required>
			</div>

			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" class="form-control" required>
			</div>

			<div class="form-row">
				<div class="form-group col-md-2">
					<label for="dob">Date of Birth:</label> <input type="date" id="dob"
						name="dob" class="form-control" required
						max="<%=new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())%>">
				</div>

				<div class="form-group col-md-4">
					<label for="gender">Gender:</label>
					<div class="form-check">
						<input type="radio" id="male" name="gender" value="Male"
							class="form-check-input" required> <label for="male"
							class="form-check-label">Male</label>
					</div>
					<div class="form-check">
						<input type="radio" id="female" name="gender" value="Female"
							class="form-check-input" required> <label
							for "female" class="form-check-label">Female</label>
					</div>
					<div class="form-check">
						<input type="radio" id="other" name="gender" value="Other"
							class="form-check-input" required> <label for="other"
							class="form-check-label">Other</label>
					</div>
				</div>
			</div>


			<div class="form-group">
				<label for="designation">Designation:</label> <select
					id="designation" name="designation" class="form-control" required>
					<option value="Employee">Employee</option>
					<option value="Manager">Manager</option>
					<option value="Director">Director</option>
				</select>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>