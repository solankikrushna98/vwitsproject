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

import com.vwits.model.db.AdminDAOImpl;
import com.vwits.model.db.TeacherDAOImpl;
import com.vwits.model.javabean.Admin;
import com.vwits.model.javabean.Teacher;


@Controller
@SpringBootApplication
public class AdminController {
	private ApplicationContext context;
	
	@RequestMapping(value = "/AdminLogin", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password) {	
		
		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		AdminDAOImpl admin = context.getBean(AdminDAOImpl.class);
		List<Admin> list = admin.getAll();
		boolean flag = false;
		for(Admin a : list) {
			/*
			 * If provided username and password matches the username and password in database then only user can login
			 */
			if(a.getUsername().trim().equalsIgnoreCase(username) && a.getPassword().trim().equals(password)) {
				flag = true;
				break;
			}
		}
		
		if(flag == true) {
			model.setViewName("AdminHomepage.jsp");
			return model;
		} else {
			model.setViewName("AdminLogin.jsp");
			model.addObject("message", "Invalid Credentials!!");
			return model;
		}
	}
	
	@RequestMapping(value = "/AdminRegistration", method = RequestMethod.POST)
	public ModelAndView registration(@RequestParam("name") String name, @RequestParam("username") String username,@RequestParam("password") String password) {	

		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		AdminDAOImpl admin = context.getBean(AdminDAOImpl.class);
		List<Admin> list = admin.getAll();
		boolean flag = false;
		for(Admin a : list) {
			/*
			 * If provided username matches the username in database then user can not register
			 */
			if(a.getUsername().trim().equalsIgnoreCase(username)) {
				flag = true;
				break;
			}
		}
		
		if(flag == true) {
			model.setViewName("AdminRegistration.jsp");
			model.addObject("message", "Already a User!! <br> Please Login");
			return model;
		} else {
			Admin a = new Admin(1, name, username, password);
			int row = admin.save(a);
			
			/*
			 * If record inserted successfully then go to AdminLogin.jsp
			 */
			if(row > 0) {
				model.setViewName("AdminLogin.jsp");
				return model;
			} else {
				model.setViewName("AdminRegistration.jsp");
				model.addObject("message", "Problem in Registration!!");
				return model;
			}
		}
	}
	
	@RequestMapping(value = "/UpdateAdminProfile", method = RequestMethod.POST)
	public ModelAndView test(@RequestParam("username") String username, @RequestParam("oldpassword") String oldpassword, @RequestParam("newpassword") String newpassword) {	

		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		AdminDAOImpl admin = context.getBean(AdminDAOImpl.class);
		List<Admin> list = admin.getAll();

		boolean flag = false;
		for(Admin a : list) {
			/*
			 * If provided username and password matches the username and password in database then only user can update profile
			 */
			if(a.getUsername().trim().equalsIgnoreCase(username) && a.getPassword().trim().equals(oldpassword)) {
				Admin adm = new Admin(a.getAdminid(), a.getName(), username, newpassword);
				admin.update(adm);
				flag = true;
				break;
			}
		}
		
		if(flag == true) {
			model.setViewName("UpdateAdminProfile.jsp");
			model.addObject("message", "Updated!!");
			return model;
		} else {
			model.setViewName("UpdateAdminProfile.jsp");
			model.addObject("message", "Invalid Credentials!!");
			return model;
		}
	}
	
	@RequestMapping(value = "/deleteAdmin", method = RequestMethod.GET)
	public ModelAndView addQuestion(@RequestParam("adminid") Integer adminid) {
		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		AdminDAOImpl admin = context.getBean(AdminDAOImpl.class);
		Admin a = new Admin(adminid, "name", "username", "password");
		admin.delete(a);
		
		List<Admin> list = admin.getAll();
		
		model.setViewName("AdminLogin.jsp");
		model.addObject("list", list);
		return model;
	}
}
