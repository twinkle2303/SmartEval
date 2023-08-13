<%@page import="com.smarteval.entities.Examination"%>
<%@page import="com.smarteval.entities.Users"%>
<%@page import="com.smarteval.database.DataStore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./CSS/index.css">
<title>SmartEval - My Account</title>
</head>
<body>
	<%
		if(session.getAttribute("username")==null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	%>
	<div class="student-account">
		<jsp:include page="header3.jsp" />
		<div class="student-account-container">
			<h1>My Account Details</h1>
			<hr>
			<br>
			<%
			DataStore.retriveAll("examinations");
			Users user = DataStore.retriveUserByUserName((String)session.getAttribute("username"));
			%>
			<p>
				<strong>User ID:</strong> <%=user.getUserID()%>
			</p>
			<br>
			<p>
				<strong>First Name:</strong> <%=user.getFirstName()%>
			</p>
			<br>
			<p>
				<strong>Last Name:</strong> <%=user.getLastName()%>
			</p>
			<br>
			<p>
				<strong>Email:</strong> <%=user.getEmail()%>
			</p>
			<br>
			<p>
				<strong>Phone number:</strong> <%=user.getPhoneNumber()%>
			</p>
			<br>
			<p>
				<strong>Username:</strong> <%=user.getUsername()%>
			</p>
			<br>
			<p>
				<%for(Examination e: DataStore.allExaminations){
					if(e.getExamID()==user.getExamID()){
				%>
					<strong>Examination:</strong> <%=e.getExamName()%>
				<%}} %>
			</p>
			<br>

		</div>
	</div>
</body>
</html>