package com.vwits.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vwits.model.db.AnswerDAOImpl;
import com.vwits.model.db.StudentDAOImpl;
import com.vwits.model.db.TestDAOImpl;
import com.vwits.model.javabean.Answer;
import com.vwits.model.javabean.Student;
import com.vwits.model.javabean.Test;

@Controller
@SpringBootApplication
public class TestController {
	
	private ApplicationContext context = new AnnotationConfigApplicationContext("com.vwits.model.db");;
	@RequestMapping(value = "/Test", method = RequestMethod.POST)
	public ModelAndView question() {	

		ModelAndView model = new ModelAndView();
		TestDAOImpl test = context.getBean(TestDAOImpl.class);
		List<Test> list = test.getAll();
		model.setViewName("Test.jsp");
		model.addObject("test", list);
		return model;
	}	

	@RequestMapping(value = "/updateQue", method = RequestMethod.GET)
	public ModelAndView updateQue(@RequestParam("queid") Integer queid) {
		
		ModelAndView model = new ModelAndView();
		TestDAOImpl test = context.getBean(TestDAOImpl.class);
		
		List<Test> list = test.get(queid);
		
		model.setViewName("UpdateTest.jsp");
		model.addObject("list", list);
		return model;
	}

	@RequestMapping(value = "/UpdateTest", method = RequestMethod.POST)
	public ModelAndView updateTest(@RequestParam("queid") Integer queid, @RequestParam("que") String que, @RequestParam("optionA") String optionA, @RequestParam("optionB") String optionB, @RequestParam("optionC") String optionC, @RequestParam("optionD") String optionD, @RequestParam("ans") String ans) {
		context = new AnnotationConfigApplicationContext("com.vwits.model.db");
		ModelAndView model = new ModelAndView();
		TestDAOImpl test = context.getBean(TestDAOImpl.class);
		test.update(new Test(queid, que, optionA, optionB, optionC, optionD, ans));
		
		List<Test> list = test.getAll();
		
		model.setViewName("DisplayQuestions.jsp");
		model.addObject("list", list);
		return model;
	}
	
	@RequestMapping(value = "/DisplayQuestion", method = RequestMethod.GET)
	public ModelAndView displayQuestion() {	
		
		boolean flag = false;
		ModelAndView model = new ModelAndView();
		TestDAOImpl test = context.getBean(TestDAOImpl.class);
		List<Test> list = test.getAll();
		
		model.setViewName("DisplayQuestions.jsp");
		model.addObject("list", list);
		return model;
	}
	
	@RequestMapping(value = "/AddQuestion", method = RequestMethod.POST)
	public ModelAndView addQuestion(@RequestParam("que") String que, @RequestParam("optionA") String optionA, @RequestParam("optionB") String optionB, @RequestParam("optionC") String optionC, @RequestParam("optionD") String optionD, @RequestParam("ans") String ans) {	
		
		ModelAndView model = new ModelAndView();
		TestDAOImpl test = context.getBean(TestDAOImpl.class);
		Test t = new Test(1, que, optionA, optionB, optionC, optionD, ans);
		int row = test.save(t);
		if(row > 0) {
			model.setViewName("AddQuestion.jsp");
			model.addObject("message", "Question Saved");
			return model;
		} else {
			model.setViewName("AddQuestion.jsp");
			model.addObject("message", "Some problem in saving Question");
			return model;
		}
	}
	
	@RequestMapping(value = "/deleteQue", method = RequestMethod.GET)
	public ModelAndView addQuestion(@RequestParam("queid") Integer queid) {
		
		ModelAndView model = new ModelAndView();
		TestDAOImpl test = context.getBean(TestDAOImpl.class);
		Test t = new Test(queid, "que", "optionA", "optionB", "optionC", "optionD", "ans");
		test.delete(t);
		
		List<Test> list = test.getAll();
		
		model.setViewName("DisplayQuestions.jsp");
		model.addObject("list", list);
		return model;
	}
	
	@RequestMapping(value = "/Q", method = RequestMethod.GET)
	public ModelAndView q(@RequestParam("queid") Integer queid) {
		
		ModelAndView model = new ModelAndView();
		TestDAOImpl test = context.getBean(TestDAOImpl.class);

		List<Test> full_list = test.getAll();
		model.setViewName("Test.jsp");
		model.addObject("full_list", full_list);
		return model;
	}
	
