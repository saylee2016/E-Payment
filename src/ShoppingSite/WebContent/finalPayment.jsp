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
<div class="main">
<div class="content">

<h1>Please Enter the OTP  For Proceed</h1>		
<%String message = request.getParameter("msg");
if(message != null){
%>
	<script type="text/javascript"> alert('<%=message%>'); </script>
	<% }%>

<%
     String Prize =(String)session.getAttribute("totalPrize"); 
    System.out.println("In Payament: "+Prize);
%>	
<div align="center">
				<form name="form" action="FinalPayementServlet" method="post" >

					<table border="0" cellspacing="5" bgcolor="#FFFFCC" align="center">
						<thead>
							<tr>
								<th colspan="2" style="font-size: 32px"></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td align="left"><h3>Enter OTP here </h3>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							    <td align="center"><input type="hidden"/></td>
								<td align="right"><input type="text" name="otpass"
									id="otpass" /></td>
							</tr>
							<tr>
								<td></td>

								<td align="center"><input type="submit" name="submit"
									id="submit" value="Submit" />&nbsp;&nbsp; <input
									type="reset" name="reset" id="reset" value="Reset" /></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>		
</div></div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>