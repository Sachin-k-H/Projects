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
 
<style type="text/css">


</style>
</head>


<body style="background-color: #f0f2f5;">
	
	<table class="table  table-hover table-dark ">
		<thead>
			<tr>
				<th scope="col">ID</th>
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
				<th scope="col">Department</th>
				<th scope="col">Edit Complaint</th>
				

			</tr>
		</thead>
		<c:forEach var="user" items="${stulist}">
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
				<td scope="row">${user.status}</td>
				<td scope="row">${user.department}</td>
			
				 <td scope="row"><a href="editcomplaint?d=${user.id}"><input
						type="button" class="btn btn-primary" value="Edit"></a></td> 
			</tr>
		</c:forEach>
	</table>
	<h2 style="color: black; font-weight: 800">${message}</h2>
</body>
</html>

