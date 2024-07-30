<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register Department Admin</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
<!-- <script src="/Issues_Management/res/ComplaintFormValidation.js"></script> -->

<style type="text/css">
.reg_form {
	position: relative;
	align-items: center;
	width: 60%;
	font-weight: 600;
	border: 2px solid black;
	outline: #4CAF50 solid 10px;
	margin: auto;
	margin-top: 20px;
	margin-bottom: 20px;
	padding: 20px;
}
</style>



</head>
<body style="background-color: #f0f2f5;">
<nav class="navbar navbar-light " style="background-color: #000000;height:90px;">
		<div class="container-fluid">
			 <img
				src="/Issues_Management/res/xworkz.jpeg" alt="" width="100"
				height="70" >
			


			<div class="dropdown">


				<span style="color: white;">Hi, ${Admin.username}</span> <img
					src="/Issues_Management/res/download.png" id="profileimage"
					alt="Profileimage" width="70" height="70"
					style="border-radius: 40px; margin-right: 70px;" role="button"
					data-bs-toggle="dropdown" aria-expanded="false">

				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="index.jsp"
						style="color: Black;">Home</a></li>
                    <li><a class="dropdown-item" href="viewst?p=ViewUsers" 
						style="color: Black;">View All Users</a></li>
						<li><a class="dropdown-item" href="viewallcomplaints?a=ViewUsers" 
						style="color: Black;">View All Complaints </a></li>
				</ul>
			</div>


		</div>
	</nav>

	<form class="row g-3 reg_form" action="createdepartmentadmin" modelattribute="departmentAdmin">

		<h1 Style="font-weight: 400;">Register DepartmentAdmin</h1>
		<input type="hidden" name="username" id="username" value="Admin">
		<div class="col-md-4">
			<p>Department*</p>
			<select class="form-select " aria-label="Department Type" name="department"
				id="department" onblur="checkDepartment()" required>
				<option selected value="">Open this select menu</option>
				<option value="Electricity">Electricity</option>
				<option value="Water">Water</option>
				<option value="Sewage">Sewage</option>
				<option value="Garbage">Garbage</option>
				<option value="Road Block">Road Block</option>
				<option value="Network">Network</option>
				<option value="Police">Police</option>
				<option value="Gasline">Gas-line</option>
				
			</select>
			<p id="departmentError"></p>
		</div>
		<div class="col-md-12">
			<label for="inputArea" class="form-label">Email*</label> <input
				type="email" class="form-control" name="email" id="email"
				placeholder="email" onblur="VerifyEmail()" required>
				<p id="enteredemail" style="color: red"></p>
		</div>
		<div class="col-md-12">
			<label for="phone">Phone*</label> 
						<input type="tel"class="form-control" id="phone" name="phone"
						placeholder="Enter phone number"  
						onblur="VerifyPhone()" required> 
				<p id="enteredphone" style="color: red"></p>
		</div>
		
		<div class="col-12">
			<div class="form-check">
				<input class="form-check-input" type="checkbox" id="gridCheck" required>
				<label class="form-check-label" for="gridCheck"> I Agree
					that the information Provided is True and Best of My knowledge . </label>
			</div>
		</div>
		<div class="col-12">
			<button type="submit" class="btn btn-primary" id="btn" >Create
				Department</button>
		
		</div>
		<script src="/Issues_Management/res/Ajax.js"></script>
	</form>
	
</body>
</html>
