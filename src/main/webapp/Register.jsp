<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER REGISTRATION</title>
<link rel="stylesheet" href="two.css">
</head>
<body>


<!-- Error / Success Messages -->

<%
	String msg = request.getParameter("msg");
	String error = request.getParameter("error"); 
	
	
	if("empty".equals(error))
	{
%>

	<p style="color:red;">All Fields Required</p>
	
<%
	}
	else if("failed".equals(error))
	{
%>
	<p style="color:red;">Registration Failed</p>
	
<%
	}
	
	else if("registered".equals(msg))
	{
%>
	<p style="color:green;">Registration Successfull! - PLEASE LOGIN</p>
	
<%
	}
%>

<form action="register" method="post">

<div class="container">
<h2 class="b22"> USER REGISTRATION</h2><br><br>
<label class="b24">NAME:</label>
<input type="text" name="name" class="b21">
<label class="b24">Email:</label>
<input type="email" name="email" class="b21">
<label class="b24">Password:</label>
<input type="password" name="password" class="b21"><br>

<input type="submit" value="Register" class="b21 b23"><br><br>

<a href="Login.jsp">Already Have Account? Login</a>
</div>





</form>



</body>
</html>