<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="card" style="width:20rem;margin: auto;">
  <img src="${pageContext.request.contextPath}${sessionScope.profileImage}" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Profile details</h5>
    <p class="card-text">"Believe in Yourself.You are braver than you think,more 
    talented than you Know,and capable of more than you imagine".</p>
  </div>
  <c:forEach var="user" items="${stulist}">
  <ul class="list-group list-group-flush">
  
    <li class="list-group-item">Name    :${user.firstName}${user.lastName}</li>
    <li class="list-group-item">Email   :${user.email}</li>
    <li class="list-group-item">Phone   :${user.phone}</li>
    <li class="list-group-item">Status  :${user.accountStatus}</li>
    
  </ul>
  </c:forEach>
  <!-- <div class="card-body">
    <a href="#" class="card-link">Card link</a>
    <a href="#" class="card-link">Another link</a>
  </div> -->
</div>
</body>
</html>