package com.vwits.controller.teacher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vwits.model.db.TeacherDAOImpl;

/**
 * Servlet implementation class UpdateTeacherProfile
 */
@WebServlet("/UpdateTeacherProfile")
public class UpdateTeacherProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("tusername");
		String oldpassword = request.getParameter("toldpassword");
		String newpassword = request.getParameter("tnewpassword");
		
		TeacherDAOImpl teacher = new TeacherDAOImpl();
		int output = teacher.update(username, oldpassword, newpassword);
		System.out.println("output = "+output);
		
		RequestDispatcher r = request.getRequestDispatcher("UpdateTeacherProfile.jsp");
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
