function validateLogin(form) {

	// alert(form.username);

	if (form.userName.value == "") {
		alert("Error: Please Enter Username !");
		form.userName.focus();
		return false;
	}

	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	if (form.passWord.value == "") {
		alert("Error: Please Enter Password !");
		form.passWord.focus();
		return false;
	}

	return true;
}
