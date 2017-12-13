package com.pratik.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {

	response.setContentType("text/html");
		String uname = request.getParameter("uname");
			String upwd = request.getParameter("upwd");

				RequestDispatcher req_Dispatcher = null;
					if(uname.equals("system") && upwd.equals("oracle")) {
							req_Dispatcher = request.getRequestDispatcher("/success.html");
									req_Dispatcher.forward(request,response);
						}else {
								req_Dispatcher = request.getRequestDispatcher("failure.html");
									req_Dispatcher.forward(request, response);
							}
			}

	}