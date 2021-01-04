package com.vwits.model.db;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.vwits.model.javabean.Test;

public class TestDAOImpl implements TestDAO<Test, Integer>{
	Configuration cfg;
	SessionFactory sessionFactory;
	Session session;
	Transaction tx;
	
	@Override
	public int save(Test test) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Test.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		int rows = (int) session.save(test);
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return rows;
	}

	@Override
	public List<Test> get(Integer queid) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Test.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Test.class);
		c.add(Restrictions.eq("queid", queid));					
		List<Test> list = c.list();
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return list;
	}

	@Override
	public List getAll() {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Test.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		List<Test> list = session.createQuery("From Test").list();
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return list;
	}

	@Override
	public void update(Test test) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Test.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.update(test);
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}

	@Override
	public void delete(Test test) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Test.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.delete(test);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
}
