<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Home Shopee</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/slider.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript" src="js/AccountValidation.js"></script>
<script type="text/javascript" src="js/startstop-slider.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<p>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
							&nbsp;&nbsp;</p>
							<p>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
							&nbsp;&nbsp;</p>
							<p>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
							&nbsp;&nbsp;</p>
							<p>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
							&nbsp;&nbsp;</p>
							<p>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
							&nbsp;&nbsp;</p>
							
	<div class="main">
		<div class="content">
			<p>&emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp;</p>
		<div align="center">
		<form name="form" action="LoginServlet" method="post"
			onsubmit="return validateLogin(form);">

			<table border="0" cellspacing="5" align="center">
				<thead>
					<tr>
						<th colspan="2" style="font-size: 32px"> User Login Form</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>UserName</td>
						<td><input type="text" name="userName" id="userName" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="passWord" id="passWord" /></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="submit" name="submit" id="submit"
							value="Login" />&nbsp;&nbsp; <input type="reset" name="reset"
							id="reset" value="Reset" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<p>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
							&nbsp;&nbsp;</p>
							<p>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
							&nbsp;&nbsp;</p>
							<p>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
							&nbsp;&nbsp;</p>
							<p>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
							&nbsp;&nbsp;</p>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>