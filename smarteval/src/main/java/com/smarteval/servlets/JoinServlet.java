package com.smarteval.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smarteval.database.DataStore;
import com.smarteval.entities.Users;

/**
 * Servlet implementation class Join
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
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
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		Long phoneno = Long.parseLong(request.getParameter("phoneno"));
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		Integer roleID = Integer.parseInt(request.getParameter("loginas"));
		Integer examID = Integer.parseInt(request.getParameter("examname"));
		Integer rs = DataStore.insertUser(firstname,lastname,email,phoneno,username,password,roleID,examID);
		if(rs==1) {
			request.setAttribute("creationMsg", "Account Creation Successful!");
			request.getRequestDispatcher("/join.jsp").forward(request, response);
		}
		else if(rs==-1){
			request.setAttribute("creationMsg", "Account Creation Unsuccessful!");
			request.getRequestDispatcher("/join.jsp").forward(request, response);
		}
		else if(rs==-2){
			request.setAttribute("creationMsg", "Username Exist!<br>Account Creation Unsuccessful!");
			request.getRequestDispatcher("/join.jsp").forward(request, response);
		}
	}
}