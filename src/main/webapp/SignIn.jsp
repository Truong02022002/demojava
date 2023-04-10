<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/styleLogIn.css">
</head>
<body>
	<main>
		<section>
			<h2>Đăng ký</h2>
			<form method="POST" action="SignInServlet">
				<label for="username">Tên đăng nhập</label>
				<input type="text" id="username" name="username" placeholder="Nhập tên đăng nhập nha...">
				<label for="phone">Số điện thoại</label>
				<input type="text" id="phone" name="phone" placeholder="Mời nhập số điện thoại vào đây nha...">
				<label for="password">Mật khẩu</label>
				<input type="password" id="password" name="password" placeholder="Nhập mật khẩu nha...">
				<button type="submit">Đăng ký</button>
			</form>
		</section>
	</main>	
</body>
</html>