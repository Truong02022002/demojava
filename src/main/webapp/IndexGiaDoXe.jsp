<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  boolean isLoggedIn = session.getAttribute("username") != null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parking fee</title>
<link rel="stylesheet" type="text/css" href="Css/Style.css">
<link rel="icon" type="image/x-icon" href="./img/favicon.PNG">
<style>
.fa {
  display: inline-block; /* Hiển thị biểu tượng như một khối inline */
  font-size: 16px; /* Kích thước của biểu tượng */
  margin-right: 5px; /* Khoảng cách giữa biểu tượng và văn bản */
}

.fa-edit {
  color: black; /* Màu của biểu tượng sửa */
}

.fa-trash {
  color: black; /* Màu của biểu tượng xóa */
}
.add1 {
  display: flex; /* Sử dụng flexbox để căn giữa nội dung trong div */
  margin-top: 20px; /* Khoảng cách từ đỉnh trang web */
}

.add1 a {
  display: inline-block; /* Hiển thị các liên kết dưới dạng khối inline */
  padding: 10px; /* Khoảng cách giữa nội dung và đường viền */
  margin: 0 5px; /* Khoảng cách giữa các liên kết */
  color: #333; /* Màu chữ của liên kết */
  text-decoration: none; /* Loại bỏ gạch chân trong văn bản liên kết */
  border: 1px solid #ccc; /* Đường viền liên kết */
  border-radius: 5px; /* Bo tròn góc của liên kết */
}

.add1 a:hover {
  background-color: #eee; /* Màu nền khi rê chuột vào liên kết */
}
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
			<div class="search">
				<form action="SearchGiaDoXe" method="post">
					<input type="text" id="search" name="search" placeholder="Search...">
					<button type="submit">Search</button>
				</form>
			</div>
			<h2>Parking fee</h2>
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Types of vehicle</th>
						<th>Times</th>
						<th>Fee</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="l" items="${lst}">
						<tr>
							<td>${l.id}</td>
							<td>${l.name}</td>
							<td>${l.time}</td>
							<td>${l.price}</td>
							<td><a href="EditGiaDoXe?id=${l.id}"><i
									class="fa fa-edit"></i></a></td>
							<td><a href="DeleteGiaDoXe?id=${l.id}"><i
									class="fa fa-trash"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="add1">
				<c:forEach begin="0" end="${end}" var="i">
					<a href="IndexGiaBaiDo?index=${i}">${i+1}</a>
				</c:forEach>
			</div>
			<div class="add">
				<button>
					<a href="AddGiaDoXe.jsp">Add new employee</a>
				</button>
			</div>
		</section>
	</main>
</body>
</html>