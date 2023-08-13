package com.smarteval.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smarteval.database.DataStore;

/**
 * Servlet implementation class AddQuestionServlet
 */
@WebServlet("/addquestion")
public class AddQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String question=request.getParameter("question");
		String option1=request.getParameter("option1");
		String option2=request.getParameter("option2");
		String option3=request.getParameter("option3");
		String option4=request.getParameter("option4");
		String answer=request.getParameter("answer");
		Integer subid=Integer.parseInt(request.getParameter("subject"));
		
		Integer rs = DataStore.insertQuestions(question,option1,option2,option3,option4,answer,subid);
		if(rs==1) {
			request.setAttribute("questionInMsg", "New Question Added Successfully!");
			request.getRequestDispatcher("/addquestion.jsp").forward(request, response);
		}
		else if(rs==-1){
			request.setAttribute("questionInMsg", "New Question Addition Unsuccessful!");
			request.getRequestDispatcher("/addquestion.jsp").forward(request, response);
		}
		//request.getRequestDispatcher("/addquestion.jsp").forward(request, response);;
		//response.sendRedirect(request.getContextPath()+"/addquestion.jsp");
	}

}
