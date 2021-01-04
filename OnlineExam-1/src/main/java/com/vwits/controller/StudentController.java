package com.vwits.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vwits.model.db.StudentDAOImpl;
import com.vwits.model.db.TeacherDAOImpl;
import com.vwits.model.javabean.Student;
import com.vwits.model.javabean.Teacher;
import com.vwits.model.javabean.Test;

@Controller
@SpringBootApplication
public class StudentController {
	private ApplicationContext context;
	@RequestMapping(value = "/StudentLogin", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request ,@RequestParam("username") String username,@RequestParam("password") String password) {	

		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		StudentDAOImpl student = new StudentDAOImpl(); 
				//context.getBean(StudentDAOImpl.class);
		
		List<Student> list = student.getAll();
		boolean flag = false;
		int studentid = 0;
		for(Student s : list) {
			/*
			 * If provided username and password matches the username and password in database then only user can login
			 */
			if(s.getUsername().trim().equalsIgnoreCase(username) && s.getPassword().trim().equals(password)) {
				flag = true;
				studentid = s.getStudentid();
				break;
			}
		}
		
		if(flag == true) {
			/**
			 * Create session
			 */
			HttpSession session = request.getSession(true); 	
			session.setAttribute("studentid", studentid);
			model.setViewName("StudentHomepage.jsp");
			return model;
		} else {
			model.setViewName("StudentLogin.jsp");
			model.addObject("message", "Invalid Credentials!!");
			return model;
		}
	}
	
	@RequestMapping(value = "/StudentRegistration", method = RequestMethod.POST)
	public ModelAndView registration(HttpServletRequest request ,@RequestParam("name") String name, @RequestParam("username") String username,@RequestParam("password") String password) {	

		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		StudentDAOImpl student = context.getBean(StudentDAOImpl.class);
		List<Student> list = student.getAll();
		boolean flag = false;
		int studentid = 0;
		for(Student s : list) {
			/*
			 * If provided username matches the username in database then user can not register
			 */
			if(s.getUsername().trim().equalsIgnoreCase(username)) {
				flag = true;
				studentid = s.getStudentid();
				break;
			}
		}
		
		if(flag == true) {
			model.setViewName("StudentRegistration.jsp");
			model.addObject("message", "Already a User!! <br> Please Login");
			return model;
		} else {
			Student s = new Student(1, name, username, password, -1);
			int row = student.save(s);
			
			if(row > 0) {
				model.setViewName("StudentRegistration.jsp");
				model.addObject("message", "Student Record Saved!!");
				return model;
			} else {
				model.setViewName("StudentRegistration.jsp");
				model.addObject("message", "Problem in Registration!!");
				return model;
			}
		}
	}
	
	@RequestMapping(value = "/UpdateStudentProfile", method = RequestMethod.POST)
	public ModelAndView test(HttpServletRequest request ,@RequestParam("username") String username, @RequestParam("oldpassword") String oldpassword, @RequestParam("newpassword") String newpassword) {	

		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession(true);
		session = request.getSession(false);
		Integer studentid = (Integer)session.getAttribute("studentid");
		
		StudentDAOImpl student = context.getBean(StudentDAOImpl.class);
		List<Student> list = student.get(studentid);

		boolean flag = false;
		if(list.get(0).getUsername().trim().equalsIgnoreCase(username) && list.get(0).getPassword().trim().equals(oldpassword)) {
			Student s = new Student(studentid, list.get(0).getName(), list.get(0).getUsername(), newpassword, list.get(0).getResult());
			student.update(s);
			flag = true;
		}
		
		if(flag == true) {
			model.setViewName("UpdateStudentProfile.jsp");
			model.addObject("message", "Updated!!");
			return model;
		} else {
			model.setViewName("UpdateStudentProfile.jsp");
			model.addObject("message", "Invalid Credentials!!");
			return model;
		}
	}
	
	@RequestMapping(value = "/DisplayResult", method = RequestMethod.GET)
	public ModelAndView displayResults() {	
		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		StudentDAOImpl student = context.getBean(StudentDAOImpl.class);
		List<Test> list = student.getAll();

		model.setViewName("DisplayMultipleResult.jsp");
		model.addObject("list", list);
		return model;
	}
	
	@RequestMapping(value = "/DisplayStudents", method = RequestMethod.GET)
	public ModelAndView displayStudents() {	
		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		StudentDAOImpl student = context.getBean(StudentDAOImpl.class);
		List<Student> list = student.getAll();

		model.setViewName("DisplayStudents.jsp");
		model.addObject("list", list);
		return model;
	}
	
	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public ModelAndView addQuestion(@RequestParam("studentid") Integer studentid) {
		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		StudentDAOImpl student = context.getBean(StudentDAOImpl.class);
		Student s = new Student(studentid, "name", "username", "password", 0);
		student.delete(s);
		
		List<Student> list = student.getAll();
		
		model.setViewName("DisplayStudents.jsp");
		model.addObject("list", list);
		return model;
	}
}
