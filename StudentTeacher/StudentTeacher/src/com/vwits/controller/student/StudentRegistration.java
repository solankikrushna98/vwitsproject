package com.vwits.controller.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vwits.model.db.StudentDAOImpl;
import com.vwits.model.javabean.Student;

@WebServlet("/StudentRegistration")
public class StudentRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAOImpl student = new StudentDAOImpl();
		/**
		 * Get lastid inserted of the student so that new student will have auto incremented id.
		 */
		int lastid = student.getLastId();
		String sname = request.getParameter("sname");
		String susername = request.getParameter("susername");
		String spassword = request.getParameter("spassword");
		
		Student stud = new Student(lastid+1, sname, susername, spassword, 0);
		int rows = student.save(stud);
		
		/**
		 * if inserted successfully the returns 1
		 */
		if(rows == 1) {
			RequestDispatcher r = request.getRequestDispatcher("StudentLogin.jsp");
			request.setAttribute("message", "Registration Successful!!");
			r.forward(request, response);
		}
			
		else {
			RequestDispatcher r = request.getRequestDispatcher("StudentRegistration.jsp");
			request.setAttribute("message", "Problem in Registration!!");
			r.forward(request, response);
		}
		
	}

}
