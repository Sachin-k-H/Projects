<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
	integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
	crossorigin="anonymous"></script>
<style type="text/css">
</style>
</head>


<body style="background-color: #f0f2f5;">
	<nav class="navbar navbar-light "
		style="background-color: #000000; height: 90px;">
		<div class="container-fluid">
			<img src="/Issues_Management/res/xworkz.jpeg" alt="" width="100"
				height="70">

			<div class="dropdown">
				<span style="color: white;">Hi, ${Admin.username}</span> <img
					src="/Issues_Management/res/download.png" id="profileimage"
					alt="Profileimage" width="70" height="70"
					style="border-radius: 40px; margin-right: 70px;" role="button"
					data-bs-toggle="dropdown" aria-expanded="false">

				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="index.jsp"
						style="color: Black;">Home</a></li>
					<li><a class="dropdown-item"
						href="viewallcomplaints?a=ViewUsers" style="color: Black;">View
							All Complaints </a></li>
				</ul>
			</div>


		</div>
	</nav>

	<h2 style="color: red; font-weight: 800">${msg2}</h2>
	<h2 style="color: black; font-weight: 800">${message}</h2>
	

	<table class="table  table-hover table-dark ">
		<thead>
			<tr>
				<th scope="col">Complaint ID</th>
				<th scope="col">Complaint Type</th>
				<th scope="col">Complaint Description</th>
				<th scope="col">Address</th>
				<th scope="col">Country</th>
				<th scope="col">State</th>
				<th scope="col">City</th>
				<th scope="col">Created By</th>
				<th scope="col">Created Date</th>
				<th scope="col">User Id</th>
				<th scope="col">Complaint Status</th>
				<th scope="col" colspan="1">Allocate Employee</th>
				<th scope="col"></th>


			</tr>
		</thead>
		<c:forEach var="user" items="${stulist}">
			<form action="changestatus" modelattribute="complaintsdto"
				method="post">
				<input name="id" value="${user.id}" hidden> </input>
				<tr>
					<td scope="row">${user.id}</td>
					<td scope="row">${user.type}</td>
					<td scope="row">${user.description}</td>
					<td scope="row">${user.address}</td>
					<td scope="row">${user.country}</td>
					<td scope="row">${user.state}</td>
					<td scope="row">${user.city}</td>
					<td scope="row">${user.createdBy}</td>
					<td scope="row">${user.createdDateTime}</td>
					<td scope="row">${user.userid}</td>

					<td scope="row"><div class="col-md" style="width: 110px;">
							<select class="form-select " aria-label="status" name="status"
								id="status">
								<option selected>${user.status}</option>
								<option value="Active">Active</option>
								<option value="Pending">Pending</option>
								<option value="Resovled">Resovled</option>
								<option value="Unresolved">Unresolved</option>
							</select>
						</div></td>
						<td scope="row"><div class="col-md" style="width: 110px;">
							<select class="form-select " aria-label="status" name="status"
								id="status">
								</select></div>
								</td>
								
								
								
						
					<%-- <td scope="row"><div class="col-md" style="width: 110px;">
							<select class="form-select " aria-label="department"
								name="department" id="department">
								
								<c:forEach var="list" items="${departmentlist}">
									<c:if test="${list['d_id']==user['department']}">
										<option value="${list.d_type}">${list.d_type}</option>
									</c:if>
								</c:forEach>
								<c:choose>
									<c:when test="${fn:length(user.department) == 0}">
										<option selected>Allocate</option>
										<c:forEach var="dept" items="${departmentlist}">
											<option value="${dept.d_id}">${dept.d_type}(ID:${dept.d_id})</option>
										</c:forEach>
									</c:when>
								</c:choose>
							</select>
						</div></td> --%>
					

					<td scope="row"><a
						href="changestatus?complaintid=${user.id}&&department=${user.department}"><input
							type="submit" class="btn btn-primary" value="sumbit"></a></td>
				</tr>
			</form>
		</c:forEach>
	</table>



</body>
</html>
