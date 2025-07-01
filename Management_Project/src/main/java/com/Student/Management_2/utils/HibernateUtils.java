package com.Student.Management_2.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Student.Management_2.models.Attandence;
import com.Student.Management_2.models.Course;
import com.Student.Management_2.models.Student;
import com.Student.Management_2.models.Teacher;



public final class HibernateUtils {

	private  static SessionFactory sf= null;
	
	public  static SessionFactory getSessionFactory() {
		try {

			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Teacher.class);
			cfg.addAnnotatedClass(Student.class);
			cfg.addAnnotatedClass(Course.class);
			cfg.addAnnotatedClass(Attandence.class);
			
			sf = cfg.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		return sf;
	}
	
	
}
