<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Country State City Selector</title>


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
<script type="text/javascript">

function setType(){
	let name=document.getElementById("d_type");
	let error=document.getElementById("typeError");
	if(name.value.trim()==="Open this select menu" || name.value.length<3 || name.value.length>30){
	error.innerHTML="Please enter a valid type";
	error.style.color='red';
	}
	else{
	error.innerHTML="";
	}
	
	}



function setAddress(){
	let name=document.getElementById("address");
	let error=document.getElementById("addressError");
	if(name.value.trim()==="" || name.value.length<5 || name.value.length>30){
	error.innerHTML="Please enter Address correctly minimum 5 character";
	error.style.color='red';
	}
	else{
	error.innerHTML="";
	}
	
	}
	
function setCity(){
	let name=document.getElementById("area");
	let error=document.getElementById("areaError");

	if(name.value.trim()==="Choose..." || name.value.trim()===""){
	error.innerHTML="Please enter City correctly";
	error.style.color='red';
	}
	else{
	error.innerHTML="";
	}
	}

</script>


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

	<form class="row g-3 reg_form" action="createdepartment" modelattribute="departmentDto">

		<h1 Style="font-weight: 400;">Register Department</h1>
		<div class="col-md-4">
			<p>Department*</p>
			<select class="form-select " aria-label="Department Type" name="d_type"
				id="d_type" onblur="setType()" required>
				<option selected>Open this select menu</option>
				<option value="Electricity">Electricity</option>
				<option value="Water">Water</option>
				<option value="Sewage">Sewage</option>
				<option value="Garbage">Garbage</option>
				<option value="Road Block">Road Block</option>
				<option value="Network">Network</option>
				<option value="Police">Police</option>
				<option value="Gasline">Gas-line</option>
				
			</select>
			<p id="typeError"></p>
		</div>
		<div class="col-md-12">
			<label for="inputArea" class="form-label">city*</label> <input
				type="text" class="form-control" name="area" id="area"
				placeholder="City" onblur="setCity()" required>
				<p id="areaError"></p>
		</div>
		<div class="col-md-12">
			<label for="inputAddress" class="form-label">Address*</label> <input
				type="text" class="form-control" name="address" id="address"
				placeholder="1234 Main St" onblur="setAddress()" required>
				<p id="addressError"></p>
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
	</form>
	
</body>
</html>
