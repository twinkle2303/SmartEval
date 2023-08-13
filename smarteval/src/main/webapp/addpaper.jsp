<%@page import="com.smarteval.entities.QuestionOA"%>
<%@page import="com.smarteval.entities.Examination"%>
<%@page import="com.smarteval.entities.Category"%>
<%@page import="com.smarteval.database.DataStore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./CSS/index.css">
<title>SmartEval - Add Paper</title>
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
	<%  DataStore.retriveAll("categories");
		DataStore.retriveAll("examinations");
		DataStore.retriveQuestionsWithCategories();
	%>
	<div class="add-paper">
		<jsp:include page="header2.jsp" />
		<div class="add-paper-container">
		<form action="addpaper" method="GET">
			<h1>Add Paper</h1>
			<hr>
			<br>
			<label for="exam"><b>Exam Name </b></label>
			<select id="examname" name="examname">
				<%for(Examination e: DataStore.allExaminations) {%>
					<option value="<%=e.getExamID()%>"><%=e.getExamName()%></option>
				<%} %>
			</select>
			<br>
			<br> 
			<label for="subject"><b>Subject</b></label> 
			<select id="subject" name="subject">
				<%for(Category c : DataStore.allCategories){ %>
					<option value="<%=c.getCategoryID()%>"><%=c.getCategoryName()%></option>
				<%} %>
			</select>
			<br>
			<br>
			<label for="date"><b>Paper Valid till</b></label> 
			<input type="date" placeholder="Enter Exam Date" name="date" id="date" required>
			<br>
			<br> <label for="description"><b>Paper Description</b></label>
			<input type="text" placeholder="Enter Details about the exam" name="description" id="description" required> 
			<br>
			<div class="question-addpaper-container">
				<h1>Question Bank</h1>
				<br>
	
				<TABLE class="addpaper-whole">
					<TR>
						<TH></TH>
						<TH>Question</TH>
						<TH>Option A</TH>
						<TH>Option B</TH>
						<TH>Option C</TH>
						<TH>Option D</TH>
						<TH>Answer</TH>
						<TH>Subject</TH>
					</TR>
					<% for(QuestionOA qoa: DataStore.allQuestionsWithCategory) {%>
					<TR>
						<td>
							<input type="checkbox" name="question<%=qoa.getQuestionID()%>" value="<%=qoa.getQuestionID()%>">
						</td>
						<td><%=qoa.getQuestion()%></td>
						<td><%=qoa.getOption1()%></td>
						<td><%=qoa.getOption2() %></td>
						<td><%=qoa.getOption3() %></td>
						<td><%=qoa.getOption4() %></td>
						<td><%=qoa.getAnswer()%></td>
						<td><%=qoa.getCatergoryName()%></td>
					</TR>
					<% } %>
				</TABLE>
			</div>
			<br>
			<button type="submit" class="addpaper-submitbtn">Add</button>
		</form>
		</div>
	</div>
</body>
</html>