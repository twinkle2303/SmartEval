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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String uname = request.getParameter("uname");
		String password = request.getParameter("psw");

		HttpSession session = request.getSession();
		Integer role = DataStore.checkLogin(uname, password);
		if(role==1) 
		{
			session.setAttribute("username", uname);
			session.setAttribute("role", 1);
			request.getRequestDispatcher("/admindashboard.jsp").forward(request, response);
		}
		else if(role==2) 
		{
			session.setAttribute("username", uname);
			session.setAttribute("role", 2);
			request.getRequestDispatcher("/studentdashboard.jsp").forward(request, response);
		}
		else {
			request.setAttribute("loginerrormessage", "Incorrect Username/Password!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
