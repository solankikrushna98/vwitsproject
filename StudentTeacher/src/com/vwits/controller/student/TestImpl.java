package com.vwits.controller.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import com.vwits.model.db.StudentDAOImpl;
import com.vwits.model.db.TestDAOImpl;
import com.vwits.model.javabean.Student;
import com.vwits.model.javabean.Test;
/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class TestImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session
		HttpSession session = request.getSession(false);
		String studentid = (String)session.getAttribute("studentid");
		
		TestDAOImpl t = new TestDAOImpl();
		List<Test> test = t.getAll();
		
		ArrayList<String> actual = new ArrayList<>();
		ArrayList<String> expected = new ArrayList<>();
		int result = 0;
		
		String submit = request.getParameter("submit");
		if(submit != null) {
			
			for(int i=0; i<test.size(); i++) {
				/**
				 * Get Actual from Test appeared by student
				 */
				actual.add((String)request.getParameter(""+i));
				
				/**
				 * Get Expected Answers from database
				 */
				expected.add((String)test.get(i).getAns());
			}
			
			for(int i=0; i<actual.size(); i++) {
				if(actual.get(i) != null && expected.get(i) != null) {
					if(actual.get(i).trim().equalsIgnoreCase(expected.get(i).trim())) {
						result = result+1;
					}
					else {
						System.out.println("not equal");
					}
				}
			}
			
			StudentDAOImpl student = new StudentDAOImpl();
			student.updateResult(Integer.parseInt(studentid), result);
			
			RequestDispatcher r = request.getRequestDispatcher("DisplayResult.jsp");
			request.setAttribute("result", result);
			r.forward(request, response);
		}
	
		RequestDispatcher r = request.getRequestDispatcher("Test.jsp");
		request.setAttribute("test", test);
		r.forward(request, response);
		
	}

}
