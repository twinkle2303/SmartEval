<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./CSS/index.css">
<title>SmartEval - Add Exam</title>
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
	<div class="add-exam">
		<jsp:include page="header2.jsp" />
		<form action="addexam" method="POST">
			<div class="add-exam-container">
				<h1>Add Exam</h1>
				<hr>
				<br> <label for="date"><b>Exam Date</b></label> <input
					type="date" placeholder="Select Exam Date" name="date" id="date"
					required> <br>
				<br> <label for="exam"><b>Exam Name</b></label> <input
					type="text" placeholder="Enter Exam Name" name="exam" id="examname"
					required> <br>
				<br> <label for="description"><b> Exam Description</b></label>
				<input type="text" placeholder="Enter Details about the exam"
					name="description" id="description" required> <br>
				<br>
				<%if(request.getAttribute("examInMsg")!=null){%>
					<div class="message-for-user-divs">
						<%=request.getAttribute("examInMsg")%>
					</div>
				<%} %>
				<button type="submit" class="submitbtn">Add</button>
			</div>
		</form>
	</div>
</body>