package com.mavan.project.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mavan.project.models.Car;
import com.mavan.project.models.Children;
import com.mavan.project.models.Parent;


public class Hibernateutils {

	 private  SessionFactory sessionFactory;
	 
	 
	 public  SessionFactory getSessionFactory() {
			try {

				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				
				configuration.addAnnotatedClass(Parent.class);
				configuration.addAnnotatedClass(Children.class);
				configuration.addAnnotatedClass(Car.class);
				sessionFactory = configuration.buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
			return sessionFactory;
		}}
