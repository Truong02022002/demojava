<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit parking ticket information</title>
<link rel="stylesheet" type="text/css" href="Css/StyleAdd.css">
<link rel="icon" type="image/x-icon" href="./img/favicon.PNG">
</head>
<body>
	<section>
		<h1>Edit parking ticket information</h1>
			<form action="EditPhieuDoXe?id_cu=${phieu.getId()}" method="post">
			
				<label for="id">Id parking ticket:</label> 
				<input type="text" id="id" name="id" value = "${phieu.getId()}"> 
				<br> 
				<label for="id_car">Id vehicle:</label><br>
				<select id="id_car" name="id_car" required>
					<option value = "${cal}">${cal}</option>
					<c:forEach var = "cr" items = "${create}">
						<option value = "${cr.id}">${cr.id}</option>
					</c:forEach>					
				</select>
				<br>
				<br>  
				<label for="timeIn">Time in:</label>
				<input type="date" id="timeIn" name="timeIn" value = "${phieu.getThoi_gian_vao()}">
				<br> <br> 
				<label for="timeOut">Time out:</label> 
				<input type="date" id="timeOut" name="timeOut" value = "${phieu.getThoi_gian_ra()}">
				<br> <br> 
				<label for="price">Total:</label> 
				<input type="text" id="price" name="price" value = "${phieu.getSo_tien()}"> 
				<br> <br> 
				<input type="submit" value="Edit parking ticket information">
			</form>
	</section>
</body>
</html>