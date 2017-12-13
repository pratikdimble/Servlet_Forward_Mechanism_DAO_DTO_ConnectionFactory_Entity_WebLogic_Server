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

public class SearchServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

	String sid = request.getParameter("sid");
	//int sid=Integer.parseInt(id);

		StudentDao dao =StudentDaoFactory.getStudentDao();
			StudentDTO sto = dao.search(sid);
				if(sto == null) {
						RequestDispatcher requestDispatcher= request.getRequestDispatcher("/notexisted.html");
							requestDispatcher.forward(request,response);
				}else {
						out.println("<html>");
							out.println("<body bgcolor='lightblue'>");
								out.println("<center>");
									out.println("<br><br><br>");
										out.println("<table border='1' bgcolor='white'>");
											out.println("<tr><td>Student ID</td><td>"+sto.getSid()+"</td></tr>");
											out.println("<tr><td>Student Name</td><td>"+sto.getSname()+"</td></tr>");
											out.println("<tr><td>Student Result</td><td>"+sto.getSresult()+"</td></tr>");
							out.println("</table></center></body></html>");

}
}

}
