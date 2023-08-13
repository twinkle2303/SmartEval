package com.smarteval.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smarteval.database.DataStore;
import com.smarteval.entities.Category;

/**
 * Servlet implementation class AddPaper
 */
@WebServlet("/addpaper")
public class AddPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddPaper() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataStore.retriveAll("categories");
		Map<String, String[]> parameters = request.getParameterMap();
		Integer examid=Integer.parseInt(request.getParameter("examname"));
		Integer subjectid=Integer.parseInt(request.getParameter("subject"));
		String date=request.getParameter("date");
		String description=request.getParameter("description");
		Integer noOfQuestions=parameters.size()-4;
		String categoryName = "";
		
		for(Category c : DataStore.allCategories){ 
			if(c.getCategoryID() == subjectid) {
				categoryName = c.getCategoryName();
			}
		}
	    
	    DataStore.insertPapers(examid, categoryName, date, description, noOfQuestions);
	    Integer paperID = DataStore.maxOfPaperID();
	    
	    if(paperID>0) {
	    	for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
			    if(((String)entry.getKey()).charAt(0)=='q') {
			    	DataStore.insertSelectedQuestions(Integer.parseInt((String)entry.getValue()[0]),paperID);
			    }
			}
	    }
	    response.sendRedirect(request.getContextPath()+"/addpaper.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
