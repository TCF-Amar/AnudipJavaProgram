package com.Student.Managment.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Student.Managment.utils.HibernateUtils;
import com.Student.Managment.models.*;

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

	@SuppressWarnings("deprecation")
	public boolean updateUser(User user) {

		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();

			User existingUser = session.get(User.class, user.getId());
			if (existingUser == null) {
				System.out.println("User not found.");
				return false;
			}

			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			existingUser.setPassword(user.getPassword());
			existingUser.setRole(user.getRole());

			session.update(existingUser);
			tx.commit();
			System.out.println("✅ User updated successfully.");
			return true;

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Update failed: " + e.getMessage());
			return false;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@SuppressWarnings("deprecation")
	public boolean deleteUser(int userId) {
		Transaction tx = null;
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();

			User user = session.get(User.class, userId);
			if (user == null) {
				System.out.println("User not found.");
				return false;
			}

			session.delete(user);
			tx.commit();
			System.out.println("✅ User deleted successfully.");
			return true;

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Delete failed: " + e.getMessage());
			return false;
		} finally {
			if (session != null)
				session.close();
		}
	}

	public User getUserById(int userId) {
		Transaction tx = null;
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();

			User user = session.get(User.class, userId);
			if (user == null) {
				System.out.println("User not found.");
				return null;
			}

			tx.commit();
			return user;

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Get User by ID failed: " + e.getMessage());
			return null;
		} finally {
			if (session != null)
				session.close();
		}
	}

	public List<User> getAllUsers() {
		Transaction tx = null;
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			tx = session.beginTransaction();

			List<User> users = session.createQuery("FROM User", User.class).list();
			tx.commit();
			return users;

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Get All Users failed: " + e.getMessage());
			return Collections.emptyList();
		} finally {
			if (session != null)
				session.close();
		}
	}

}
