<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./CSS/index.css">
<title>SmartEval - Add Subjects</title>
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
	<div class="add-question">
		<jsp:include page="header2.jsp" />
		<form action="addsubject" method="POST">
			<div class="add-question-container">
				<h1>Add Subjects</h1>
				<hr>
				<br>
				<label for="subject"><b>Subject</b></label>
				<input type="text" placeholder="Enter Subject" name="subject"
				id="subject" required>
				<%if(request.getAttribute("subjectInMsg")!=null){%>
					<div class="message-for-user-divs">
						<%=request.getAttribute("subjectInMsg")%>
					</div>
				<%} %>
				<button type="submit" class="submitbtn">Add Subject</button>
			</div>
		</form>
	</div>
</body>
</html>