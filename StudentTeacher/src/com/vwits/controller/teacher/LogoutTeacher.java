package com.vwits.controller.teacher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutTeacher
 */
@WebServlet("/LogoutTeacher")
public class LogoutTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	
		String username=null;
		if(session != null) {
			username = (String)session.getAttribute("username");
			if(username != null) {
				session.invalidate();
				RequestDispatcher r = request.getRequestDispatcher("TeacherLogin.jsp");
				r.forward(request, response);
				
			}
			
		}
	}

}
