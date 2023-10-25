function validateBalance() {
    var balance = document.getElementById('balance').value;
    if (balance < 1000) {
        document.getElementById('balance').style.backgroundColor = 'Red';
        return false; 
    } else {
        document.getElementById('balance').style.backgroundColor = 'LightGreen';
    }
}


function validateMobile() {
	var mob = document.getElementById('mob').value;
	var mobilepattern = /^\d{10}$/;

	if (mobilepattern.test(mob)) {
		document.getElementById('mob').style.backgroundColor = 'LightGreen';
	} else {
		document.getElementById('mob').style.backgroundColor = 'Red';
	}

}

function validateEmail() {
	var email = document.getElementById('email').value;
	var emailpattern = /^([a-z\d\.-]+)@([a-z\d-]+)\.([a-z]{2,8})(\.[a-z]{2,8})?$/;

	if (emailpattern.test(email)) {
		document.getElementById('email').style.backgroundColor = 'LightGreen';
	} else {
		document.getElementById('email').style.backgroundColor = 'Red';
	}
}

function validatePassword() {
	var pass = document.getElementById('pass').value;
	var passpattern = /^[\d\w@-]{8,20}$/i;

	if (passpattern.test(pass)) {
		document.getElementById('pass').style.backgroundColor = 'LightGreen';
	}
	else{
		document.getElementById('pass').style.backgroundColor = 'Red';
	}
}