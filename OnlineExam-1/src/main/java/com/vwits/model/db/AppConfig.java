package com.vwits.model.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vwits.model.javabean.Answer;

@Configuration
public class AppConfig {
	
	@Bean
	public StudentDAOImpl getEmployee() {
		return new StudentDAOImpl();
	}
	
	@Bean
	public TeacherDAOImpl getTeacher() {
		return new TeacherDAOImpl();
	}
	
	@Bean
	public TestDAOImpl getTest() {
		return new TestDAOImpl();	
	}
	
	@Bean
	public AdminDAOImpl getAdmin() {
		return new AdminDAOImpl();	
	}
	
	@Bean
	public AnswerDAOImpl getAnswerDAO() {
		return new AnswerDAOImpl();	
	}
	
	@Bean
	public Answer getAnswer() {
		return new Answer();	
	}
}
