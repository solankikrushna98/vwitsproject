package com.vwits.controller.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vwits.model.db.StudentDAOImpl;
import com.vwits.model.db.TeacherDAOImpl;
import com.vwits.model.javabean.Student;

/**
 * Servlet implementation class DisplayResult
 */
@WebServlet("/DisplayResult")
public class DisplayMultipleResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAOImpl student = new StudentDAOImpl();
		List<Student> list = student.getAll();
		System.out.println("GetAll() = "+list);
		RequestDispatcher r = request.getRequestDispatcher("DisplayMultipleResult.jsp");
		request.setAttribute("multiple", list);
		r.forward(request, response);
	}

}
