package com.vwits.controller;

import java.util.List;

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
import com.vwits.model.db.TestDAOImpl;
import com.vwits.model.javabean.Teacher;
import com.vwits.model.javabean.Test;

@Controller
@SpringBootApplication
public class TeacherController {
	private ApplicationContext context;
	
	@RequestMapping(value = "/TeacherLogin", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password) {	
		
		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		TeacherDAOImpl teacher = context.getBean(TeacherDAOImpl.class);
		List<Teacher> list = teacher.getAll();
		boolean flag = false;
		for(Teacher t : list) {
			/*
			 * If provided username and password matches the username and password in database then only user can login
			 */
			if(t.getUsername().trim().equalsIgnoreCase(username) && t.getPassword().trim().equals(password)) {
				flag = true;
				break;
			}
		}
		
		if(flag == true) {
			model.setViewName("TeacherHomepage.jsp");
			return model;
		} else {
			model.setViewName("TeacherLogin.jsp");
			model.addObject("message", "Invalid Credentials!!");
			return model;
		}
	}
	
	@RequestMapping(value = "/TeacherRegistration", method = RequestMethod.POST)
	public ModelAndView registration(@RequestParam("name") String name, @RequestParam("username") String username,@RequestParam("password") String password) {	

		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		TeacherDAOImpl teacher = context.getBean(TeacherDAOImpl.class);
		List<Teacher> list = teacher.getAll();
		boolean flag = false;
		for(Teacher t : list) {
			/*
			 * If provided username matches the username in database then user can not register
			 */
			if(t.getUsername().trim().equalsIgnoreCase(username)) {
				flag = true;
				break;
			}
		}
		
		if(flag == true) {
			model.setViewName("TeacherRegistration.jsp");
			model.addObject("message", "Already a User!! <br> Please Login");
			return model;
		} else {
			Teacher t = new Teacher(1, name, username, password);
			int row = teacher.save(t);
			
			/*
			 * If record inserted successfully then send the message "Teacher Record saved"
			 */
			if(row > 0) {
				model.setViewName("TeacherRegistration.jsp");
				model.addObject("message", "Teacher Record saved!!");
				return model;
			} else {
				model.setViewName("TeacherRegistration.jsp");
				model.addObject("message", "Problem in Registration!!");
				return model;
			}
		}
	}
	
	@RequestMapping(value = "/UpdateTeacherProfile", method = RequestMethod.POST)
	public ModelAndView test(@RequestParam("username") String username, @RequestParam("oldpassword") String oldpassword, @RequestParam("newpassword") String newpassword) {	

		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		TeacherDAOImpl teacher = context.getBean(TeacherDAOImpl.class);
		List<Teacher> list = teacher.getAll();

		boolean flag = false;
		for(Teacher t : list) {
			/*
			 * If provided username and password matches the username and password in database then only user can update profile
			 */
			if(t.getUsername().trim().equalsIgnoreCase(username) && t.getPassword().trim().equals(oldpassword)) {
				Teacher stud = new Teacher(t.getTeacherid(), t.getName(), username, newpassword);
				teacher.update(stud);
				flag = true;
				break;
			}
		}
		
		if(flag == true) {
			model.setViewName("UpdateTeacherProfile.jsp");
			model.addObject("message", "Updated!!");
			return model;
		} else {
			model.setViewName("UpdateTeacherProfile.jsp");
			model.addObject("message", "Invalid Credentials!!");
			return model;
		}
	}
	
	@RequestMapping(value = "/DisplayTeachers", method = RequestMethod.GET)
	public ModelAndView displayStudents() {	
		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		TeacherDAOImpl teacher = context.getBean(TeacherDAOImpl.class);
		List<Teacher> list = teacher.getAll();

		model.setViewName("DisplayTeachers.jsp");
		model.addObject("list", list);
		return model;
	}
	
	@RequestMapping(value = "/deleteTeacher", method = RequestMethod.GET)
	public ModelAndView addQuestion(@RequestParam("teacherid") Integer teacherid) {
		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		TeacherDAOImpl teacher = context.getBean(TeacherDAOImpl.class);
		Teacher t = new Teacher(teacherid, "name", "username", "password");
		teacher.delete(t);
		
		List<Teacher> list = teacher.getAll();
		
		model.setViewName("DisplayTeachers.jsp");
		model.addObject("list", list);
		return model;
	}
}
