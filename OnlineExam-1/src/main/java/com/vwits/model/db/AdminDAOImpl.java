package com.vwits.model.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.vwits.model.javabean.Admin;
import com.vwits.model.javabean.Teacher;

public class AdminDAOImpl implements RecordDAO<Admin, String> {
	
	Configuration cfg;
	SessionFactory sessionFactory;
	Session session;
	Transaction tx;
	@Override
	public int save(Admin admin) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Admin.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		int rows = (int) session.save(admin);
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return rows;
	}
	@Override
	public List get(String name) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Admin.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Admin.class);
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
		sessionFactory = cfg.configure().addAnnotatedClass(Admin.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		List<Teacher> list = session.createQuery("From Admin").list();
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return list;
	}
	
	@Override
	public void update(Admin admin) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Admin.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.update(admin);
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Override
	public void delete(Admin admin) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Admin.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.delete(admin);
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
