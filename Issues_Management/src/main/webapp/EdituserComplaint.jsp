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
<body>

	<form class="row g-3 reg_form"
		action="updatecomplaint?complaintId=${Cdto.id} "method="post">
		<h1 Style="font-weight: 400;">Complaints Form</h1>
		<div class="col-md-4">
			<p>Type of Complaint</p>
			<select class="form-select " aria-label="Complaint Type" name="type"
				id="type" disabled >
				<option selected alt="Open this select menu"  >${Cdto.type}</option>
				<option value="Electricity">Electricity</option>
				<option value="Water">Water</option>
				<option value="Sewage">Sewage</option>
				<option value="Garbage">Garbage</option>
				<option value="Road Block">Road Block</option>
			</select>
		</div>
		<div class="col-md-8">
			<label for="exampleFormControlTextarea1" class="form-label ">Complaint
				Description</label>
			<textarea class="form-control" id="description" name="description"
				rows="3"  >${Cdto.description}</textarea>
		</div>
		<div class="col-md-12">
			<label for="inputAddress" class="form-label">Address*</label> <input
				type="text" class="form-control" name="address" id="address"
				placeholder="1234 Main St" value="${Cdto.address}" readonly>
		</div>
		<div>
			<div class="col-md-3">
				<label for="inputCountry" class="form-label">Country</label> <select
					class="form-select" name="country" id="country"
					onchange="getStates()" disabled>
					<option selected  alt="Choose...">${Cdto.country}</option>
					<option>...</option>
				</select>
			</div>

			<div class="col-md-3">
				<label for="inputState" class="form-label">State</label> <select
					class="form-select" name="state" id="state" onchange="getCities()" disabled>
					<option selected  alt="Choose...">${Cdto.state}</option>
					<option>...</option>
				</select>
			</div>
			<div class="col-md-3">
				<label for="inputCity" class="form-label">City</label> <select
					class="form-select" name="city" id="city" disabled>
					<option selected alt="Choose...">${Cdto.city}</option>
					<option>...</option>
				</select>
			</div>
		</div>
		<div class="col-12">
			<div class="form-check">
				<input class="form-check-input" type="checkbox" id="gridCheck" required>  
				<label class="form-check-label" for="gridCheck"> I Agree
					that the information Provided is True and Best of My knowledge at
					the time of Raising this Complaint. </label>
			</div>
		</div>
		<div class="col-12">
			<button type="submit" class="btn btn-primary">Update
				Complaint</button>
			<button type="" class="btn btn-primary" style="margin-left: 5px;">Reset</button>
		</div>
	</form>
	<script src="/Issues_Management/res/Apipath.js" type="module"></script>
</body>
</html>
