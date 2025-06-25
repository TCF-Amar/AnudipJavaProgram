package com.mavan.amarjeetm.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mavan.amarjeetm.models.User;
import com.mavan.amarjeetm.utils.HibernateUtil;

public class UserServices {
	HibernateUtil hu = new HibernateUtil();

	public void getAllUsers() {
		Session session = hu.getSessionFactory().openSession();
		try {
			List<User> users = session.createQuery("from User", User.class).list();

			if (users.isEmpty()) {
				System.out.println("No Users Found");
				return;
			}
			System.out.println("-------------------------------------------------------");
			for (User user : users) {
				System.out.println(user.getId() + "\t\t| " + user.getName() + "\t\t| " + user.getEmail());
			}
			System.out.println("-------------------------------------------------------");
		} catch (Exception e) {
			System.out.println("Error fetching users: " + e.getMessage());
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	public void addNewUser(String name, String email, String password) {
		Transaction tx = null;
		Session session = hu.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			User user = new User();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			session.saveOrUpdate(user);
			tx.commit();
			System.out.println("User Added Successfully: ");
		} catch (Exception e) {
			
			System.out.println("Error adding user: " + e.getMessage());
		} finally {
			session.close();
		}
	}

	public void getUserById(int id) {
		Session session = hu.getSessionFactory().openSession();
		try {
			User user = session.get(User.class, id);
			System.out.println("-----------------------------------------------");
			if (user != null) {
				System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getEmail());
			} else {
				System.out.println("User Not Found");
			}
			System.out.println("-----------------------------------------------");
		} catch (Exception e) {
			System.out.println("Error fetching user: " + e.getMessage());
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	public void updateUserById(int id, String newName, String newEmail) {
		Transaction tx = null;
		Session session = hu.getSessionFactory().openSession();
		try {
			User user = session.get(User.class, id);
			if (user != null) {
				tx = session.beginTransaction();

				user.setName(newName);
				user.setEmail(newEmail);

				session.update(user);
				tx.commit();
				System.out.println("User with ID " + id + " updated successfully.");
			} else {
				System.out.println("User Not Found");
			}
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Error updating user: " + e.getMessage());
		} finally {
			session.close();
		}
	}

	@SuppressWarnings({ "deprecation" })
	public void deleteUserById(int id) {
		Transaction tx = null;
		Session session = hu.getSessionFactory().openSession();
		try {
			User user = session.get(User.class, id);
			if (user != null) {
				tx = session.beginTransaction();
				session.delete(user);
				tx.commit();
				System.out.println("User with ID " + id + " deleted successfully.");
			} else {
				System.out.println("User Not Found");
			}
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Error deleting user: " + e.getMessage());
		} finally {
			session.close();
		}
	}

	public void loginUser(String email, String password) {

		Session session = hu.getSessionFactory().openSession();
		User u = session.createQuery("FROM User WHERE email = :email", User.class)
				.setParameter("email", email)
				.uniqueResult();

		if (u == null) {
			System.out.println("Invalid User");
		} else {
			if (u.getPassword().equals(password)) {
				System.out.println("Login successful. Welcome, "+u.getName());
			} else {
				System.out.println("Invalid password");
			}
		}

	}
}
