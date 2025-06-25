package com.Student.Managment.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Student.Managment.models.*;
import com.Student.Managment.utils.HibernateUtils;
public class UserDAO {
	@SuppressWarnings("deprecation")
	public boolean registerUser(String name, String email, String password) {
		Transaction tx = null;
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();

			User existingUser = session.createQuery("FROM User WHERE email = :email", User.class)
					.setParameter("email", email).uniqueResult();

			if (existingUser != null) {
				System.out.println("User already exists.");
				return false;
			}

			long userCount = session.createQuery("SELECT COUNT(u.id) FROM User u", Long.class).uniqueResult();

			UserRole role = (userCount == 0) ? UserRole.Admin : UserRole.Teacher;

			User user = new User();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(role); 

			session.save(user);
			tx.commit();
			System.out.println("✅ Registered as " + role);
			return true;

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public User loginUser(String email, String password) {
		Transaction tx = null;
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();

			User user = session.createQuery("FROM User WHERE email = :email", User.class).setParameter("email", email)
					.uniqueResult();

			if (user == null) {
				System.out.println("No user found with this email.");
				return null;
			}

			if (user.getPassword().equals(password)) {
				System.out.println("Login successful.");
				return user;
			} else {
				System.out.println("Incorrect password.");
				return null;
			}

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Login failed: " + e.getMessage());
			return null;
		} finally {
			if (session != null)
				session.close();
		}
		}
	
//	public boolean addNewUsers(String name, String email, String password) {
//		
//		
//		return false;
//	}
}
