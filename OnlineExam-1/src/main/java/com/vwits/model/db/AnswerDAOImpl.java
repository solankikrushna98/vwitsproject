package com.vwits.model.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.vwits.model.javabean.Answer;

public class AnswerDAOImpl{
	Configuration cfg;
	SessionFactory sessionFactory;
	Session session;
	Transaction tx;
	
	
	public void save(Answer answer) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Answer.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.save(answer);
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}

	
	public List get(String ansid) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Answer.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Answer.class);
		c.add(Restrictions.eq("ansid", ansid));					
		List<Answer> list = c.list();
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return list;
	}

	
	public List getAll() {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Answer.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		List<Answer> list = session.createQuery("From Answer").list();
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
		return list;
	}

	
	public void update(Answer answer) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Answer.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.update(answer);
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}

	
	public void delete(Answer answer) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Answer.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.delete(answer);
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}
	
	public void deleteOne(int studentid) {
		cfg = new Configuration();
		sessionFactory = cfg.configure().addAnnotatedClass(Answer.class).buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		String hql = "delete from Answer ans WHERE ans.studentid IN(:studentid)";
		Query query = session.createQuery(hql);
		query.setParameter("studentid", studentid);
		query.executeUpdate();
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}

	
}
