<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
<!-- <link rel="stylesheet" href="/onlineShoppingApp/URLToResource/css/viewstyle.css"> -->
</head>


<body style="background-color: #f0f2f5;">
	<!-- <h1>Registered Users</h1> -->
	<nav class="navbar navbar-light bg-" style="background-color: #000000;">
		<div class="container-fluid">
			<a class="navbar-brand"> <img
				src="/Issues_Management/res/xworkz.jpeg" alt="" width="100"
				height="90" style="border-radius: 20px;">
			</a>


			<div class="dropdown">


				<span style="color: white;">Hi, Admin ${admin.username}</span> <img
					src="/Issues_Management/res/download.png" id="profileimage"
					alt="Profileimage" width="70" height="70"
					style="border-radius: 40px; margin-right: 70px;" role="button"
					data-bs-toggle="dropdown" aria-expanded="false">

				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="index.jsp"
						style="color: Black;">Home</a></li>
                    <li><a class="dropdown-item" href="viewst?p=ViewUsers" 
						style="color: Black;">ViewUsers</a></li>
				</ul>
			</div>


		</div>
	</nav>

	
	<h2 style="color: black; font-weight: 800">${message}</h2>
	  <div>
            <%
 if(request.getParameter("p")!=null)
 { 
   String p = request.getParameter("p");
%>    

<%@include file="Viewst.jsp" %>

<% 
 }
%>
</div>
</body>
</html>

