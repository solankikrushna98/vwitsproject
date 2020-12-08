package com.vwits.controller.teacher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vwits.model.db.TestDAOImpl;
import com.vwits.model.javabean.Test;

/**
 * Servlet implementation class AddQuestion
 */
@WebServlet("/AddQuestion")
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestDAOImpl test = new TestDAOImpl();
		RequestDispatcher r = request.getRequestDispatcher("AddQuestion.jsp");
		String que = request.getParameter("que");
		String opA = request.getParameter("optionA");
		String opB = request.getParameter("optionB");
		String opC = request.getParameter("optionC");
		String opD = request.getParameter("optionD");
		String ans = request.getParameter("ans");
		Test t = new Test(0, que, opA, opB, opC, opD, ans);
		int rows = test.save(t);

		if(rows == 1) {
			request.setAttribute("message", "Question Added Successfully!!");
			r.forward(request, response);
		} else {
			request.setAttribute("message", "Problem in Inserting Question");
			r.forward(request, response);
		}
	}

}
