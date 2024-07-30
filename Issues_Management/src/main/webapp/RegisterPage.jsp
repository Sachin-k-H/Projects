
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>sign up</title>
<style>
.error {
	color: red;
	font-size: 0.9em;
}
</style>

</head>
<body
	style="background-color: #f0f2f5; ">
	<nav class="navbar navbar-light bg-" style="background-color:#000000; ">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">  <img src="/Issues_Management/res/xworkz.jpeg" alt="" width="100" height="90" style="border-radius: 20px;">
			</a>
			<div>
				<a class="navbar-brand" href="index.jsp" style="color: aliceblue;">Home</a>
			</div>
		</div>
	</nav>
	<div class="container mt-5 col-md-4" style="font-weight: 400;">
		<div class="card style=width: 18rem;">
			<div class="card-header">Sign Up</div>
			<div class="card-body">
				<form name="myform" action="signupdata" method="post"
					id="signUpForm" onsubmit="return validationform()">
					<span style="color: red"> <c:forEach items="${valid}"
							var="obj">
                     ${obj.defaultMessage}
                     </c:forEach>
					</span>

					<h1 style="color: green">${success}</h1>
					<div class="form-group mb-3">
						<label for="firstName">First Name</label> <input type="text"
							class="form-control" id="firstName" name="firstName"
							value="${dto.firstName}" placeholder="Enter first name">
						<small class="error" id="firstNameError"></small>
					</div>
					<div class="form-group mb-3">
						<label for="lastName">Last Name</label> <input type="text"
							class="form-control" id="lastName" name="lastName"
							value="${dto.lastName}" placeholder="Enter last name"> <small
							class="error" id="lastNameError"></small>
					</div>
					<div class="form-group mb-3">
						<label for="email">Email</label> 
						<input type="email"class="form-control" id="email" name="email"placeholder="Enter email" value="${dto.email}" onblur="CheckEmail()" required> 
							<small class="error" id="emailError"></small>
						<p id="enteredemail" style="color: red"></p>

					</div>
					<div class="form-group mb-3">
						<label for="phone">Phone</label> 
						<input type="tel"class="form-control" id="phone" name="phone"placeholder="Enter phone number" value="${dto.phone}" onblur="CheckPhone()"> 
						<small class="error" id="phoneError"></small>
						<p id="enteredphone" style="color: red"></p>
					</div>
					<div class="form-group form-check mb-3">
						<input type="checkbox" class="form-check-input" id="signUpCheck" required>
						<label class="form-check-label" for="signUpCheck"  >I agree 
							to the terms and conditions</label>
					</div>

					<input type="submit" class="btn btn-primary" value="submit" >
<script src="/Issues_Management/res/Ajax.js"></script>

				</form>
			</div>
		</div>
	</div>
</body>
</html>
