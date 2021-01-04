package com.vwits.model.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.vwits.model.javabean.Teacher;

public class TeacherDAOImpl implements RecordDAO<Teacher, String> {
	Configuration cfg;
	SessionFactory sessionFactory;
	Session session;
	Transaction tx;
	
	@Override
	public int save(Teacher teacher) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Teacher.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		int rows = (int) session.save(teacher);
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return rows;
	}

	@Override
	public List get(String name) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Teacher.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Teacher.class);
		c.add(Restrictions.eq("name", name));					
		List<Teacher> list = c.list();
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return list;
	}

	@Override
	public List getAll() {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Teacher.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		List<Teacher> list = session.createQuery("From Teacher").list();
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return list;
	}

	@Override
	public void update(Teacher teacher) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Teacher.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.update(teacher);
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Override
	public void delete(Teacher teacher) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Teacher.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.delete(teacher);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
