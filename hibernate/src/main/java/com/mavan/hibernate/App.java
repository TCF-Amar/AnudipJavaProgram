package com.mavan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mavan.hibernate.models.User;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		User u = new User();
		u.setId(10);
		u.setName("Amar");

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction t =  session.beginTransaction();

		session.save(t);
		try {
			t.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
