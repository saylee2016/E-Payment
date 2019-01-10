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
<script type="text/javascript" src="js/startstop-slider.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<form action="addCart.jsp" method="post">
	<div class="main">
		<div class="content">
			<div class="content_top">
				<div class="heading">
					<h3>New Products</h3>
				</div>
				<div class="clear"></div>
			</div>
			<div class="section group">
				<div class="grid_1_of_4 images_1_of_4">
					<img src="images/TVLCDBIG.jpg"
						alt="" /></a>
					<h2>TV LCD</h2>
					<div class="price-details">
						<div class="price-number">
							<p>
								<span class="rupees"> <input type="hidden" name="prize"
									value="620">Rs 620
								</span>
							</p>
						</div>
						<div class="add-cart">
							<h4>
								<a><input type="checkbox" name="shopproducts"value="TVLCDBIG,620">Add to Cart</a>
							</h4>
						</div>
						<div class="clear"></div>
					</div>

				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<img src="images/HomeThatre1.jpg"
						alt="" /></a>
					<h2>Home Theatre</h2>
					<div class="price-details">
						<div class="price-number">
							<p>
								<span class="rupees"> <input type="hidden" name="prize"
									value="899">Rs 899
								</span>
							</p>
						</div>
						<div class="add-cart">
							<h4>
								<a><input type="checkbox" name="shopproducts" value="HomeThatre1,899">Add to Cart</a>
							</h4>
						</div>
						<div class="clear"></div>
					</div>

				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<img src="images/NikonCamera.jpg"
						alt="" /></a>
					<h2>Nikon Camera</h2>
					<div class="price-details">
						<div class="price-number">
							<p>
								<span class="rupees"><input type="hidden" name="prize"
									value="599">Rs 599</span>
							</p>
						</div>
						<div class="add-cart">
							<h4>
								<a><input type="checkbox" name="shopproducts" value="NikonCamera,599">Add to Cart</a>
							</h4>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<img src="images/TV_Videiocon.jpg"
						alt="" /></a>
					<h2>TV Videocon</h2>
					<div class="price-details">
						<div class="price-number">
							<p>
								<span class="rupees"><input type="hidden" name="prize"
									value="679">Rs 679</span>
							</p>
						</div>
						<div class="add-cart">
							<h4>
								<a><input type="checkbox" name="shopproducts" value="TV_Videiocon,679">Add to Cart</a>
							</h4>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>

			<div class="section group">
				<div class="grid_1_of_4 images_1_of_4">
				<img src="images/CannonCamera.jpg" alt="" /></a>
					<h2>Cannon Camera</h2>
					<div class="price-details">
						<div class="price-number">
							<p>
								<span class="rupees"><input type="hidden" name="prize"
									value="849">Rs 849</span>
							</p>
						</div>
						<div class="add-cart">
							<h4>
								<a><input type="checkbox" name="shopproducts"value="CannonCamera,849">Add to Cart</a>
							</h4>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
				<img src="images/Speakers.jpg" alt="" /></a>
					<h2>Speakers</h2>
					<div class="price-details">
						<div class="price-number">
							<p>
								<span class="rupees"><input type="hidden" name="prize"
									value="599.99">Rs 599</span>
							</p>
						</div>
						<div class="add-cart">
							<h4>
								<a><input type="checkbox" name="shopproducts" value="Speakers,599">Add to Cart</a>
							</h4>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<img src="images/LCD.jpg" alt="" /></a>
					<h2>LCD</h2>
					<div class="price-details">
						<div class="price-number">
							<p>
								<span class="rupees"><input type="hidden" name="prize"
									value="799">Rs 799</span>
							</p>
						</div>
						<div class="add-cart">
							<h4>
								<a><input type="checkbox" name="shopproducts" value="LCD,799">Add to Cart</a>
							</h4>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<img src="images/HomeThatre.jpg" alt="" /></a>
					<h2>Home Theatre</h2>
					<div class="price-details">
						<div class="price-number">
							<p>
								<span class="rupees"><input type="hidden" name="prize"
									value="899.99">Rs 899</span>
							</p>
						</div>
						<div class="add-cart">
							<h4>
								<a><input type="checkbox" name="shopproducts" value="HomeThatre,899">Add to Cart</a>
							</h4>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
<div class="main">
    <div class="content">
    	<div class="section group">
				<div class="col span_2_of_3">
				  <div class="contact-form">
	<div>
		<span><input type="submit" value="Submit" class="myButton"></span>
	</div>
	</div></div></div></div></div>
</form>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		$(document).ready(function() {
			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

