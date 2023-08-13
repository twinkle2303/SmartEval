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
<title>SmartEval - Student Report</title>
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
	<%DataStore.retriveAll("users");
	  DataStore.retriveAll("examinations");
	%>
	<div class="student-report">
		<jsp:include page="header2.jsp" />
		<div class="student-report-container">
			<%if(DataStore.allUsers.isEmpty()){%>
				<h1>No student available!</h1>
			<%} else {%>
			<h1>Student Report</h1>
			<br>

			<TABLE class="whole">
				<TR>
					<TH>Student ID</TH>
					<TH>First Name</TH>
					<TH>Last Name</TH>
					<TH>Email ID</TH>
					<TH>Phone Number</TH>
					<TH>Username</TH>
					<TH>ExamID</TH>
				</TR>
				<% for(Users u : DataStore.allUsers){ %>
					<% if(u.getRoleID() == 2){ %>
						<TR>
							<td><%=u.getUserID()%></td>
							<td><%=u.getFirstName()%></td>
							<td><%=u.getLastName()%></td>
							<td><%=u.getEmail()%></td>
							<td><%=u.getPhoneNumber()%></td>
							<td><%=u.getUsername()%></td>
							<%for(Examination e: DataStore.allExaminations){
								if(e.getExamID()==u.getExamID()){
							%>
								<td><%=e.getExamName()%></td>
							<%}} %>
						</TR>
					<% } %>
				<% } %>
			</TABLE>
			<%} %>
		</div>
	</div>

</body>
</html>