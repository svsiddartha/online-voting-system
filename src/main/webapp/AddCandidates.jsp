<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	if(session==null || session.getAttribute("admin")==null)
    	{
    		response.sendRedirect("AdminLogin.jsp");
    		return;
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Candidate</title>
<link rel="stylesheet" href="two.css">
</head>
<body>



<%


	String msg = request.getParameter("msg");
	String error = request.getParameter("error");
	
	if("added".equals(msg))
	{
%>

	<p style="color:green;">Candidate added successfully!</p>
	
<%
	}
	else if("empty".equals(error))
	{
%>
	<p style="color:red;">All fields are required!</p>
	
<%
	}
	else if("failed".equals(error))
	{
%>
	<p style="color:red">Failed to add Candidate!</p>
<% 
	}
%>
	
	
<form action="addCandidate" method="post">
<div class="container">
<h2 class="b22">Welcome Admin</h2>
<label class="b24">Candidate Name:</label>
<input type="text" name="name" class="b21">
<label class="b24">Party:</label>
<input type="text" name="party" class="b21"><br>

<input type="submit" value="Add Candidate" class="b21 b23"><br><br>

<a href="Logout.jsp">Logout</a>
</div>

</form>





</body>
</html>