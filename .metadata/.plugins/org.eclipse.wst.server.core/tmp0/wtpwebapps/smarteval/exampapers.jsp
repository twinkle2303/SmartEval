<%@page import="com.smarteval.entities.AnswerBank"%>
<%@page import="com.smarteval.entities.Users"%>
<%@page import="com.smarteval.entities.OngoingPapers"%>
<%@page import="com.smarteval.database.DataStore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./CSS/index.css">
<title>SmartEval - Exam Papers</title>
</head>
<body>
	<%
	if(session.getAttribute("username")==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	%>
	<%
		DataStore.retriveOngoingPapers(); 
		Users user = DataStore.retriveUserByUserName((String)session.getAttribute("username"));
		DataStore.retriveAll("answerbank");
		
	%>
	<div class="student-result">
		<jsp:include page="header3.jsp" />
		<div class="student-result-container">
			<%if(DataStore.allOngoingPapers.isEmpty()){ %>
				<h1>No Paper available!</h1>
			<%}else{ %>
			<TABLE class="whole">
				<TR>
					<TH>Exam Name</TH>
					<TH>Paper Name</TH>
					<TH>Paper Date</TH>
					<TH>Exam Link</TH>
				</TR>
				<%for(OngoingPapers op : DataStore.allOngoingPapers){%>
				<%if(op.getExamID() == user.getExamID()) {%>
					<%{%>
					<TR>
						<td><%=op.getExamName() %></td>
						<td><%=op.getPaperName() %></td>
						<td><%=op.getPaperDate() %></td>
						<td>
							<a href="./exam.jsp?examid=<%=op.getExamID()%>&paperid=<%=op.getPaperID()%>">
								Click here
							</a>
						</td>
					</TR>
					<%}%>
				<%} %>
				<%} %>
			<%} %>
			</TABLE>
		</div>
	</div>
	<script type = "text/javascript" >
		function preventBack() { window.history.forward(); }
		setTimeout("preventBack()", 0);
		window.onunload = function () { null };
	</script>
</body>
</html>