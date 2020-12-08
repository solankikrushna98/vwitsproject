package com.vwits.controller.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vwits.model.db.TeacherDAOImpl;

/**
 * Servlet implementation class TeacherLogin
 */
@WebServlet("/TeacherLogin")
public class TeacherLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherDAOImpl teacher = new TeacherDAOImpl();
		
		String tusername = request.getParameter("tusername");
		String tpassword = request.getParameter("tpassword");
		String submit = request.getParameter("submit");
		
		if(submit.equalsIgnoreCase("login")) {
			RequestDispatcher r = request.getRequestDispatcher("TeacherLogin.jsp");
			if(tusername != null && tpassword != null) {
				
				List list = teacher.getDetail(tusername);
				if(list.size() < 4) {
					request.setAttribute("message", "Invalid Credentials");
					r.forward(request, response);
				}
				else {
					String username = (String) list.get(2);
					String password = (String) list.get(3);
					
					if(username.equals(tusername) && password.equals(tpassword)) {
						r = request.getRequestDispatcher("TeacherHomepage.jsp");
						
						HttpSession session = request.getSession(true);
						session.setAttribute("username", tusername);
						
						request.setAttribute("message", "Login Successfull!!");
					}
					else {
						request.setAttribute("message", "Invalid Credentials");
					}
					r.forward(request, response);
				}
			}
			else {
				request.setAttribute("message", "Invalid Credentials");
				r.forward(request, response);
			}
			
		}
		else if(submit.equalsIgnoreCase("register")) {
			RequestDispatcher r = request.getRequestDispatcher("TeacherRegistration.jsp");
			r.forward(request, response);
		}
	}
}
