package com.smarteval.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smarteval.database.DataStore;

/**
 * Servlet implementation class AddExamServlet
 */
@WebServlet("/addexam")
public class AddExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("date");
		String exam = request.getParameter("exam");
		String description = request.getParameter("description");
		Integer rs = DataStore.insertExaminations(date,exam,description);
		if(rs==1) {
			request.setAttribute("examInMsg", "New Exam Added Successfully!");
			request.getRequestDispatcher("/addexam.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath()+"/addexam.jsp");
		}
		else if(rs==-1){
			request.setAttribute("examInMsg", "New Exam Addition Unsuccessful!");
			request.getRequestDispatcher("/addexam.jsp").forward(request, response);
		}
	}

}
