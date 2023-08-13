<%@page import="com.smarteval.entities.OngoingPapers"%>
<%@page import="com.smarteval.database.DataStore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./CSS/index.css">
<title>SmartEval - Ongoing Papers</title>
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
	<%DataStore.retriveOngoingPapers();%>
	<div class="ongoing-papers">
		<jsp:include page="header2.jsp" />
		<div class="ongoing-papers-container">
			<%if(DataStore.allOngoingPapers.isEmpty()){%>
			<h1>No Paper available!</h1>
			<%} else {%>
			<h1>Ongoing Papers</h1>
			<TABLE class="whole">
				<TR>
					<TH>Exam Name</TH>
					<TH>Paper Name</TH>
					<TH>Paper Date</TH>
				</TR>
				<%for(OngoingPapers op: DataStore.allOngoingPapers) {%>
					<TR>
						<td><%=op.getExamName()%></td>
						<td><%=op.getPaperName()%></td>
						<td><%=op.getPaperDate() %></td>
					</TR>
				<%} %>
				
			</TABLE>
		</div>
		<%} %>
	</div>

</body>
</html>