<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./CSS/index.css">
<title>SmartEval - Login</title>
</head>
<body>
	<div class="loginpage">
		<jsp:include page="header.jsp" />
		<div class="login-container">
			<form action="login" method="POST">
				<h1>Login</h1>
				<p>Enter your details to sign in to your account</p>
				<label for="uname"><b>Username</b></label> <input type="text"
					placeholder="Enter Username" name="uname" required> <label
					for="psw"><b>Password</b></label> <input type="password"
					placeholder="Enter Password" name="psw" required>    
				<button type="submit">Login</button>
				<%if(request.getAttribute("loginerrormessage")!=null){%>
					<div class="message-for-user-divs">
						<%=request.getAttribute("loginerrormessage")%>
					</div>
				<%}%>
				<p>Don't have an account? <strong><a href="./join.jsp">Join!</a></strong></p>
			</form>
		</div>
	</div>
</body>
</html>