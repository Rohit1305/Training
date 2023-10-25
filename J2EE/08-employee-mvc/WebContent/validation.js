function validateAddEmployeeForm() {
	var name = document.getElementById("name").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var dob = document.getElementById("dob").value;
	var gender = document.querySelector('input[name="gender"]:checked');
	var designation = document.getElementById("designation").value;

	if (name === "" || email === "" || password === "" || dob === "" || !gender
			|| designation === "") {
		alert("All fields are required.");
		return false;
	}

	var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	if (!emailPattern.test(email)) {
		alert("Please enter a valid email address.");
		return false;
	}

	return true;
}

//function validateSearchEmployeeForm() {
//
//
//	return true;
//}

function validateUpdateEmployeeForm() {

	var name = document.getElementById("name").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var dob = document.getElementById("dob").value;
	var gender = document.querySelector('input[name="gender"]:checked');
	var designation = document.getElementById("designation").value;

	if (name === "" || email === "" || password === "" || dob === "" || !gender
			|| designation === "") {
		alert("All fields are required.");
		return false;
	}

	var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	if (!emailPattern.test(email)) {
		alert("Please enter a valid email address.");
		return false;
	}

	return true;
}

function validateDeleteEmployeeForm() {
	return confirm("Are you sure you want to delete this employee?");
}
