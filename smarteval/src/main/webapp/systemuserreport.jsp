<%@page import="com.smarteval.entities.Users"%>
<%@page import="com.smarteval.database.DataStore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SmartEval - User report</title>
<link rel="stylesheet" href="./CSS/index.css">
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
	<div class="user-report">
		<jsp:include page="header2.jsp" />

		<div class="user-report-container">
		<%DataStore.retriveAll("users");%>
			<h1>System Admin Report</h1>
			<br>

			<TABLE class="whole">
				<TR>
					<TH>ID</TH>
					<TH>First Name</TH>
					<TH>Last Name</TH>
					<TH>Email ID</TH>
					<TH>Phone Number</TH>
					<TH>Username</TH>
				</TR>
				<% for(Users u : DataStore.allUsers){ %>
					<% if(u.getRoleID() == 1){ %>
						<TR>
							<td><%=u.getUserID()%></td>
							<td><%=u.getFirstName()%></td>
							<td><%=u.getLastName()%></td>
							<td><%=u.getEmail()%></td>
							<td><%=u.getPhoneNumber()%></td>
							<td><%=u.getUsername()%></td>
						</TR>
					<% } %>
				<% } %>
			</TABLE>
		</div>
	</div>

</body>
</html>