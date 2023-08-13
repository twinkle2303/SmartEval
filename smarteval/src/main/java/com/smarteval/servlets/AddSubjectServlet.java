package com.smarteval.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smarteval.database.DataStore;

/**
 * Servlet implementation class AddSubjectServlet
 */
@WebServlet("/addsubject")
public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubjectServlet() {
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
		String subject = request.getParameter("subject");
		Integer rs = DataStore.insertCategory(subject);
		if(rs==1) {
			request.setAttribute("subjectInMsg", "New Subject Added Successfully!");
			request.getRequestDispatcher("/addsubject.jsp").forward(request, response);
		}
		else if(rs==-1){
			request.setAttribute("subjectInMsg", "New Subject Addition Unsuccessful!");
			request.getRequestDispatcher("/addsubject.jsp").forward(request, response);
		}
	}

}
