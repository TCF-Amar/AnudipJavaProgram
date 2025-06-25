package com.Student.Managment.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Student.Managment.models.Course;
import com.Student.Managment.models.Student;
import com.Student.Managment.models.User;


public final class HibernateUtils {

	private static SessionFactory sf= null;
	
	public static SessionFactory getSessionFactory() {
		try {

			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(User.class);
			cfg.addAnnotatedClass(Student.class);
			cfg.addAnnotatedClass(Course.class);
			
			sf = cfg.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		return sf;
	}
	
	
}
