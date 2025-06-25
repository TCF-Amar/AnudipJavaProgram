package com.mavan.amarjeetm.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mavan.amarjeetm.models.User;


public class HibernateUtil {

	 private  SessionFactory sessionFactory;
	 
	 
	 public  SessionFactory getSessionFactory() {
			try {

				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				configuration.addAnnotatedClass(User.class);
				sessionFactory = configuration.buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
			return sessionFactory;
		}}
