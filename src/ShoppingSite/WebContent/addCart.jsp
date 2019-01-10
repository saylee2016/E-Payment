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
			<p>&emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp;</p>
			<h1 style="font: bold; color: blue;">Your Selected Items Are</h1>
			<div align="center">
				<table width="50%" border="0" cellspacing="2" bgcolor="#FFFFCC"
					cellpadding="2" style="margin-top: 10px">
					<thead>
						<tr>
							<th colspan="2" style="font-size: 18px" align="left"><h2>Product
									Name</h2></th>
							<th colspan="2" style="font-size: 18px" align="center"><h2>Product
									Details</h2></th>
							<th colspan="2" style="font-size: 18px" align="right"><h2>Prize</h2>
							</th>
						</tr>
					</thead>
					<tbody>
						<%
							String[] shopProducts = request.getParameterValues("shopproducts");
							int totalPrize = 0;
							for (String product : shopProducts) {
								String[] details = product.split(",");
								String selctedproduct = details[0];
								String selectedprize = details[1];
								totalPrize = totalPrize + Integer.parseInt(selectedprize);

								System.out.println("Product is: " + selctedproduct
										+ " Prize is: " + selectedprize);
						%>

						<tr>
							<td align="left" colspan="2" style="font-size: 15px"><h3><%=selctedproduct%>
								</h3></td>
							<td align="center"><img style="height: 40"
								src="images/<%=selctedproduct%>.jpg"></td>
							<td align="right" colspan="2" style="font-size: 15px"><span
								class="rupees"><%=selectedprize%></span></td>
						</tr>

						<%
							}
							System.out.println("Product Final Prize is:" + totalPrize);
						%>
						<p>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
							&nbsp;&nbsp;</p>
						<p>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
							&nbsp;&nbsp;</p>
						<tr>
							<td align="left" colspan="2" style="font-size: 15px"><h3>Total
									Prize</h3></td>
							<td align="center">&emsp;</td>
							<td align="right" colspan="2" style="font-size: 15px"><h3><%=totalPrize%></h3></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div align="center">
				<form name="form" action="SubmitServlet" method="post"
					onsubmit="return validateRegistration(form);">

					<table border="0" cellspacing="5" bgcolor="#FFFFCC" align="center">
						<thead>
							<tr>
								<th colspan="2" style="font-size: 32px"></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td align="left"><h3>Total Prize</h3>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td align="center"><input type="hidden" name="totalPrize"
									id="totalPrize" value="<%=totalPrize%>" /></td>
								<td align="right"><h3><%=totalPrize%></h3></td>
							</tr>
							<tr>
								<td align="left"><h3>Account ID:</h3></td>
								<td align="center"><input type="hidden" /></td>
								<td align="right"><input type="text" name="accountID"
									id="accountID" /></td>
							</tr>

							<tr>
								<td></td>

								<td align="center"><input type="submit" name="submit"
									id="submit" value="Submit Details" />&nbsp;&nbsp; <input
									type="reset" name="reset" id="reset" value="Reset" /></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>