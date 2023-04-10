<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit parking fee information</title>
<link rel="stylesheet" type="text/css" href="Css/StyleAdd.css">
<link rel="icon" type="image/x-icon" href="./img/favicon.PNG">
</head>
<body>
	<section>
		<h1>Edit parking fee information</h1>
			<form action="EditGiaDoXe?id_cu=${gia.getId()}" method="post">
			
				<label for="name">Types of vehicle:</label> 
				<input type="text" id="name" name="name" value = "${gia.getName()}" > 
				<br>
				<label for="time">Times:</label>
				<input type="date" id="time" name="time" value = "${gia.getTime()}">
				<br>
				<br>
				<label for="price">Fee:</label> 
				<input type="number" id="price" name="price" value = "${gia.getPrice()}">
				<br>
				<input type="submit" value="Edit parking fee information">
			</form>
	</section>
</body>
</html>