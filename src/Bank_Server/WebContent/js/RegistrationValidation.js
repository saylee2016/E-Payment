function validateRegistration(form) {

//	alert("Welcome User Registration Validation");

	if (form.firstName.value == "") {
		alert("Error: firstname cannot be blank!");
		form.firstName.focus();
		return false;
	}
	re = /[0-9]/;
	if (re.test(form.firstName.value)) {
		alert("Error: firstname should not contain numbers!");
		form.firstName.focus();
		return false;
	}
	re = /[A-Za-z]/;
	if (!re.test(form.firstName.value)) {
		alert("Error: firstname should not contain other character!");
		form.firstName.focus();
		return false;
	}

	if (form.lastName.value == "") {
		alert("Error: lastname cannot be blank!");
		form.lastName.focus();
		return false;
	}
	re = /[0-9]/;
	if (re.test(form.lastName.value)) {
		alert("Error: lastname should not contain numbers!");
		form.lastName.focus();
		return false;
	}
	re = /[A-Za-z]/;
	if (!re.test(form.lastName.value)) {
		alert("Error: lastname should not contain other character!");
		form.lastName.focus();
		return false;
	}
	var e = document.getElementById("gender");
	var Gender = e.options[e.selectedIndex].value;
	if (Gender == 0) {
		alert("Please select a Gender");
		return false;
	}

	if (form.emailId.value == "") {
		alert("Error: Email Id cannot be blank!");
		form.emailId.focus();
		return false;
	}
	re = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	if (!re.test(form.emailId.value)) {
		alert("Error: Invalid Email Id!");
		form.emailId.focus();
		return false;
	}
	if (form.mobileNo.value == "") {
		alert("Error: Contact Number cannot be blank!");
		form.mobileNo.focus();
		return false;
	}
	re = /[0-9]/;
	if (!re.test(form.mobileNo.value)) {
		alert("Error: Contact Number contain digit!");
		form.mobileNo.focus();
		return false;
	}

	re = /^[0-9]{10,12}$/;
	if (!re.test(form.mobileNo.value)) {
		alert("Error: Enter 10 or 12 digit Contact Number!");
		form.mobileNo.focus();
		return false;
	}
	
	/*if (form.accountNo.value == "") {
		alert("Error: AccountNo Number cannot be blank!");
		form.accountNo.focus();
		return false;
	}
	re = /[0-9]/;
	if (!re.test(form.accountNo.value)) {
		alert("Error: AccountNo Number contain digit!");
		form.accountNo.focus();
		return false;
	}

	re = /^[0-9]{8}$/;
	if (!re.test(form.accountNo.value)) {
		alert("Error: Enter  8 digit AccountNo Number!");
		form.accountNo.focus();
		return false;
	}*/
	
	var e = document.getElementById("accountType");
	var accountType = e.options[e.selectedIndex].value;
	if (accountType == 0) {
		alert("Please select a account type");
		return false;
	}
	if (form.userName.value == "") {
		alert("Error: Username cannot be blank!");
		form.userName.focus();
		return false;
	}
	re = /[0-9]/;
	if (re.test(form.userName.value)) {
		alert("Error: Username should not contain numbers!");
		form.userName.focus();
		return false;
	}
	re = /[A-Za-z]/;
	if (!re.test(form.userName.value)) {
		alert("Error: Username should not contain other character!");
		form.userName.focus();
		return false;
	}

	if (form.passWord.value != ""
			&& form.passWord.value == form.rePassword.value) {

		if (form.passWord.value.length < 6) {
			alert("Error: Password must contain at least six characters!");
			form.passWord.focus();
			return false;
		}
		if (form.passWord.value == form.userName.value) {
			alert("Error: Password must be different from Username!");
			form.passWord.focus();
			return false;
		}
		re = /[0-9]/;
		if (!re.test(form.passWord.value)) {
			alert("Error: password must contain at least one number (0-9)!");
			form.passWord.focus();
			return false;
		}
		re = /[a-z]/;
		if (!re.test(form.passWord.value)) {
			alert("Error: password must contain at least one lowercase letter (a-z)!");
			form.passWord.focus();
			return false;
		}
		re = /[A-Z]/;
		if (!re.test(form.passWord.value)) {
			alert("Error: password must contain at least one uppercase letter (A-Z)!");
			form.passWord.focus();
			return false;
		}
	} else {
		alert("Error: Please check that you've entered and confirmed your password!");
		form.passWord.focus();
		return false;
	}

	return true;
}
