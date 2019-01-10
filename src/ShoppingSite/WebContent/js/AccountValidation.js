function validateRegistration(form) {

//	alert("Welcome User Account Validation");

	if (form.accountNo.value == "") {
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

	re = /^[0-9]{10}$/;
	if (!re.test(form.accountNo.value)) {
		alert("Error: Enter  8 digit AccountNo Number!");
		form.accountNo.focus();
		return false;
	}


	return true;
}
