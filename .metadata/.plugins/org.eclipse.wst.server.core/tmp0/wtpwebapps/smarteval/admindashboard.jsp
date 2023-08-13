<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./CSS/index.css">
<title>SmartEval - Admin Dashboard</title>
</head>
<body>
	<%
		if(session.getAttribute("username")==null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		else if(session.getAttribute("role")==null || (Integer)session.getAttribute("role")!=1){
			response.sendRedirect(request.getContextPath()+"/errorpage.jsp");
		}
	%>
	<div class="admin-dashboard">
		<jsp:include page="header2.jsp" />
		<div class="admin-page-container">
			<h1>Welcome <%=session.getAttribute("username")%>!</h1>
			<h2>Quick Links</h2>
		<div class="grid-container">
			<a href="./addquestion.jsp"><div class="grid-item">Add Questions</div></a>
			<a href="./systemuserreport.jsp"><div class="grid-item">System Admin Report</div></a>
			<a href="./studentreport.jsp"><div class="grid-item">Student Report</div></a>
			<a href="./ongoingpapers.jsp"><div class="grid-item">Ongoing Papers</div></a>
		</div>
		</div>
		
	</div>
</body>
</html>