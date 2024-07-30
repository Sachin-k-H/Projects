<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>Xworkz</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
	integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
	crossorigin="anonymous"></script>
</head>
<body style="background-color: #f0f2f5;align-content: center;">

	<nav class="navbar navbar-light bg-"
		style="background-color: #000000; height: 90px;">
		<div class="container-fluid">
			<a class="navbar-brand"> <img
				src="/Issues_Management/res/xworkz.jpeg" alt="" width="100"
				height="65">
			</a>


			<div class="dropdown">


				<span style="color: white;">Hi,
					${dto.firstName}${dto.lastName}</span> <img
					src="${pageContext.request.contextPath}${sessionScope.profileImage}" class="rounded-circle profile-image "
					id="profileimage" alt="profileimage" width="80" height="80" onerror="this.onerror=null;this.src='https://icons8.com/icon/50jQltuChBWa/user';"
					style="border-radius: 50px; margin-right: 70px;" role="button"
					data-bs-toggle="dropdown" aria-expanded="false">

				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="index.jsp"
						style="color: black;">Home</a></li>
					<li><a class="dropdown-item" href="passwordReset?id=${dto.id}"
						style="color: black;">Reset Password</a></li>
					<li><a class="dropdown-item" href="edituser?d=${dto.id}"
						style="color: black;">Edit Profile</a></li>
					<li><a class="dropdown-item" href="viewuser?id=${dto.id}"
						style="color: black;">View Profile</a></li>
					<li><a class="dropdown-item"
						href="raiseComplaints?p=${dto.id}" style="color: black;">Raise
							Complaints</a></li>
					<li><a class="dropdown-item" href="viewcomplaints?userid=${dto.id}"
						style="color: black;">View Complaints</a></li>
				</ul>
			</div>

		</div>
	</nav>
	<h3 style="color: green;">${msg} ${msg2}</h3>
	<div class="mb-1 mt-3">
		<p class="fw-bold">
		<h4>
			Welcome <span>${dto.firstName} ${dto.lastName}</span>
		</h4>
	</div>
	<div>

		<!-- for viewing user details in home page- -->
		<%
		if (request.getParameter("id") != null) {
			String p = request.getParameter("id");
		%>

		<%@include file="ViewUser.jsp"%>

		<%
		}
		%>
		<!-- for Raising Complaint details in home page- -->

		<%
		if (request.getParameter("p") != null) {
			String p = request.getParameter("p");
		%>

		<%@include file="RaiseComplaints.jsp"%>

		<%
		}
		%>



		<!-- for Editing user details in home page- -->
		<%
		if (request.getParameter("d") != null) {
			String p = request.getParameter("d");
		%>
		
		

		<%@include file="EditUser.jsp"%>

		<%
		}
		%>
		
		
		<!-- for viewing Complaint details in home page- -->

		<%
		if (request.getParameter("userid") != null) {
			String p = request.getParameter("userid");
		%>

		<%@include file="ViewComplaints.jsp"%>

		<%
		}
		%>

	</div>
</body>

</html>