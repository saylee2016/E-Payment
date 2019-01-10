<div class="header_bottom">
	     	<div class="menu">
	     		<ul>
	     		<%
				try {

								String user = (String) session.getAttribute("role");
								if (user != null && user.equals("USER")) {
						%>
	     		
			    	<li class="active"><a href="shop.jsp">Home</a></li>
			    	<li><a href="about.jsp">About</a></li>
			    	<li><a href="logout.jsp">Logout</a></li>
			    	
			    	<%
							} else {
						%>
                         <li class="active"><a href="index.jsp">Home</a></li>
                         <li><a href="about.jsp">About</a></li>
						<li><a href=login.jsp> Login</a></li>
						<%
							}
							} catch (Exception e) {
								System.out.println(e);
							}
						%>
     			</ul>
	     	</div>
	     	<div class="clear"></div>
	     </div>	