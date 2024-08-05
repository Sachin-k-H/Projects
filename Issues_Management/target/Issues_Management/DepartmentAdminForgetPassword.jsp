
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
        </style>
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
                     Password reset
                 </div>
                 <div class="card-body">
                     <form action="forgotpassword" method="post" id="signinForm">
                     ${msg}
                     ${msg1}
                      ${msg2}
                     <span style="color:red">
                     <c:forEach items="${valid}" var="obj">
                     ${obj.defaultMessage}
                     </c:forEach>
                     </span>


                         <div class="form-group mb-3">
                             <label for="email">Email</label>
                             <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
                             <small class="error" id="emailError"></small>
                         </div>

                         <input type="submit" class="btn btn-primary" value="send password">

                     </form>
                 </div>
             </div>
         </div>
</body>
</html>