	@RequestMapping(value = "/Questions", method = RequestMethod.GET)
	public ModelAndView quest(HttpServletRequest request) {	
		ModelAndView model = new ModelAndView();
		TestDAOImpl test = context.getBean(TestDAOImpl.class);
		AnswerDAOImpl ansDao = context.getBean(AnswerDAOImpl.class);
		List<Test> full_list = test.getAll();
		HttpSession session = request.getSession(true);
		session = request.getSession(false);
		Integer studentid = (Integer)session.getAttribute("studentid");
		
		
		int last = full_list.get(full_list.size()-1).getQueid();
		System.out.println("Full list: ");
		System.out.println("last = "+last);
		Test list = null;
		List<Answer> answer = ansDao.getAll();
		if(answer != null) {
			for(int i=0; i<full_list.size(); i++) {
				/*
				 * Whenever user resumes test, his actual answer will be null from where he has left the test.
				 * So from that question ie. full_list.get(a.getQueid()); he will resume the test
				 * else from begining ie. full_list.get(0); he will start the test.
				 */
				System.out.println("Inside for");
				System.out.println(answer);
				boolean flag = false;
				for(int j=0; j<answer.size(); j++) {
					if(full_list.get(i).getQueid() != answer.get(j).getQueid() && answer.get(j).getStudentid() == studentid) {
						System.out.println("List = "+full_list.get(i));
						
						list = full_list.get(i-1);
						flag = true;
						break;
					}
				}
				if(flag == false) {
					list = full_list.get(0);
				}
				/*
				 * send disable next, disable prev message to Q.jsp
				 */
				int current = list.getQueid();
				// for prev
				if(current == full_list.get(1).getQueid()){
    				model.addObject("message", "disable prev");
    			} else { 
    				model.addObject("message", "enable prev");
    			}
				// for last
				if(current == last){
    				model.addObject("message", "disable next");
    			} else{
    				model.addObject("message", "enable next");
    			}	
			}
		} else {
			System.out.println("inside outer else");
			list = full_list.get(0);
		}       
		System.out.println("List : "+list);
		model.setViewName("Q.jsp");
		model.addObject("list", list);
		return model;
	}
	
	@RequestMapping(value = "/OneQuestion", method = RequestMethod.POST)
	public ModelAndView question(HttpServletRequest request, @RequestParam Map<String, String> map) {
		HttpSession session = request.getSession(false);
		session = request.getSession(false);
		/**
		 * Get question id and student id from session
		 */
		Integer current = (Integer)session.getAttribute("queid");
		Integer studentid = (Integer)session.getAttribute("studentid");
		
		ModelAndView model = new ModelAndView();
		TestDAOImpl testDao = context.getBean(TestDAOImpl.class);
		AnswerDAOImpl ansDao = context.getBean(AnswerDAOImpl.class);
		String ansid = (studentid+""+current).trim();
		List<Test> full_list = testDao.getAll();
		Test list = null;
		List<Test> testList = testDao.get(current);
		Answer ans = new Answer(studentid, ansid, current, testList.get(0).getAns(), map.get("ans"));

		if(list != null) {
			ansDao.save(ans);
		}
		else {
			ansDao.delete(ans);
			ansDao.save(ans);
		}
		
		model.setViewName("Q.jsp");
		int last = full_list.get(full_list.size()-2).getQueid();
		boolean flag = false;

    	for(int i=0; i<full_list.size(); i++){
    		if(current == full_list.get(i).getQueid()){
    			//for prev
    			if(map.get("submit").equalsIgnoreCase("prev")) {

    				if(current == full_list.get(1).getQueid()){
    					list = full_list.get(i-1);
        				model.addObject("message", "disable prev");
        			} else { 
        				list = full_list.get(i-1);
        				model.addObject("message", "enable prev");
        			}
    			} 
    			//for next
    			else if(map.get("submit").equalsIgnoreCase("next")) {
    				System.out.println("4444");
        			if(current == last){
        				list = full_list.get(i+1);
        				model.addObject("message", "disable next");
        			} else{
        				list = full_list.get(i+1);
        				System.out.println("555");
        				model.addObject("message", "enable next");
        			}
    			}
    			//for submit
    			else if(map.get("submit").equalsIgnoreCase("submit")) {
    				flag = true;
    				break;
    			}
    		}
    	}
    	
    	if(flag == true) {
    		model = calculateResult(studentid);
    	} else {
    		model.addObject("list", list);
    	}
    	return model;
	}
	

	public ModelAndView calculateResult(int studentid) {
		
		ModelAndView model = new ModelAndView();
		int result=0;
		AnswerDAOImpl ansDao = context.getBean(AnswerDAOImpl.class);
		List<Answer> answer = ansDao.getAll();
		
		for(Answer a : answer) {
			/**
			 * If student id matches the studentid present in database then compare actual and expected answers
			 */
			if(a.getStudentid() == studentid) {
				if(a.getExpected().trim().equalsIgnoreCase(a.getActual().trim())) {
					result++;
				}
			}
		}
		StudentDAOImpl studentDao = context.getBean(StudentDAOImpl.class);
		List<Student> studentRecord = studentDao.get(studentid); 
		Student student = new Student(studentid, studentRecord.get(0).getName(), studentRecord.get(0).getUsername(), studentRecord.get(0).getPassword(), result);
		studentDao.update(student);
		ansDao.deleteOne(studentid);
		model.setViewName("DisplayResult.jsp");
		model.addObject("result", result);
		return model;
	}
	
	@RequestMapping(value = "/exitTest", method = RequestMethod.POST)
	public ModelAndView addQuestion(HttpServletRequest request) {	
		HttpSession session = request.getSession(false);
		Integer studentid = (Integer)session.getAttribute("studentid");
		ModelAndView model = new ModelAndView();
		session.setAttribute("studentid", studentid);
		model.setViewName("StudentHomepage.jsp");
		return model;
	}
}
