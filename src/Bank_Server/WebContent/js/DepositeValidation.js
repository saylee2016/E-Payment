function validateDeposite(form) {

	if (form.amount.value == "") {
		alert("Error: Please Enter Amount !");
		form.amount.focus();
		return false;
	}
	
	if (form.amount.value == 0) {
		alert("Error: Amount should be greter zero !");
		form.amount.focus();
		return false;
	}
	
	if (form.amount.value == -1) {
		alert("Error: Amount should be greter then zero !");
		form.amount.focus();
		return false;
	}
	
	re = /^\d+$/;
	if (!re.test(form.amount.value)) {
		alert("Error: Amount should numbers!");
		form.amount.focus();
		return false;
	}

	return true;
}
