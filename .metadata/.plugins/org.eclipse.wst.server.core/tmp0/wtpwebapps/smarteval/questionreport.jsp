<%@page import="com.smarteval.entities.QuestionOA"%>
<%@page import="com.smarteval.database.DataStore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./CSS/index.css">
<title>SmartEval - Question Report</title>
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
	<%DataStore.retriveQuestionsWithCategories();%>
	<div class="question-report">
		<jsp:include page="header2.jsp" />

		<div class="question-report-container">
			<h1>Question Bank</h1>
			<br>

			<TABLE class="whole">
				<TR>
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
	</div>

</body>
</html>