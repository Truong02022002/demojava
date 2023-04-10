<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new emloyee</title>
<link rel="stylesheet" type="text/css" href="Css/StyleAdd.css">
<link rel="icon" type="image/x-icon" href="./img/favicon.PNG">
</head>
<body>
	<section>
		<h1>Add new employee</h1>
			<form method="Post" action="CreateNhanVien" enctype="multipart/form-data">
				<label for="id">Id:</label><br> <input type="text" name="id"><br> 
				<label for="name">Name:</label><br> <input type="text" name="name"><br> 
				<label for="bdate">Birthday:</label><br> <input type="date" name="bdate"><br>
				<label for="sex">Sex:</label><br> <input type="text" name="sex"><br>
				<label for="address">Address:</label><br> <input type="text" name="address"><br>
				<label for="phone">Phone:</label><br> <input type="text" name="phone"><br>
				<label for="pictureNV">Personal picture:</label><br> 
				<input type="file" name="pictureNV" required> 
				<input type="submit" value="Add Employee">
			</form>
	</section>
</body>
</html>