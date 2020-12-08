package com.vwits.controller.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutStudent
 */
@WebServlet("/LogoutStudent")
public class LogoutStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Session is invalidated here
		 */
		HttpSession session = request.getSession(false);
		
		String studentid=null;
		if(session != null) {
			studentid = (String)session.getAttribute("studentid");

			if(studentid != null) {
				session.invalidate();
				RequestDispatcher r = request.getRequestDispatcher("StudentLogin.jsp");
				r.forward(request, response);
				
			}
			
		}
		
	}

}
