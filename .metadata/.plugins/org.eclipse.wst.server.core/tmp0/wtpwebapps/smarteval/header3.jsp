<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SmartEval - Student Header</title>
</head>
<body>
	<%
	if(session.getAttribute("username")==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	%>
	<div class="header3">
		<h1>SmartEval</h1>
		<div class="option-list">
			<div class="dashboard">
				<a href="./studentdashboard.jsp">
					<div>Dashboard</div>
				</a>
			</div>
			<div class="exampapers">
				<a href="./exampapers.jsp">
					<div>Exam Papers</div>
				</a>
			</div>
			<div class="studentresult">
				<a href="./studentresult.jsp">
					<div>My Result</div>
				</a>
			</div>
			<div class="studentaccount">
				<a href="./studentaccount.jsp">
					<div>My Account</div>
				</a>
			</div>

			<div class="changepassword">
				<a href="./studentchangepassword.jsp">
					<div>Change Password</div>
				</a>
			</div>
			<div class="logout">
				<a href="<%=request.getContextPath()%>/logout"> <img src="./IMG/logout.png">
					<div>Logout</div>
				</a>
			</div>
		</div>
	</div>
</body>
</html>