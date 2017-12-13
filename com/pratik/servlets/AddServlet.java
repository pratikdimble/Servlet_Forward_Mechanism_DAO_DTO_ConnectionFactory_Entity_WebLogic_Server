package com.pratik.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pratik.DAO.StudentDao;
import com.pratik.DAO.StudentDaoFactory;

public class AddServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {

	String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
			String saddr = request.getParameter("saddr");

			StudentDao dao =StudentDaoFactory.getStudentDao();
				String status = dao.add(sid, sname, saddr);
					RequestDispatcher req_Dispatcher = null;
						if(status.equals("success")) 
							{
								req_Dispatcher = request.getRequestDispatcher("/success.html");
									req_Dispatcher.forward(request,response);
							}
						if(status.equals("failure")) 
						{
							req_Dispatcher =request.getRequestDispatcher("/failure.html");
								req_Dispatcher.forward(request,response);
						}
							if(status.equals("existed")) 
							{
								req_Dispatcher = request.getRequestDispatcher("/existed.html");
									req_Dispatcher.forward(request, response);
							}
			}
	}

