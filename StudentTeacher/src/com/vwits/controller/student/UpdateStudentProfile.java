package com.vwits.controller.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vwits.model.db.StudentDAOImpl;
import com.vwits.model.db.TeacherDAOImpl;

/**
 * Servlet implementation class UpdateStudentProfile
 */
@WebServlet("/UpdateStudentProfile")
public class UpdateStudentProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("susername");
		String oldpassword = request.getParameter("soldpassword");
		String newpassword = request.getParameter("snewpassword");
		
		StudentDAOImpl student = new StudentDAOImpl();
		int output = student.update(username, oldpassword, newpassword);
		
		RequestDispatcher r = request.getRequestDispatcher("UpdateStudentProfile.jsp");
		if(output == -1) {
			request.setAttribute("message", "Invalid Username!!");
		}
		else if(output == -2) {
			request.setAttribute("message", "Invalid Password!!");
		}
		else if(output == 1) {
			request.setAttribute("message", "Profile Updated");
		}
		r.forward(request, response);
	}

}
