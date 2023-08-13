<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SmartEval - Change Password</title>
</head>
<body>
	<%
		if(session.getAttribute("username")==null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	%>
	<div class="change-password-container">
		<form action="changepassword" method="POST">
			<h1>Change Password</h1>
			<label for="op"><b>Old Password</b></label> 
			<input type="password" placeholder="Enter Old password" name="op" required>
			<label for="np"><b>New Password</b></label>
			<input type="password" placeholder="Enter New Password" name="np" required>    
			<%if(request.getAttribute("changePasswordMsg")!=null){%>
				<div class="message-for-user-divs">
					<%=request.getAttribute("changePasswordMsg")%>
				</div>
			<%} %>	
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>