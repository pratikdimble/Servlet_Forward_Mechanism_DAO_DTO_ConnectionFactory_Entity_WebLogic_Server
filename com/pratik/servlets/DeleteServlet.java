package com.pratik.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pratik.DAO.StudentDao;
import com.pratik.DAO.StudentDaoFactory;

public class DeleteServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {

	String sid = request.getParameter("sid");

	StudentDao dao = StudentDaoFactory.getStudentDao();
		String status = dao.delete(sid);
			RequestDispatcher requestDispatcher = null;
				if(status.equals("notexisted")) {
						requestDispatcher = request.getRequestDispatcher("/notexisted.html");
							requestDispatcher.forward(request, response);
					}
						if(status.equals("success")) {
								requestDispatcher = request.getRequestDispatcher("/success.html");
									requestDispatcher.forward(request, response);
							}
						if(status.equals("failure")) {
							requestDispatcher = request.getRequestDispatcher("/failure.html");
								requestDispatcher.forward(request, response);
							}

			}

}