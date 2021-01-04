package com.vwits.model.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.vwits.model.javabean.Answer;
import com.vwits.model.javabean.Student;

public class StudentDAOImpl implements RecordDAO<Student, Integer> {
	Configuration cfg;
	SessionFactory sessionFactory;
	Session session;
	Transaction tx;
	
	@Override
	public int save(Student student) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Student.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		int rows = (int) session.save(student);
		
		tx.commit();
		session.close();
		sessionFactory.close();
		/*
		 * AnswerDAOImpl ans = new AnswerDAOImpl(); ans.save(new
		 * Answer(student.getStudentid(), student.getStudentid()+"", 1, "expected",
		 * "actual"));
		 */
		return rows;
	}

	@Override
	public List get(Integer studentid) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Student.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Student.class);
		c.add(Restrictions.eq("studentid", studentid));					
		List<Student> list = c.list();
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return list;
	}

	@Override
	public List getAll() {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Student.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		List<Student> list = session.createQuery("From Student").list();
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return list;
	}

	@Override
	public void update(Student student) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Student.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.update(student);
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}

	@Override
	public void delete(Student student) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Student.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.delete(student);
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}

	
}	