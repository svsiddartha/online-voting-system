<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER LOGIN</title>
<link rel="stylesheet" href="two.css">
</head>
<body>

<%
	String error = request.getParameter("error");
	String msg = request.getParameter("msg");

	if("empty".equals(error)){
%>
	<p style="color:red;">All Fields Required</p>
<%
	}
	else if("invalid".equals(error))
	{
%>
	<p style="color:red;">Invalid Email or Password</p>
<%
	}
	else if("registered".equals(msg)){
%>
	<p style="color:green;">Registration Successfull - Please Login!</p>
<%
	}
%>

<form action="login" method="post">
<div class="container">
<h2 class="b22"> USER LOGIN</h2><br><br>
<label class="b24">Email:</label>
<input type="email" name="email" class="b21">
<label class="b24">Password</label>
<input type="password" name="password" class="b21"><br>
<input type="submit" value="Login" class="b21 b23"><br><br>
<a href="Register.jsp">New User? Register here</a>
</div>
</form>




</body>
</html>