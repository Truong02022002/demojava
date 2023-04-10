<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new parking fee</title>
<link rel="stylesheet" type="text/css" href="Css/StyleAdd.css">
<link rel="icon" type="image/x-icon" href="./img/favicon.PNG">
</head>
<body>
	<section>
		<h1>Add new parking fee</h1>
			<form method="Post" action="CreateGiaDoXe" >
				<label for="id">Id parking fee:</label><br> <input type="text" name="id"><br> 
				<label for="name">Types of vehicle:</label><br> <input type="text" name="name"><br> 
				<label for="time">Time:</label><br> <input type="date" name="time"><br><br>
				<label for="price">Fee:</label><br> <input type="text" name="price"><br>
				<input type="submit" value="Add new parking fee">
			</form>
	</section>
</body>
</html>