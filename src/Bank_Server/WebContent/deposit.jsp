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
<script type="application/x-javascript"></script>
<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/paccordion.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/DepositeValidation.js"></script>
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
<%String message = request.getParameter("msg");
if(message != null){
%>	
<script type="text/javascript"> alert('<%=message%>'); </script>
<% }%>

<%String userId =String.valueOf(request.getSession().getAttribute("USERID"));
%>
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
	<div align="center">
			<form name="form" action="DepositeServlet" method="post" onsubmit="return validateDeposite(form);">

				<table width="200" border="0" cellspacing="5" bgcolor="#FFFFCC"
					cellpadding="5" style="margin-top: 10px">
					<thead>
						<tr>
							<th colspan="2" style="font-size: 22px">Deposite Form</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
							<td><input type="hidden" name="userid" id="userid"  value="<%=userId%>"/></td>
						</tr>
						<tr>
							<td>Amount</td>
							<td><input type="text" name="amount" id="amount" maxlength="4" /></td>
						</tr>

						<tr>
							<td></td>
							<td><input type="submit" name="submit" id="submit"
								value="Deposite" />&nbsp;&nbsp; <input type="reset" name="reset"
								id="reset" value="Reset" /></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>

	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>