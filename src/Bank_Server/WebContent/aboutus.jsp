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
<script type="text/javascript" src="js/LoginValidation.js"></script>
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
	<div class="about">
	<div class="container">
		<div class="about-main">
			<div class="about-top">
				<h2>About Us</h2>
				<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem.</p>
			</div>
			<div class="aboutbottom">
				<div class="col-md-5 about-left">
					<img src="images/ab.jpg" alt="" class="img-responsive">
				</div>
				<div class="col-md-7 about-right">
					<h3>Our History</h3>
					<h4>Sed ut perspiciatis unde omnis iste natus error</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				   <div class="about-grid-list">
					    <div class="about-list-left">
					    	<h5>Nam libero tempore</h5>
					    	<p>On the other hand, we denounce with righteous indignation and dislike men who are so beguiled</p>
					    </div>
					    <div class="about-list-right">
					    	<h5>Nam libero tempore</h5>
					    	<p>These cases are perfectly simple and easy to distinguish. In a free hour and demoralized</p>
					    </div>
					    <div class="clearfix"> </div>
				    </div>
				</div>
			 <div class="clearfix"> </div>
		   </div>
		</div>
	</div>
</div>
    
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>