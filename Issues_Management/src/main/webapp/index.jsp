
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Xworkz</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body  style="background-color: #f0f2f5; ">
  <nav class="navbar navbar-expand-lg navbar-light bg-" style="background-color: #000000;height:90px;">
      <div class="container-fluid">
          <a class="navbar-brand" href="#">
              <img src="/Issues_Management/res/xworkz.jpeg" alt="" width="100" height="90" style="border-radius: 20px;">
          </a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav ms-auto">
                  <li class="nav-item">
                      <a class="navbar-brand" aria-current="page" href="RegisterPage.jsp" style="color: aliceblue;">Sign Up</a>
                  </li>
                  <li class="nav-item">
                      <a class="navbar-brand" href="Login.jsp" style="color: aliceblue;">Sign In</a>
                  </li>
                <li class="nav-item"  >
                <a class="navbar-brand" href="Admin.jsp" style="color: aliceblue;">Admin
					Login</a></li>
					<li class="nav-item"  >
                <a class="navbar-brand" href="DepartmentAdminLogin.jsp" style="color: aliceblue;">Department Admin Login
					</a></li>
					<li class="nav-item"  >
					<a class="navbar-brand" href="EmployeeLogin.jsp" style="color: aliceblue;">Employee Login
					</a></li>
					
              </ul>
          </div>
      </div>
  </nav>



    <div class="container mt-5 mb-5 d-flex justify-content-center">
        <div class="card px-5 py-4 bg-light w-100" style="max-width: 500px;font-weight: 400; ">

            <div class="mb-1 mt-3">
            <p class="fw-bold"><h4> Technology Stack: </h4><span class="text-" style="font-weight:400;font-style: inherit; ">JAVA,HTML,CSS,BOOTSTRAP,MAVEN,JAVASCRIPT,SPRING,JPA.</span>
            </div>
            <div class="mb-1 mt-3">
             <p class="fw-bold"> <h4>Start Date:</h4> <span>25-06-2024</span>
                        </div>
            <div class="mb-1 mt-3">
             <p class="fw-bold"> <h4>VCS:</h4><a href="">GitHub</a></span>
              </div>
            <div class="mb-1 mt-3">
              <p class="fw-bold"> <h4>Description:</h4> <span>Project on designing  Sign Up page.
              Saving data to the data base.</span>
              </div>
        </div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
</body>
</html>
