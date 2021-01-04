package com.vwits.model.db;

import java.util.List;

import com.vwits.model.javabean.Admin;
import com.vwits.model.javabean.Answer;
import com.vwits.model.javabean.Student;
import com.vwits.model.javabean.Teacher;
import com.vwits.model.javabean.Test;

public class Demo {

	public static void main(String[] args) {
		/*StudentDAOImpl s = new StudentDAOImpl();
		Student stud1 = new Student(1, "payal", "PSolanki", "123", 21);
		int rows = s.save(stud1);
		System.out.println(rows);
		System.out.println(s.getAll());
		
		TeacherDAOImpl te = new TeacherDAOImpl();
		Teacher teach1 = new Teacher(1, "granthi", "granthi", "gran123");
		Teacher t1 = new Teacher(2, "shukla", "shukla123", "shukla123");
		System.out.println(te.save(teach1));
		System.out.println(te.save(t1));
		System.out.println(te.getAll());
		
		Test test = new Test(1, "what is machine", "optionA", "optionB", "optionC", "optionD", "optionA");
		TestDAOImpl t = new TestDAOImpl();
		System.out.println(t.save(test));
		t.update(test);
		System.out.println(t.getAll());
		System.out.println(test.getAll());
		test.delete(new Test(3, "que", "optionA", "optionB", "optionC", "optionD", "ans"));
		TestDAOImpl t = new TestDAOImpl();
		System.out.println(t.getAll());
		List<Test> list = t.getAll();
		AdminDAOImpl admin = new AdminDAOImpl();
		Admin a = new Admin(1, "admin2", "admin2", "admin2");
		
		System.out.println(admin.getAll());*/
		TestDAOImpl t = new TestDAOImpl();
		System.out.println(t.getAll());
		
		
		
		
	}

}
