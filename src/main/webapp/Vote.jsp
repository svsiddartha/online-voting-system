<%@page import="java.util.List"%>
<%@page import="model.Candidate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	if(session==null || session.getAttribute("user")==null){
    		response.sendRedirect("Login.jsp");
    		return;
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vote</title>
<link rel="stylesheet" href="two.css">
</head>
<body>



<form action="vote" method="post">
<div class="container">
<h2 class="b22">Cast your Vote</h2>

<table border="1" cellpadding="20" >
	<tr>
		<th class="b25">Select</th>
		<th class="b25">Candidate</th>
		<th class="b25">Party</th>
	</tr>
		
	<%
		java.util.List<model.Candidate> list = (java.util.List<model.Candidate>) request.getAttribute("candidates");
		
		if(list!=null)
		{
			for(model.Candidate c : list)
			{
%>
		<tr>
			<td>
				<input type="radio" name="candidate_id" class="b25" value="<%= c.getCandidateId() %>" required>
			</td>
			
			<td class="b25"><%= c.getName() %></td>
			<td class="b25"><%= c.getParty() %></td>
			
		</tr>
		
<%
			}
		}	
%>
</table>

<br>
<input type="submit" value="Vote" class="b21 b23">

<a href="Logout.jsp">Logout</a>
</div>
</form>

<br>


</body>
</html>