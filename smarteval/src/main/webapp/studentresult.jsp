<%@page import="com.smarteval.entities.StudentsResult"%>
<%@page import="com.smarteval.database.DataStore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./CSS/index.css">
<title>SmartEval - My Result</title>
</head>
<body>
	<%
	if(session.getAttribute("username")==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	%>
	<%DataStore.retriveStudentsResults();
	Boolean flag=false;
	String username = (String)session.getAttribute("username");
	if(!DataStore.allStudentsResults.isEmpty()){
		for(StudentsResult sr : DataStore.allStudentsResults){
			if(sr.getUsername().equals(username)){
				flag=true;
				break;
			}
		}
	}
	%>	
	<div class="student-result">
		<jsp:include page="header3.jsp" />
		<div class="student-result-container">
			<%if(flag==false){%>
				<h1>No Results available!</h1>
			<%} else {%>
			<h1>My Result</h1><br>
			
			<TABLE class="whole">
				<TR>
					<TH>Paper Name</TH>
					<TH>Marks</TH>
				</TR>
				<%for(StudentsResult sr : DataStore.allStudentsResults) {
					if(sr.getUsername().equals(username)){	
				%>
					<TR>
						<td><%=sr.getSubject() %></td>
						<td><%=sr.getMarks() %></td>
					</TR>
				<%}}%>		
				</TABLE>
			<%} %>
		</div>
		
	</div>

</body>
</html>