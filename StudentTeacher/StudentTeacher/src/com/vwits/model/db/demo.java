package com.vwits.model.db;

import java.util.List;

import com.vwits.model.javabean.Test;
import com.vwits.model.javabean.Student;
import com.vwits.model.javabean.Teacher;

public class demo {
	public static void main(String[] args) {
		StudentDAOImpl s = new StudentDAOImpl();
		TeacherDAOImpl t = new TeacherDAOImpl();
		//Student s1 = new Student(102, "mno", "abcd", "mno12", 45);
		//System.out.println(s.update("ccuser", "ccuser123", "cc123"));
		//Student s2 = new Student(110, "Xyz", "xyz", "xyz12", 45);
		//System.out.println(s.save(s2));
		//System.out.println(s.save(s1));
		
		System.out.println();
		
		/*System.out.println(s.updateResult(101, 75));
		System.out.println(s.getLastId());
		System.out.println(s.get("aauser"));
		List list = s.get("aauser");
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		
		
		Teacher t1 = new Teacher(2, "teacher2", "teach2", "tt123");
		//System.out.println(t.save(t1));
		System.out.println(t.get("teach1"));
		System.out.println(t.getDetail("teach2"));
		System.out.println(t.getLastId());*/
		//Teacher t1 = new Teacher(8, "teacher8", "teach8", "tt123");
		//System.out.println(t.save(t1));
		//System.out.println(t.update("teach", "tt123", "tt1234"));
		
		TestDAOImpl test = new TestDAOImpl();
		Test t1 = new Test(0, "abc", "aaa", "bbb", "ccc", "ddd", "bbb");
		System.out.println(test.save(t1));
		//test.getLastId();
		//System.out.println(test.get(1));
		//System.out.println(test.update("ww", "xx", "yy", "ddd", "ww", 1));
		//System.out.println(s.getAll());
		System.out.println(s.updateResult(101, 87));
	}
}

