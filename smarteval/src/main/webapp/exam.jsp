<%@page import="java.util.Set"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.smarteval.entities.ExamQuestions"%>
<%@page import="com.smarteval.entities.QuestionOA"%>
<%@page import="com.smarteval.database.DataStore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SmartEval - Exam</title>
<link rel="stylesheet" href="./CSS/index.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<%
	if(session.getAttribute("username")==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	%>
	<%
		Integer questionCounter=1;
		Integer noOfQuestions=0;
	  	Set<ExamQuestions> allExamQuestions = new LinkedHashSet<>();
		Integer examID=Integer.parseInt(request.getParameter("examid"));
		Integer paperID=Integer.parseInt(request.getParameter("paperid"));
		ResultSet rs = DataStore.retriveQuestionsByPaperIDANDExamID(examID, paperID);
		while(rs.next()){
			ExamQuestions eQ = new ExamQuestions(rs.getInt(1),rs.getInt(2),rs.getInt(3)
								,rs.getInt(4),rs.getString(5),rs.getString(6),
								rs.getString(7),rs.getString(8),rs.getString(9));
			allExamQuestions.add(eQ);
			noOfQuestions = rs.getInt(4);
		}
	%>
	<div class="exam-portal">
		<div class="exam-portal-container">
			<%if(allExamQuestions.isEmpty()) {%>
			<h1>Some Internal Error Occurred!<br>
				Please Try Again After Sometime!<br>
				Questions not found!</h1>
			<%}else{ %>
    			<p>Tab switched for <span id="tab-count">0</span> times 
<!--     			for a total duration of <span id="tab-duration">0</span> ms.</p> -->
				<div class="timer">				
				<h1><i class="material-icons">alarm</i>
					<span id="time">H:MM:SS</span></h1>
				</div>
				<form action="examsubmission" method="GET">
					<%
					for(ExamQuestions eQ : allExamQuestions){
					%>
					<div class="question">
					<h3>Question: <%=eQ.getQuestion()%></h3>
					<ul class="choices">
						<li>
						    <label>
					    		<input type="radio" name="<%="question"+questionCounter%>" value="<%=eQ.getQuestionID()+",,"+eQ.getOption1()%>" required/>
					    		<span><%=eQ.getOption1()%></span>
					    	</label>
						</li>
						<li>
						    <label>
					    		<input type="radio" name="<%="question"+questionCounter%>" value="<%=eQ.getQuestionID()+",,"+eQ.getOption2()%>" required/>
					    		<span><%=eQ.getOption2()%></span>
					    	</label>
						</li>
						<li>
						    <label>
					    		<input type="radio" name="<%="question"+questionCounter%>" value="<%=eQ.getQuestionID()+",,"+eQ.getOption3()%>" required/>
					    		<span><%=eQ.getOption3()%></span>
					    	</label>
						</li>
						<li>
						    <label>
					    		<input type="radio" name="<%="question"+questionCounter%>" value="<%=eQ.getQuestionID()+",,"+eQ.getOption4()%>" required/>
					    		<span><%=eQ.getOption4()%></span>
					    	</label>
						</li>
					</ul>
					</div>
					<%	
					questionCounter++;	
					} 
					%>
					<input type="hidden" name="examid" value="<%=examID%>">
					<input type="hidden" name="paperid" value="<%=paperID%>">
					<input type="hidden" name="noofquestions" value="<%=noOfQuestions%>">
					<button type="submit" value="<%=noOfQuestions*100*10*60%>" id="questionsubmitbtn" class="questionsubmitbtn" >Submit</button>
				</form>
			<%} %>
		</div>
	</div>
	
    <script type = "text/javascript" >
        var questionsubmitbtn = document.getElementById("questionsubmitbtn");
        var millis = questionsubmitbtn.value;
        function questionsubmitbtn_Run() { 
        	 var submitInterval = setInterval(function() {
            	questionsubmitbtn.click();
            }, questionsubmitbtn.value);
        }
        questionsubmitbtn_Run();
        
        var time = document.getElementById("time");
        function displaytimer(){
            var hours = Math.floor(millis / 36e5),
                mins = Math.floor((millis % 36e5) / 6e4),
                secs = Math.floor((millis % 6e4) / 1000);
            if(mins>10&&secs>10){
            	time.innerHTML = hours+":"+mins+":"+secs;
            }
            else if(mins<10&&secs>10){
            	time.innerHTML = hours+":0"+mins+":"+secs;
            }
            else if(mins>10&&secs<10){
            	time.innerHTML = hours+":"+mins+":0"+secs;
            }
            else if(mins<10&&secs<10){
            	time.innerHTML = hours+":0"+mins+":0"+secs;
            }
            if(millis<0){
            	clearInterval(timerInterval);
            	clearInterval(submitInterval);
            }
        }
        var timerInterval = setInterval(function(){
            millis -= 1000;
            displaytimer();
        }, 1000);
        
        //tab change detection
		function preventBack() { window.history.forward(); }
		setTimeout("preventBack()", 0);
		window.onunload = function () { null };
		
		let tabCount =0;
		let startTime =0;
		let duration = 0;

		const tabCountElement = document.getElementById("tab-count");
		const durationElement = document.getElementById("tab-duration");

		// Listen for the visibilitychange event
		document.addEventListener("visibilitychange", function(){
		    if(document.hidden){
		    // Tab switched or minimized
		        duration += Date.now() - startTime;
		    	document.title = "Don't change tab if you change for 3 time exam will end"
		    }
		    else{
		    // Tab active again
		        tabCount++;
		        startTime = Date.now();
		        document.title = 3-tabCount+" times left.";
		    }
		    if(tabCount == 4){
		    	questionsubmitbtn.click();
		    }
		    tabCountElement.textContent = tabCount;
		    durationElement.textContent = duration;
		})

		// Listen for the beforeunload event to record final duration
		window.addEventListener("beforeunload", function() {
		    duration += Date.now() - startTime;
		    tabCountElement.textContent = tabCount;
		    durationElement.textContent = duration;
		});
    </script>
</body>
</html>