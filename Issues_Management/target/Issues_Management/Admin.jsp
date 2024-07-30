
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>admin login</title>
     <style>
            .error {
                color: red;
                font-size: 0.9em;
            }
        </style>
</head>
<body style="background-color: #f0f2f5; ">
    <nav class="navbar navbar-light bg-" style="background-color:#000000; ">
        
            <a class="navbar-brand" href="#">
                 <img src="/Issues_Management/res/xworkz.jpeg" alt="" width="100" height="90" style="border-radius: 20px;">
            </a>
            <div>
                <a class="navbar-brand" href="index.jsp" style="color: aliceblue;">Home</a>
            </div>
        </div>
    </nav>
     <div class="container mt-5 col-md-4">
             <div class="card ;">
                 <div class="card-header">
                     Admin Login
                 </div>
                 <div class="card-body">
                     <form action="adminlogin" method="post" id="signinForm">
                     
                     <span style="color:red">
                     
                     ${msg}
                     
                     </span>


                         <div class="form-group mb-3">
                             <label for="email">Email</label>
                             <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
                             <small class="error" id="emailError"></small>
                         </div>
                         <div class="form-group mb-3">
                             <label for="password">Password</label>
                             <input type="text" class="form-control" id="password" name="password" placeholder="Enter password">
                             <small class="error" id="passwordError"></small>
                         </div>

                         <input type="submit" class="btn btn-primary" value="submit">
                     </form>

                 </div>
             </div>

         </div>
</body>
</html>
