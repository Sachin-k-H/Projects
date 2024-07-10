<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Xworkz</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
   <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</head>
<body style="background-color: #f0f2f5; " >

  <nav class="navbar navbar-light bg-" style="background-color:#000000; ">
		<div class="container-fluid">
			<a class="navbar-brand" >  <img src="/Issues_Management/res/xworkz.jpeg" alt="" width="100" height="90" style="border-radius: 20px;">
			</a>
			
				
<div class="dropdown">
 
  
  <span style="color: white;">Hi, ${dto.firstName}${dto.lastName}</span> <img src="${pageContext.request.contextPath}${sessionScope.profileImage}"   id="profileimage" alt="Profileimage" width="80" height="80" style="border-radius: 50px; margin-right:70px;"  role="button" data-bs-toggle="dropdown" aria-expanded="false">
 
  <ul class="dropdown-menu" >
    <li><a class="dropdown-item" href="index.jsp" style="color: black;">Home</a></li>
    <li><a class="dropdown-item" href="passwordReset?id=${dto.id}" style="color: black;">Reset Password</a></li>
    <li><a class="dropdown-item" href="edituser?id=${dto.id}" style="color: black;">Edit Profile</a></li>
    <li><a class="dropdown-item" href="viewuser?id=${dto.id}" style="color: black;">View Profile</a></li>
    <li><a class="dropdown-item" href="viewuser?id=${dto.id}" style="color: black;">Raise Complaints</a></li>
    <li><a class="dropdown-item" href="viewuser?id=${dto.id}" style="color: black;">View Complaints</a></li>
  </ul>
</div>
			
			
			
			<!-- <div>
				<a class="navbar-brand" href="admin.jsp" style="color: aliceblue;">Admin
					Login</a>
			</div> -->
		</div>
	</nav>
  <h1 style="color: green;">${msg}</h1>
   <div class="mb-1 mt-3">
            <p class="fw-bold"><h4> Welcome <span>${dto.firstName} ${dto.lastName}</span>
            </div>
            <div>
            <%
 if(request.getParameter("id")!=null)
 { 
   String p = request.getParameter("id");
%>    

<%@include file="Viewst.jsp" %>

<% 
 }
%>
</div>
</body>

</html>