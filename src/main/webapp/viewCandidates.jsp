<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import ="java.util.List" %>
    <%@ page import ="model.Candidate" %>
    
    <% if(session==null || session.getAttribute("admin")==null)
    {
    	response.sendRedirect("Admin.jsp");
    	return;
    }
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="two.css">
</head>
<body>

<div class="container">
<h2>Candidates List</h2>

<table border="1" cellpadding="10">
	
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Party</th>
		<th>Votes</th>
		<th>Action</th>
	</tr>
	
	<%
		List<Candidate> list = (List<Candidate>)request.getAttribute("candidates");
		
			if(list !=null && list.isEmpty())
			{
				for(Candidate c : list)
				{
	%>

					<tr>
						<td><%= c.getCandidateId() %></td>
						<td><%= c.getName() %></td>
						<td><%= c.getParty() %></td>
						<td><%= c.getVotes() %></td>
					</tr>
					
	<%
				}
			}
			else
			{
				
	%>
			<tr>
				<td colspan="5" style="color:red;">No Candidates Available</td>
					
			</tr>
	<%
			}
	%>
</table>
</div>

</body>
</html>