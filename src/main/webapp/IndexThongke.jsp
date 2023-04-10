<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
  boolean isLoggedIn = session.getAttribute("username") != null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thống kê</title>
<link rel="stylesheet" type="text/css" href="Css/Style.css">
<link rel="icon" type="image/x-icon" href="./img/favicon.PNG">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<header>
		<h1>Parking lot management</h1>
		<nav>
			<ul>
				<li><a href="index.jsp"><i class="fa fa-home"></i> Home</a></li>
				<li><a href="IndexGiaBaiDo?index=0"><i class="fa fa-money"></i> Parking fee</a></li>
				<li><a href="IndexXe?index=0"><i class="fa fa-users"></i> Vehicle</a></li>
				<li><a href="IndexPhieudoxe?index=0"><i class="fa fa-users"></i> Parking ticket</a></li>
				<li><a href="IndexNhanVien?index=0"><i class="fa fa-users"></i> Employee</a></li>
				<li><a href="IndexThongke.jsp"><i class="fa fa-map-marker"></i> Address</a></li>
				<% if (isLoggedIn) { %>
				  <li><a href="index.jsp<%session = request.getSession();
								session.removeAttribute("username");
								isLoggedIn = false;%>"><i class='fa fa-sign-out'></i> Log out</a></li>
				<% } else { %>
				  <li><a href="LogIn.jsp"><i class='fa fa-sign-in'></i> Log in</a></li>
				<% } %>
			</ul>
		</nav>
	</header>
	<main>
		<section>
			<center>
				<h1>Parking Address</h1>
				<iframe
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3919.
			2041220792876!2d106.66353744663876!3d10.795672685980813!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175292df0a317d9%3A0xba04c8fca22926!
			2zMTUvMTQgUGjhuqFtIFbEg24gSGFpLCBQaMaw4budbmcgMSwgVMOibiBCw6xuaCwgVGjDoG5oIHBo4buRIEjhu5MgQ2jDrSBNaW5oLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1679887037339!
			5m2!1svi!2s"
					width="600" height="450" style="border: 1;" ; allowfullscreen=""
					loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
			</center>
		</section>
	</main>
</body>
</html>
