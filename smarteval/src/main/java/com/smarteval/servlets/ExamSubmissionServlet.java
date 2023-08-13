package com.smarteval.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smarteval.database.DataStore;
import com.smarteval.entities.Users;

/**
 * Servlet implementation class ExamSubmissionServlet
 */
@WebServlet("/examsubmission")
public class ExamSubmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamSubmissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Map<String, String[]> parameters = request.getParameterMap();
//		System.out.println(parameters.size());
		
		HttpSession session = request.getSession(false);
		
		Users user = DataStore.retriveUserByUserName((String)session.getAttribute("username"));
		Integer userID=user.getUserID();
		Integer noOfQuestions = Integer.parseInt(request.getParameter("noofquestions"));
		Integer examID = Integer.parseInt(request.getParameter("examid"));
		Integer paperID = Integer.parseInt(request.getParameter("paperid"));
		String[] answersWithQuestions = new String[noOfQuestions];
		Integer[] questionID = new Integer[noOfQuestions];
		String[] answers = new String[noOfQuestions];
		
		for(int i=1; i<=noOfQuestions; i++) {
			answersWithQuestions[i-1] = request.getParameter("question"+i);
		}
		
		for(int i=0; i<answersWithQuestions.length; i++) {
			questionID[i] = Integer.parseInt(answersWithQuestions[i].split(",,")[0]);
			answers[i] = answersWithQuestions[i].split(",,")[1];
		}
		
		for(int i=0; i<answersWithQuestions.length; i++) {
			DataStore.insertAnswer(userID,examID,paperID,questionID[i],answers[i]);
		}
		
		DataStore.insertStudentsResult(userID, paperID, questionID, answers, noOfQuestions);
		response.sendRedirect(request.getContextPath()+"/studentresult.jsp");
		
//		for(String parameter : parameters.keySet()) {
//		    if(parameter.toLowerCase().startsWith("question")) {
//		        
//		    }
//		    String[] values = parameters.get(parameter);
//		}
		
		//we can get the data of an object by
		//entry.getValue()[0]
		//then we can convert it to String
		
//		for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
//		    System.out.println(entry.getKey().replace("question", "") + ":" + (String)entry.getValue()[0]);
//		}
		
		//map traversal technique java 8
//		parameters.forEach((key, value) -> System.out.println(key + ":" + value));
	}
}