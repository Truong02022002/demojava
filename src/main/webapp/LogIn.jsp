<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
<link rel="stylesheet" href="Css/styleLogIn.css">
<link rel="icon" type="image/x-icon" href="./img/favicon.PNG">
</head>
<body>
	<main>
		<section>
			<h2>Log in</h2>
			<form method = "POST", action="LogInServlet">
				<label for="username">Username</label>
				<input type="text" id="username" name="username" placeholder="Enter username...">
				<label for="password">Password</label>
				<input type="password" id="password" name="password" placeholder="Enter password...">
				<button type="submit">Log in</button>
			</form>
		</section>
	</main>	
</body>
</html>