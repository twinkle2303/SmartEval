
<%@page import="com.smarteval.entities.Category"%>
<%@page import="com.smarteval.database.DataStore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./CSS/index.css">
<title>SmartEval - Add Question</title>
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
	<%DataStore.retriveAll("categories");%>
	<div class="add-question">
		<jsp:include page="header2.jsp" />
		<form action="addquestion" method="POST">
			<div class="add-question-container">
				<h1>Add Question</h1>
				<hr>
				<br> 
				<label for="question"><b>Question</b></label> 
				<input type="text" placeholder="Enter Question" name="question" id="question" required> 
				<label for="option1"><b>Option 1</b></label> 
				<input type="text" placeholder="Enter Option 1" name="option1" id="option1" required> 
				<label for="option2"><b>Option 2</b></label> 
				<input type="text" placeholder="Enter Option 2" name="option2" id="option2" required> 
				<label for="option3"><b>Option 3</b></label> 
				<input type="text" placeholder="Enter Option 3" name="option3" id="option3" required> 
				<label for="option4"><b>Option 4</b></label> 
				<input type="text" placeholder="Enter Option 4" name="option4" id="option4" required> 
				<label for="answer"><b>Answer</b></label>
				<input type="text" placeholder="Enter Answer" name="answer" id="answer" required> <br> 
				<label for="subject"><b>Subject</b></label>
				<select id="subject" name="subject">
					<%for(Category c : DataStore.allCategories){ %>
						<option value="<%=c.getCategoryID()%>"><%=c.getCategoryName()%></option>
					<%} %>
				</select> 
				<br>
				<%if(request.getAttribute("questionInMsg")!=null){%>
					<div class="message-for-user-divs">
						<%=request.getAttribute("questionInMsg")%>
					</div>
				<%} %>
				<button type="submit" class="submitbtn">Add Question</button>
			</div>
		</form>
	</div>
</body>
</html>