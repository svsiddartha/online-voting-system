<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    if(session == null || session.getAttribute("user")==null)
    {
    	response.sendRedirect("Login.jsp");
    	return;
    }
    
    	model.User user = (model.User) session.getAttribute("user"); 
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vote Result</title>
<link rel="stylesheet" href="three.css">
</head>
<body>

<div class="final">

<h2 class="b26">Thank you for Voting!</h2>

<p class="b26">
	Dear <b class="b26"><%= user.getName() %></b>, Your Vote has been recorded Successfully.</p>
	
	<p style="color:green;" class="b26">
	You are not Allowed to Vote Again.
	</p>
	
	<br>
	
	<a href="Index.jsp" class="b26 b27">logout</a>
	
</div>

</body>
</html>