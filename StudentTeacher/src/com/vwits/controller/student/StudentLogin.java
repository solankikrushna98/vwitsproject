package com.vwits.controller.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vwits.model.db.StudentDAOImpl;

/**
 * Servlet implementation class StudentLogin
 */
@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAOImpl student = new StudentDAOImpl();	
		
		String susername = request.getParameter("susername");
		String spassword = request.getParameter("spassword");
		String submit = request.getParameter("submit");
		
		/*
		 * Validation is done here
		 */
		if(submit.equalsIgnoreCase("login")) {
			RequestDispatcher r = request.getRequestDispatcher("StudentLogin.jsp");
			if(susername != null && spassword != null) {
				
				List list = student.getDetail(susername);
				
				if(list.size() < 5) {
					request.setAttribute("message", "Invalid Credentials");
					r.forward(request, response);
				}
				else {
					String username = (String) list.get(2);
					String password = (String) list.get(3);
					
					if(username.equals(susername) && password.equals(spassword)) {
						r = request.getRequestDispatcher("StudentHomepage.jsp");
						HttpSession session = request.getSession(true); 						
						session.setAttribute("studentid", ""+list.get(0));
						request.setAttribute("message", "Successful");
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
			RequestDispatcher r = request.getRequestDispatcher("StudentRegistration.jsp");
			r.forward(request, response);
		}
		
		
	}

}
