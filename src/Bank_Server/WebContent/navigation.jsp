
<div class="header">
	<div class="container">
		<div class="header-main">
			<div class="logo">
				<h1>
					<a href="#">Bank Server</a>
				</h1>
			</div>
			<div class="top-nav">
				<span class="menu"> <img src="images/icon.png" alt=""></span>
				<nav class="cl-effect-13" id="cl-effect-13">
					<ul class="res">
						<li><a class="active" href="index.jsp">Home</a></li>
						<li><a href="aboutus.jsp">About</a></li>
						<%
							try {

								String user = (String) session.getAttribute("role");
								if (user != null && user.equals("ADMIN")) {
						%>

						<li><a href="register.jsp">Registration</a></li>
						<li><a href="viewuser.jsp">View Account Users</a></li>
						<li><a href="logout.jsp">Logout</a></li>

						<%
							} else if (user != null && user.equals("USER")) {
						%>

						<li><a href="deposit.jsp">Money Deposit</a></li>
						<li><a href="logout.jsp">Logout</a></li>
						<%
							} else {
						%>

						<li><a href="login.jsp">Admin Login</a></li>
						<li><a href="Userlogin.jsp">User Login</a></li>
						<%
							}
							} catch (Exception e) {
								System.out.println(e);
							}
						%>
					</ul>
				</nav>
				<!-- script-for-menu -->
				<script>
					$("span.menu").click(function() {
						$("ul.res").slideToggle(300, function() {
							// Animation complete.
						});
					});
				</script>
				<!-- /script-for-menu -->

			</div>

			<div class="clearfix"></div>
		</div>
	</div>
</div>