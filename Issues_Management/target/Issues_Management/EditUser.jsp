<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
<style>

.reg_form{
	position: relative;
	left: 35%;
	
	font-weight: 600;
}

</style>

<script type="text/javascript">

function previewImage(event) {
    var reader = new FileReader();
    reader.onload = function(){
        var output = document.getElementById('profileImagePreview');
        output.src = reader.result;
        output.style.display = 'block';
    };
    reader.readAsDataURL(event.target.files[0]);
}


</script>
</head>

<body style="background-color: #f0f2f5; ">
<!-- <nav class="navbar navbar-light bg-" style="background-color:#000000; ">
		<div class="container-fluid">
			 <img
				src="/Issues_Management/res/xworkz.jpeg" alt="" width="100"
				height="90" style="border-radius: 20px;">
			
			</div>
			</nav> -->

	
	<form class="col-md-4 reg_form" action="Update" method="post" modelAttribute="registerdto" enctype="multipart/form-data">
	<h1 >Edit User Details</h1>
		<div>
			<input class="form-control" type="hidden" name="id"
				value="${dto.id}">
		</div> 
		
		<div>
			<label>Email :</label> <input class="form-control" type="text"
				name="email" value="${dto.email}" readonly>
		</div>
		<div>
			<label>FristName :</label> <input class="form-control" type="text"
				name="firstName" value="${dto.firstName}">
		</div>
		<div>
			<label>LastName :</label> <input class="form-control" type="text"
				name="lastName" value="${dto.lastName}">
		</div>
		<div>
			<label>Mobile :</label> <input class="form-control" type="text"
				name="phone" value="${dto.phone}" readonly>
		</div>
		<div>
		
 <div>
 <label for="file">Choose a profile image:</label>
      <div> <input type="file" id="file" name="file" accept="image/*" onchange="previewImage(event)">
       <br><br>
         <img id="profileImagePreview" class="profile-image" src="#" alt="Profile Image Preview" style="display: none;" width=80 height=80>
          <br><br>
       </div>  
</div>

			
		</div>
		<div>
			<input class="btn btn-primary reg_form" type="submit" value="Update" style="margin: 10px;"/>
		</div>


	</form>
</body>
</html>
