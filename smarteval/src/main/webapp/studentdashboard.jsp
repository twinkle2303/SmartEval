<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./CSS/index.css">
<title>SmartEval - Student Dashboard</title>
</head>
<body>	
	<%
	if(session.getAttribute("username")==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	%>
	<div class="student-dashboard">
		<jsp:include page="header3.jsp" />
		<div class="student-page-container">
			<h1>Welcome <%=session.getAttribute("username") %>!</h1>
			<h2>Quick Links</h2>
		<div class="grid-container">
			<a href="./exampapers.jsp"><div class="grid-item">Exam Papers</div></a>
			<a href="./studentresult.jsp"><div class="grid-item">My Result</div></a>
			<a href="./studentaccount.jsp"><div class="grid-item">My Account</div></a>
			<!--  <a href="./currentrunningexams.jsp"><div class="grid-item">Current Running Exams</div></a>-->
		</div>
		</div>
		
	</div>

</body>
</html>