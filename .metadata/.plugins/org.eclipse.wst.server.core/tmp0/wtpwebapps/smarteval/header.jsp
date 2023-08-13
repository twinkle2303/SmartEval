<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SmartEval - Homepage Header</title>
</head>
<body>
	<%
	if(session.getAttribute("username")==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	%>
	<div class="header">
		<h1>SmartEval</h1>
		<div class="option-list">
			<div class="home">
				<a href="./index.jsp">
					<div>Home</div>
				</a>

			</div>
			<div class="about-us">
				<a href="./aboutus.jsp">
					<div>About Us</div>
				</a>
			</div>
			<div class="login">
				<a href="./login.jsp">
					<div>Login</div>
				</a>

			</div>
			<div class="join">
				<a href="./join.jsp">
					<div>Join</div>
				</a>
			</div>
			
		</div>
	</div>
</body>
</html>