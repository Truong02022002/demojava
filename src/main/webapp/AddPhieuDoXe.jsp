<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new parking ticket</title>
<link rel="stylesheet" type="text/css" href="Css/StyleAdd.css">
<link rel="icon" type="image/x-icon" href="./img/favicon.PNG">
</head>
<body>
	<section>
		<h1>Add new parking ticket</h1>
			<form method="Post" action="CreatePhieuDoXe" >
				<label for="id">Id parking ticket:</label><br> <input type="text" name="id"><br> 
				<label for="id_car">Id Vehicle:</label><br>
				<select id="id_car" name="id_car" required>
					<option value = "">---Select types of vehicle---</option>
					<c:forEach var = "cr" items = "${create}">
						<option value = "${cr.id}">${cr.id}</option>
					</c:forEach>					
				</select>
				<label for="timeIn">Time in:</label><br> <input type="date" name="timeIn"><br>
				<label for="timeOut">Time out:</label><br> <input type="date" name="timeOut"><br>
				<label for="price">Total:</label><br> <input type="text" name="price"><br>
				<input type="submit" value="Add new parking ticket">
			</form>
	</section>
</body>
</html>