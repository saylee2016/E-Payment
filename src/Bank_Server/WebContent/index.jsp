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
	<div class="we-are">
		<div class="container">
			<div class="we-are-main">
				<div class="col-md-6 we-are-left">
					<h2>How we do it</h2>
					<p>In recent years E-shopping gained a tremendous growth due to its benefits. Even though benefits of E-shopping are considerable,
it creates some security threats such as debit, credit card fraud, phishing etc. In this paper we introduce an E-payment system that
provides an unrivaled security using visual and quantum cryptography. Visual cryptography hides the details of customer by
generating shares whereas Quantum cryptography secures the transmission of one time password .Image steganography embeds
the share with one time password which results in secure transmission of share to bank. Proposed approach guarantees
unconditional security than traditional E-payment system by using two important cryptographic techniques.</p>
				</div>
				<div class="col-md-6 we-are-rights">
					<img src="images/w2.jpg" alt="" class="img-responsive">
				</div>
				<div class="clearfix"></div>
				<div class="we-are-middle">
					<img src="images/w5.jpg" alt="" class="img-responsive">
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>