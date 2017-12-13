package com.pratik.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pratik.DAO.StudentDao;
import com.pratik.DAO.StudentDaoFactory;
import com.pratik.DTO.StudentDTO;

public class EditFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, 
				HttpServletResponse response) throws ServletException,IOException {
					response.setContentType("text/html");
						PrintWriter out = response.getWriter();

						String sid = request.getParameter("sid");

						StudentDao dao =StudentDaoFactory.getStudentDao();
							StudentDTO sto = dao.getStudent(sid);

		if(sto == null) {
				RequestDispatcher requestDispatcher= request.getRequestDispatcher("/notexisted.html");
					requestDispatcher.forward(request,response);
			}
		else {
				out.println("<html>");
					out.println("<body bgcolor='lightblue'>");
						out.println("<form method = 'POST'action='./update'");
							out.println("<center>");
								out.println("<br><br><br>");
									out.println("<table bgcolor='white'>");
										out.println("<tr><td>Student Id</td><td>"+sto.getSid()+"</td></tr>");
											out.println("<input type='hidden' name='sid' value='"+sid+"'/>");
										out.println("<tr><td>Student Name</td><td><input type='text' name='sname' value='"+sto.getSname()+"'/></td></tr>");
										out.println("<tr><td>Student Result</td><td><input type='text' name='sresult' value='"+sto.getSresult()+"'/></td></tr>");
								out.println("<tr><td><input type='submit' value='Update'/></td></tr>");
						out.println("</table></center></form></body></html>");
					}

			}

	}
