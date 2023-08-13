<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SmartEval - Admin Header</title>
</head>
<body>
	<%
	if(session.getAttribute("username")==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	%>
	<div class="header2">
		<h1>SmartEval</h1>
		<div class="option-list">
			<div class="dashboard">
				<a href="./admindashboard.jsp">
					<div>Dashboard</div>
				</a>
			</div>
			<div class="dropdown add">
				<div class="dropbtn">Add</div>
				<div class="dropdown-content">
					<a href="./addexam.jsp">Add Examination</a> 
					<a href="./addpaper.jsp">Add Paper</a> 
					<a href="./addsubject.jsp">Add Subject</a> 
					<a href="./addquestion.jsp">Add Questions</a>
				</div>
			</div>
			<div class="dropdown reports">
				<div class="dropbtn">Reports</div>
				<div class="dropdown-content">
					<a href="./systemuserreport.jsp">System Admin Report</a> 
					<a href="./studentreport.jsp">Student Report</a>
					<a href="./ongoingpapers.jsp">Papers Report</a> 
					<a href="./questionreport.jsp">Questions Report</a>
				</div>
			</div>	
			<div class="changepassword">
				<a href="./adminchangepassword.jsp">
					<div>Change Password</div>
				</a>
			</div>
			<div class="logout">
				<a href="<%=request.getContextPath()%>/logout">
				<img src="./IMG/logout.png">
					<div>Logout</div>
				</a>
			</div>
		</div>
	</div>
</body>
</html>