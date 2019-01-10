<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Bank Server</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Mechanize  Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
</script>
<!--Google Fonts-->
<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/paccordion.js"></script>
<!--google fonts-->
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/RegistrationValidation.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
</head>
<body>
	<jsp:include page="navigation.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- FlexSlider -->
	<script defer src="js/jquery.flexslider.js"></script>
	<script type="text/javascript">
		$(function() {
		});
		$(window).load(function() {
			$('.flexslider').flexslider({
				animation : "slide",
				start : function(slider) {
					$('body').removeClass('loading');
				}
			});
		});
	</script>

	<%String message = request.getParameter("msg");
      if(message != null){
      %>
	   <script type="text/javascript"> 
	         alert('<%=message%>');
        	</script>
	<% }%>
	
	
	<div align="center">
		<form name="form" action="RegistrationServlet" method="post"
			onsubmit="return validateRegistration(form);">

			<table width="40%" border="0" cellspacing="2" bgcolor="#FFFFCC"
				cellpadding="2" style="margin-top: 10px">
				<thead>
					<tr>
						<th colspan="2" style="font-size: 22px">Registration Form</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td align="left">FirstName</td>
						<td><input type="text" name="firstName" id="firstName" /></td>
					</tr>
					<tr>
						<td align="left">LastName</td>
						<td><input type="text" name="lastName" id="lastName" /></td>
					</tr>
					<tr>
						<td align="left">Gender</td>
						<td><select name="gender" id=gender style="width: 100px">
								<option value="0">Select</option>
								<option value="Male">Male</option>
								<option value="Female">Female</option>
						</select></td>
					</tr>
					<tr>
						<td align="left">EmailId</td>
						<td><input type="text" name="emailId" id="emailId" /></td>
					</tr>
					<tr>
						<td align="left">MobileNo</td>
						<td><input type="text" name="mobileNo" id="mobileNo"
							maxlength="10" /></td>
					</tr>

					<%
						long epoch = System.currentTimeMillis();
					%>
					<tr>
						<td></td>
						<td><input type="hidden" name="secret_pin" id="secret_pin"
							value="<%=epoch%>" readonly="readonly" maxlength="8" /></td>
					</tr>
					<tr>
						<td align="left">Acount Type</td>
						<td><select name="accountType" id=accountType
							style="width: 100px">
								<option value="0">Select</option>
								<option value="Current">Current</option>
								<option value="Saving">Saving</option>
						</select></td>
					</tr>
					<tr>
						<td align="left">Initial Balance</td>
						<td><input type="text" name="minimumBalance"
							id="minimumBalance" value="10000" readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="left">UserName</td>
						<td><input type="text" name="userName" id="userName" /></td>
					</tr>
					<tr>
						<td align="left">Password</td>
						<td><input type="password" name="passWord" id="passWord" /></td>
					</tr>
					<tr>
						<td align="left">RePassword</td>
						<td><input type="password" name="rePassword" id="rePassword" /></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="submit" name="submit" id="submit"
							value="Register" />&nbsp;&nbsp; <input type="reset" name="reset"
							id="reset" value="Reset" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>