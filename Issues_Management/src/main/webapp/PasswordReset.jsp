
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>sign up</title>
     <style>
            .error {
                color: red;
                font-size: 0.9em;
            }
             .valid {
            color: green;
        }
        .invalid {
            color: red;
        </style>
        
 <script>
        function validatePassword() {
            const newpassword = document.getElementById('newpassword').value;
            const message = document.getElementById('message');

            // Regular expressions for the different criteria
            const uppercasePattern = /[A-Z]/;
            const lowercasePattern = /[a-z]/;
            const numberPattern = /[0-9]/;
            const specialCharacterPattern = /[^A-Za-z0-9]/;

            // Check each criterion
            const hasUppercase = uppercasePattern.test(newpassword);
            const hasLowercase = lowercasePattern.test(newpassword);
            const hasNumber = numberPattern.test(newpassword);
            const hasSpecialCharacter = specialCharacterPattern.test(newpassword);

            if (hasUppercase && hasLowercase && hasNumber && hasSpecialCharacter) {
                message.textContent = 'NewPassword is valid';
                message.className = 'valid';
            } else {
                message.textContent = 'NewPassword must contain an uppercase letter, a lowercase letter, a number, and a special character.';
                message.className = 'invalid';
            }
        }
    </script>
</head>
<body
	style="background-color: #f0f2f5; ">
	<nav class="navbar navbar-light bg-" style="background-color:#000000; ">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="/Issues_Management/res/xworkz.jpeg" alt="" width="100"
				height="90" style="border-radius: 20px;">
			</a>
			<div>
				<a class="navbar-brand" href="index.jsp" style="color: aliceblue;">Home</a>
			</div>
		</div>
	</nav>
     <div class="container mt-5 col-md-4" style="font-weight: 400;">
             <div class="card style=width: 18rem;">
                 <div class="card-header">
                     password reset
                 </div>
                 <div class="card-body">

                      <form action="setpassword" method="post" id="signinForm">
                      ${msg}
                       <span style="color:red">
                                           <c:forEach items="${errormsg}" var="obj">
                                           ${obj.defaultMessage}
                                           </c:forEach>
                                           </span>
                         <div class="form-group mb-3">
                             <label for="email">Email</label>
                             <input type="email" class="form-control" id="email" name="email"  ${action == 'retain' ? 'readonly' : ' '} value="${dto.email}"  placeholder="Enter email">
                             <small class="error" id="emailError"></small>
                         </div>
                          <div class="form-group mb-3">
                               <label for="password">Password</label>
                               <input type="text" class="form-control" id="password" name="password" value="${dto.password}" placeholder="Enter password">
                                <small class="error" id="passwordError"></small>
                          </div>
                           <div class="form-group mb-3">
                            <label for="newpassword">New Password</label>
                            <input type="text" class="form-control" id="newpassword"  name="newpassword" placeholder="Enter password" onkeyup="validatePassword()">
                            <small class="error" id="passwordError"></small>
                             <p id="message"></p>
                            </div>
                             <div class="form-group mb-3">
                               <label for="confirmpassword">Confirm Password</label>

                                <input type="text" class="form-control" id="confirmpassword"  name="confirmpassword" placeholder="Enter password">
                                  <small class="error" id="passwordError"></small>
                                   </div>


                         <input type="submit" class="btn btn-primary" value="submit">
                     </form>
                 </div>
             </div>
         </div>
</body>
</html>
