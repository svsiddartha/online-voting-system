<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet" href="two.css">
</head>
<body>


<%
	String error = request.getParameter("error");
	
	if("empty".equals(error))
	{
%>
	<p style="color:red;">Username And Password are required!</p>
	
<%
	}
	else if("invalid".equals(error)){
%>
	<p style="color:red;">Invalid Admin Credentials!</p>
<%
	}
%>

<form action="admin" method="post">
<div class="container">
<h2 class="b22">Admin Login</h2>
<label class="b24">Username:</label>
<input type="text" name="username" class="b21">
<label class="b24">Password:</label>
<input type="password" name="password" class="b21"><br>

<input type="submit" value="Login" class="b21 b23">

</div>
</form>
</body>
</html>