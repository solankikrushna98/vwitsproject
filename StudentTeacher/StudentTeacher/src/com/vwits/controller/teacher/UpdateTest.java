package com.vwits.controller.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vwits.model.db.TestDAOImpl;

/**
 * Servlet implementation class UpdateTest
 */
@WebServlet("/UpdateTest")
public class UpdateTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestDAOImpl test = new TestDAOImpl();
		RequestDispatcher r = request.getRequestDispatcher("UpdateTest.jsp");
		String opA = request.getParameter("optionA");
		String opB = request.getParameter("optionB");
		String opC = request.getParameter("optionC");
		String opD = request.getParameter("optionD");
		String ans = request.getParameter("ans");
		String queid = request.getParameter("queid");
		if(queid == null) {
			request.setAttribute("message", "Invalid Question ID");
			r.forward(request, response);
		} else {
			List list = test.get(Integer.parseInt(queid));
			if(list.size() < 1) {
				request.setAttribute("message", "Invalid Question ID");
				r.forward(request, response);
			} else {
				int rows = test.update(opA, opB, opC, opD, ans, Integer.parseInt(queid));
				if(rows == 1) {
					request.setAttribute("message", "Update Successful!!");
					r.forward(request, response);
				}
			}
		}
		
		
	}

}
