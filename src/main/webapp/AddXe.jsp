<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parking lot management</title>
<link rel="stylesheet" type="text/css" href="Css/StyleAdd.css">
<link rel="icon" type="image/x-icon" href="./img/favicon.PNG">
</head>
<body>
	<section>
			<h1>Add new vehicle</h1>
			<form method="post" action="CreateXe">
				<label for="id">ID:</label><br>
				<input type="text" id="id" name="id"><br>
		
				<label for="catagory">Type of vehicle:</label><br>
				<select id="catagory" name="catagory" required>
					<option value = "">---Select type of vehicle---</option>
					<c:forEach var = "cr" items = "${create}">
						<option value = "${cr.id}">${cr.id}</option>
					</c:forEach>					
				</select>
		
				<label for="seanum">License plate number:</label><br>
				<input type="text" id="seanum" name="seanum" ><br>
		
				<label for="pictureNV">Vehicle image:</label><br> 
				<input type="file" name="pictureNV" required> 
				
				<input type="submit" value="Add vehicle">
			</form>	
		</section>
</body>
</html>