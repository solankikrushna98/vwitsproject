package com.vwits.controller.teacher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vwits.model.db.TeacherDAOImpl;
import com.vwits.model.javabean.Teacher;

/**
 * Servlet implementation class Teacher
 */
@WebServlet("/TeacherRegistration")
public class TeacherRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherDAOImpl teacher = new TeacherDAOImpl();
		/**
		 * Get lastid inserted of the Teacher so that new teacher will have auto incremented id.
		 */
		int lastid = teacher.getLastId();
		String tname = request.getParameter("tname");
		String tusername = request.getParameter("tusername");
		String tpassword = request.getParameter("tpassword");
		
		Teacher t = new Teacher(lastid+1, tname, tusername, tpassword);
		int rows = teacher.save(t);
		System.out.println("rows = "+rows);
		
		if(rows == 1) {
			RequestDispatcher r = request.getRequestDispatcher("TeacherLogin.jsp");
			request.setAttribute("message", "Registration Successful!!");
			r.forward(request, response);
		}
			
		else {
			RequestDispatcher r = request.getRequestDispatcher("TeacherRegistration.jsp");
			request.setAttribute("message", "Problem in Registration!!");
			r.forward(request, response);
		}
	}

}
