package com.smarteval.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smarteval.database.DataStore;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/changepassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
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
		HttpSession session=request.getSession(false);
		String username = (String) session.getAttribute("username");
		Integer role = (Integer) session.getAttribute("role");
		String op = request.getParameter("op");
		String np = request.getParameter("np");
		if(DataStore.updateUserByUsernamePassword(username, op, np) == 1) {
			request.setAttribute("changePasswordMsg", "Password Changed Successfully!");
			if(role==1) {
				request.getRequestDispatcher("/adminchangepassword.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/studentchangepassword.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("changePasswordMsg", "Incorrect Password!");
			if(role==1) {
				request.getRequestDispatcher("/adminchangepassword.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/studentchangepassword.jsp").forward(request, response);
			}
		}
	}
}