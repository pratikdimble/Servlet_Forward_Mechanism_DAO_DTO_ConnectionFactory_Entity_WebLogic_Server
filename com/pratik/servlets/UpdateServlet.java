package com.pratik.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pratik.DAO.StudentDao;
import com.pratik.DAO.StudentDaoFactory;
//import com.pratik.to.StudentTo;

public class UpdateServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String sid = request.getParameter("sid");
	String sname = request.getParameter("sname");
	String sresult = request.getParameter("sresult");

		StudentDao dao = StudentDaoFactory.getStudentDao();
			String status = dao.update(sid, sname, sresult);
				RequestDispatcher requestDispatcher = null;
					if(status.equals("success")) {
							requestDispatcher = request.getRequestDispatcher("/success.html");
								requestDispatcher.forward(request, response);
					}else {
						requestDispatcher = request.getRequestDispatcher("/failure.html");
							requestDispatcher.forward(request, response);
						}
			}

}