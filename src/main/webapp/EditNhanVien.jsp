<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit employee information</title>
<link rel="stylesheet" type="text/css" href="Css/StyleAdd.css">
<link rel="icon" type="image/x-icon" href="./img/favicon.PNG">
</head>
<body>
	<section>
		<h1>Edit employee information</h1>
			<form action="EditNhanVienServlet?id_cu=${nhanvien.getId()}" method="post" enctype="multipart/form-data">
			
				<label for="id">ID:</label> 
				<input type="text" id="id" name="id" value = "${nhanvien.getId()}"> 
			
				<label for="name">Name:</label> 
				<input type="text" id="name" name="name" value = "${nhanvien.getHo_ten()}" > 
				
				<label for="bdate">Birthday:</label>
				<input type="date" id="bdate" name="bdate" value = "${nhanvien.getNgay_sinh()}">
				<br>
				<br>
				<label for="sex">Sex:</label> 
				<input type="text" id="sex" name="sex" value = "${nhanvien.getGioi_tinh()}">
				
				<label for="address">Address:</label> 
				<input type="text" id="address" name="address" value = "${nhanvien.getDia_chi()}"> 
				
				<label for="phone">Phone:</label> 
				<input type="text" id="phone" name="phone" value = "${nhanvien.getSdt()}"> 
				
				<label>Current profile image: </label>
				<img alt="#" src="${nhanvien.getHinh_anh()}" width="80" height="60">
				<br>
				<br>
				<label for="pictureNV">Profile image change: </label> 
				<input type="file" id="pictureNV" name="pictureNV" value = ""> 
				
				<input type="submit" value="Sửa thông tin nhân viên">
			</form>
	</section>
</body>
</html>