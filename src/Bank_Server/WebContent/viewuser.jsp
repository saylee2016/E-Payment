<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.bank.dbwrapper.UserDBWrapper"%>
<%@page import="com.bank.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>

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
	
	<%
    UserDBWrapper helper= new UserDBWrapper();
    ArrayList<UserBean> al = helper.getAllUserdetails();

%>
<H1 align="center" style="color: blue;">Users Details </H1>

<table border="1" align="center">
			<tr>
			<td>User Id</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Gender</td>
			<td>Email ID</td>
			<td>Mobile</td>
			<td>Delete Holder</td>
			</tr>
			<%
			for (UserBean bean : al)
			{  
			%>
			<tr>
			<td><%=bean.getId() %></td>
			<td><%=bean.getFirstName() %></td>
			<td><%=bean.getLastName() %></td>
			<td><%=bean.getGender() %></td>
			<td><%=bean.getEmailId() %></td>
			<td><%=bean.getMobileNo() %></td>
			<td><a href="RemoveUserServlet?uid=<%=bean.getId()%>"><button>Remove</button>  </a></td>
			</tr>
			<%} %>
	</table>
	
    
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>