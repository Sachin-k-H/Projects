<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl5/ieIJ6gIFhvjaCln2gq5oWeFf3vSUcIB+q5VR7j"
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
	style="background-color: #f0f2f5; " >
	<nav class="navbar navbar-light bg-"style="background-color:#000000; ">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">  <img src="/Issues_Management/res/xworkz.jpeg" alt="" width="100" height="90" style="border-radius: 20px;">
			</a>
			<div>
				<a class="navbar-brand" href="index.jsp" style="color: aliceblue;">Home</a>
			</div>
			<!-- <div>
				<a class="navbar-brand" href="admin.jsp" style="color: aliceblue;">Admin
					Login</a>
			</div> -->
		</div>
	</nav>
	<div class="container mt-5 col-md-4" style="font-weight: 400;">
		<div class="card style=width: 18rem;">
			<div class="card-header">Sign In</div>
			<div class="card-body">
				<form action="signindata" method="post" id="signinForm" name="myformlogin"
					onsubmit="return validate()">
					<p style="color:red"> ${msg1} ${msg2}</p>
					 <p style="color: green;">  ${msg}</p>
					<%--  <span style="color:red">
                     <c:forEach items="${valid}" var="obj">
                     ${obj.defaultMessage}
                     </c:forEach>
                     </span> --%>


					<div class="form-group mb-3" >
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" name="email"
							placeholder="Enter email" autocomplete="off"> <small class="error"
							id="emailError"></small>
					</div>
					<div class="form-group mb-3">
						<label for="password">Password</label> <input type="text"
							class="form-control" id="password" name="password"
							placeholder="Enter password" autocomplete="off"> <small class="error"
							id="passwordError"></small>
					</div>
					<div class="form-group mb-3">
						<div class="captcha">
							<label for="captcha-input">Enter Captcha</label>
							<div id="captchaPreview"
								class="mb-2 bg-white p-2 text-center border"></div>
							<div class="captcha d-flex align-items-center">
								<input type="text" name="captcha" id="captcha"
									placeholder="Enter captcha text" class="form-control me-2">
								<button type="button" class="btn btn-secondary"
									onclick="generateCaptcha()">
									<i class="fas fa-sync-alt"></i> &#8635;
								</button>
							</div>
							<span id="captchaError" class="text-danger"></span>
						</div>
					</div>

					<input type="submit" class="btn btn-primary" value="submit"
						id="btn"> <a href="ForgotPassword.jsp">Forgot
						Password</a>
				</form>
			</div>
		</div>
	</div>

	<script src="/Issues_Management/res/Captcha.js"> </script>
</body>
</html>