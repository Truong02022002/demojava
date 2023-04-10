<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
  boolean isLoggedIn = session.getAttribute("username") != null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="Css/Style.css">
<link rel="icon" type="image/x-icon" href="./img/favicon.PNG">
<style>
main {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

.mySlides {
  display: none;
  width: 100%;
}

.prev, .next {
  position: absolute;
  top: 50%;
  width: auto;
  margin-top: -22px;
  padding: 16px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
}

.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}

.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active, .dot:hover {
  background-color: #717171;
}

.numbertext {
  color: white;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

.text {
  color: white;
  font-size: 25px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<header>
		<h1>Parking lot management</h1>
		<p>${nhanvien}</p>
		<nav>
			<ul>
				<li><a href="index.jsp"><i class="fa fa-home"></i> Home</a></li>
				<li><a href="IndexGiaBaiDo?index=0"><i class="fa fa-money"></i> Parking fee</a></li>
				<li><a href="IndexXe?index=0"><i class="fa fa-car"></i> Vehicle</a></li>
				<li><a href="IndexPhieudoxe?index=0"><i class="fa fa-ticket"></i> Parking ticket</a></li>
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
		<div class="slideshow-container" >
        
        <div class="mySlides fade" >
        <a href="index.jsp">
          <div class="numbertext">1 / 6</div>
          <img src="./img/trang-chu.jpg" style="width:100%">
          <div class="text">Home</div>
        </a>
        </div>
        
        <div class="mySlides fade" >
        <a href="IndexGiaBaiDo">
          <div class="numbertext">2 / 6</div>
          <img src="./img/xe.jpg" style="width:100%">
          <div class="text">Parking fee</div>
        </a>
        </div>
        
        <div class="mySlides fade" >
        <a href="IndexXe">
          <div class="numbertext">3 / 6</div>
          <img src="./img/background2.jpg" style="width:100%">
          <div class="text">Vehicle</div>
        </a>
        </div>
        
        <div class="mySlides fade" >
        <a href="IndexPhieudoxe">
          <div class="numbertext">4 / 6</div>
          <img src="./img/phieu-do-xe1.jpg" style="width:100%">
          <div class="text">Parking ticket</div>
        </a>
        </div>
        
        <div class="mySlides fade" >
        <a href="IndexNhanVien">
          <div class="numbertext">5 / 6</div>
          <img src="./img/De-Gea.jpg" style="width:100%">
          <div class="text">Employee</div>
        </a>
        </div>
        
        <div class="mySlides fade" >
        <a href="IndexThongke.jsp">
          <div class="numbertext">6 / 6</div>
          <img src="./img/phieu-do-xe2.jpg" style="width:100%">
          <div class="text">Address</div>
        </a>
        </div>
        
        <a class="prev" onclick="plusSlides(-1)">❮</a>
        <a class="next" onclick="plusSlides(1)">❯</a>
        
        </div>
        <br>
        
        <div style="text-align:center">
          <span class="dot" onclick="currentSlide(1)"></span> 
          <span class="dot" onclick="currentSlide(2)"></span> 
          <span class="dot" onclick="currentSlide(3)"></span> 
          <span class="dot" onclick="currentSlide(4)"></span>
          <span class="dot" onclick="currentSlide(5)"></span>
          <span class="dot" onclick="currentSlide(6)"></span>
        </div>
        
        <script>
        let slideIndex = 1;
        showSlides(slideIndex);
        
        function plusSlides(n) {
          showSlides(slideIndex += n);
        }
        
        function currentSlide(n) {
          showSlides(slideIndex = n);
        }
        
        function showSlides(n) {
          let i;
          let slides = document.getElementsByClassName("mySlides");
          let dots = document.getElementsByClassName("dot");
          if (n > slides.length) {slideIndex = 1}    
          if (n < 1) {slideIndex = slides.length}
          for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";  
          }
          for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
          }
          slides[slideIndex-1].style.display = "block";  
          dots[slideIndex-1].className += " active";
        }
        </script>
	</main>
</body>
</html>