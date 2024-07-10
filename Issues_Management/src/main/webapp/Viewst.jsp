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
	<%-- <nav class="navbar navbar-light bg-" style="background-color: #000000;">
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

				</ul>
			</div>


		</div>
	</nav> --%>

	<!-- <form class="d-flex" action="search" style="margin-top: 5px;">
		<input class="form-control mb-lg-2 me-4" name="username" type="search"
			placeholder="Search by Username" aria-label="Search">
		<button class="btn btn-outline-success mb-lg-2" type="submit">Search</button>
	</form> -->
	<table class="table  table-hover table-dark ">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">First Name</th>
				<th scope="col">First Name</th>
				<th scope="col">Password</th>
				<th scope="col">Email</th>
				<th scope="col">Mobile</th>
				<th scope="col">Created By</th>
				<th scope="col">Created Date</th>
				<th scope="col">Updated By</th>
				<th scope="col">Updated Date</th>
				<th scope="col">Login Count</th>
				<th scope="col">Account Lock</th>
				<th scope="col">Profile Image</th>
				<th scope="col">Delete User</th>
				<!-- 	<th scope="col">Update Details</th> -->

			</tr>
		</thead>
		<c:forEach var="user" items="${stulist}">
			<tr>
				<td scope="row">${user.id}</td>
				<td scope="row">${user.firstName}</td>
				<td scope="row">${user.lastName}</td>
				<td scope="row">${user.password}</td>
				<td scope="row">${user.email}</td>
				<td scope="row">${user.phone}</td>
				<td scope="row">${user.createdBy}</td>
				<td scope="row">${user.createdDate}</td>
				<td scope="row">${user.updatedBy}</td>
				<td scope="row">${user.updatedDate}</td>
				<td scope="row">${user.countLogin}</td>
				<td scope="row">${user.accountLock}</td>
				<td scope="row">${user.profileImage}</td>

				<td scope="row"><a href="deleteuser?id=${user.id}"><input
						type="button" class="btn btn-primary" value="Delete "></a></td>
				<%-- <td scope="row"><a href="edituser?id=${user.id}"><input
						type="button" class="btn btn-primary" value="Edit"></a></td> --%>
			</tr>
		</c:forEach>
	</table>
	<h2 style="color: black; font-weight: 800">${message}</h2>
</body>
</html>

