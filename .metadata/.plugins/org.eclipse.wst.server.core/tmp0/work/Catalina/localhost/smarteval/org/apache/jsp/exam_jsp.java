/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.71
 * Generated at: 2023-07-25 15:32:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Set;
import java.util.LinkedHashSet;
import java.sql.ResultSet;
import com.smarteval.entities.ExamQuestions;
import com.smarteval.entities.QuestionOA;
import com.smarteval.database.DataStore;

public final class exam_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("com.smarteval.database.DataStore");
    _jspx_imports_classes.add("com.smarteval.entities.QuestionOA");
    _jspx_imports_classes.add("java.util.Set");
    _jspx_imports_classes.add("com.smarteval.entities.ExamQuestions");
    _jspx_imports_classes.add("java.util.LinkedHashSet");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>SmartEval - Exam</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./CSS/index.css\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");

	if(session.getAttribute("username")==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	
      out.write('\r');
      out.write('\n');
      out.write('	');

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
	
      out.write("\r\n");
      out.write("	<div class=\"exam-portal\">\r\n");
      out.write("		<div class=\"exam-portal-container\">\r\n");
      out.write("			");
if(allExamQuestions.isEmpty()) {
      out.write("\r\n");
      out.write("			<h1>Some Internal Error Occurred!<br>\r\n");
      out.write("				Please Try Again After Sometime!<br>\r\n");
      out.write("				Questions not found!</h1>\r\n");
      out.write("			");
}else{ 
      out.write("\r\n");
      out.write("    			<p>Tab switched for <span id=\"tab-count\">0</span> times \r\n");
      out.write("<!--     			for a total duration of <span id=\"tab-duration\">0</span> ms.</p> -->\r\n");
      out.write("				<div class=\"timer\">				\r\n");
      out.write("				<h1><i class=\"material-icons\">alarm</i>\r\n");
      out.write("					<span id=\"time\">H:MM:SS</span></h1>\r\n");
      out.write("				</div>\r\n");
      out.write("				<form action=\"examsubmission\" method=\"GET\">\r\n");
      out.write("					");

					for(ExamQuestions eQ : allExamQuestions){
					
      out.write("\r\n");
      out.write("					<div class=\"question\">\r\n");
      out.write("					<h3>Question: ");
      out.print(eQ.getQuestion());
      out.write("</h3>\r\n");
      out.write("					<ul class=\"choices\">\r\n");
      out.write("						<li>\r\n");
      out.write("						    <label>\r\n");
      out.write("					    		<input type=\"radio\" name=\"");
      out.print("question"+questionCounter);
      out.write("\" value=\"");
      out.print(eQ.getQuestionID()+",,"+eQ.getOption1());
      out.write("\" required/>\r\n");
      out.write("					    		<span>");
      out.print(eQ.getOption1());
      out.write("</span>\r\n");
      out.write("					    	</label>\r\n");
      out.write("						</li>\r\n");
      out.write("						<li>\r\n");
      out.write("						    <label>\r\n");
      out.write("					    		<input type=\"radio\" name=\"");
      out.print("question"+questionCounter);
      out.write("\" value=\"");
      out.print(eQ.getQuestionID()+",,"+eQ.getOption2());
      out.write("\" required/>\r\n");
      out.write("					    		<span>");
      out.print(eQ.getOption2());
      out.write("</span>\r\n");
      out.write("					    	</label>\r\n");
      out.write("						</li>\r\n");
      out.write("						<li>\r\n");
      out.write("						    <label>\r\n");
      out.write("					    		<input type=\"radio\" name=\"");
      out.print("question"+questionCounter);
      out.write("\" value=\"");
      out.print(eQ.getQuestionID()+",,"+eQ.getOption3());
      out.write("\" required/>\r\n");
      out.write("					    		<span>");
      out.print(eQ.getOption3());
      out.write("</span>\r\n");
      out.write("					    	</label>\r\n");
      out.write("						</li>\r\n");
      out.write("						<li>\r\n");
      out.write("						    <label>\r\n");
      out.write("					    		<input type=\"radio\" name=\"");
      out.print("question"+questionCounter);
      out.write("\" value=\"");
      out.print(eQ.getQuestionID()+",,"+eQ.getOption4());
      out.write("\" required/>\r\n");
      out.write("					    		<span>");
      out.print(eQ.getOption4());
      out.write("</span>\r\n");
      out.write("					    	</label>\r\n");
      out.write("						</li>\r\n");
      out.write("					</ul>\r\n");
      out.write("					</div>\r\n");
      out.write("					");
	
					questionCounter++;	
					} 
					
      out.write("\r\n");
      out.write("					<input type=\"hidden\" name=\"examid\" value=\"");
      out.print(examID);
      out.write("\">\r\n");
      out.write("					<input type=\"hidden\" name=\"paperid\" value=\"");
      out.print(paperID);
      out.write("\">\r\n");
      out.write("					<input type=\"hidden\" name=\"noofquestions\" value=\"");
      out.print(noOfQuestions);
      out.write("\">\r\n");
      out.write("					<button type=\"submit\" value=\"");
      out.print(noOfQuestions*100*10*60);
      out.write("\" id=\"questionsubmitbtn\" class=\"questionsubmitbtn\" >Submit</button>\r\n");
      out.write("				</form>\r\n");
      out.write("			");
} 
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("    <script type = \"text/javascript\" >\r\n");
      out.write("        var questionsubmitbtn = document.getElementById(\"questionsubmitbtn\");\r\n");
      out.write("        var millis = questionsubmitbtn.value;\r\n");
      out.write("        function questionsubmitbtn_Run() { \r\n");
      out.write("        	 var submitInterval = setInterval(function() {\r\n");
      out.write("            	questionsubmitbtn.click();\r\n");
      out.write("            }, questionsubmitbtn.value);\r\n");
      out.write("        }\r\n");
      out.write("        questionsubmitbtn_Run();\r\n");
      out.write("        \r\n");
      out.write("        var time = document.getElementById(\"time\");\r\n");
      out.write("        function displaytimer(){\r\n");
      out.write("            var hours = Math.floor(millis / 36e5),\r\n");
      out.write("                mins = Math.floor((millis % 36e5) / 6e4),\r\n");
      out.write("                secs = Math.floor((millis % 6e4) / 1000);\r\n");
      out.write("            if(mins>10&&secs>10){\r\n");
      out.write("            	time.innerHTML = hours+\":\"+mins+\":\"+secs;\r\n");
      out.write("            }\r\n");
      out.write("            else if(mins<10&&secs>10){\r\n");
      out.write("            	time.innerHTML = hours+\":0\"+mins+\":\"+secs;\r\n");
      out.write("            }\r\n");
      out.write("            else if(mins>10&&secs<10){\r\n");
      out.write("            	time.innerHTML = hours+\":\"+mins+\":0\"+secs;\r\n");
      out.write("            }\r\n");
      out.write("            else if(mins<10&&secs<10){\r\n");
      out.write("            	time.innerHTML = hours+\":0\"+mins+\":0\"+secs;\r\n");
      out.write("            }\r\n");
      out.write("            if(millis<0){\r\n");
      out.write("            	clearInterval(timerInterval);\r\n");
      out.write("            	clearInterval(submitInterval);\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        var timerInterval = setInterval(function(){\r\n");
      out.write("            millis -= 1000;\r\n");
      out.write("            displaytimer();\r\n");
      out.write("        }, 1000);\r\n");
      out.write("        \r\n");
      out.write("        //tab change detection\r\n");
      out.write("		function preventBack() { window.history.forward(); }\r\n");
      out.write("		setTimeout(\"preventBack()\", 0);\r\n");
      out.write("		window.onunload = function () { null };\r\n");
      out.write("		\r\n");
      out.write("		let tabCount =0;\r\n");
      out.write("		let startTime =0;\r\n");
      out.write("		let duration = 0;\r\n");
      out.write("\r\n");
      out.write("		const tabCountElement = document.getElementById(\"tab-count\");\r\n");
      out.write("		const durationElement = document.getElementById(\"tab-duration\");\r\n");
      out.write("\r\n");
      out.write("		// Listen for the visibilitychange event\r\n");
      out.write("		document.addEventListener(\"visibilitychange\", function(){\r\n");
      out.write("		    if(document.hidden){\r\n");
      out.write("		    // Tab switched or minimized\r\n");
      out.write("		        duration += Date.now() - startTime;\r\n");
      out.write("		    	document.title = \"Don't change tab if you change for 3 time exam will end\"\r\n");
      out.write("		    }\r\n");
      out.write("		    else{\r\n");
      out.write("		    // Tab active again\r\n");
      out.write("		        tabCount++;\r\n");
      out.write("		        startTime = Date.now();\r\n");
      out.write("		        document.title = 3-tabCount+\" times left.\";\r\n");
      out.write("		    }\r\n");
      out.write("		    if(tabCount == 4){\r\n");
      out.write("		    	questionsubmitbtn.click();\r\n");
      out.write("		    }\r\n");
      out.write("		    tabCountElement.textContent = tabCount;\r\n");
      out.write("		    durationElement.textContent = duration;\r\n");
      out.write("		})\r\n");
      out.write("\r\n");
      out.write("		// Listen for the beforeunload event to record final duration\r\n");
      out.write("		window.addEventListener(\"beforeunload\", function() {\r\n");
      out.write("		    duration += Date.now() - startTime;\r\n");
      out.write("		    tabCountElement.textContent = tabCount;\r\n");
      out.write("		    durationElement.textContent = duration;\r\n");
      out.write("		});\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
