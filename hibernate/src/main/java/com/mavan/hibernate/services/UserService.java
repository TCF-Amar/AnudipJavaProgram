package com.mavan.hibernate.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.mavan.hibernate.models.User;
import com.mavan.hibernate.utils.HibernateUtil;

public class UserService {
	Scanner sc = new Scanner(System.in);
	Session s = HibernateUtil.getSessionFactory().openSession();
	User user = new User();

	public void addNewUser() {
		System.out.println("Enter Id: ");
		int id = sc.nextInt();
		sc.nextLine(); // Consume newline left-over
		System.out.println("Enter Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Email: ");
		String email = sc.nextLine();

		// Here you would typically call a method to save the user to the database
		System.out.println("-----------------------------------------------");
		System.out.println("User Added Successfully: " + id + ", " + name + ", " + email);
		System.out.println("-----------------------------------------------");
	}

	public void getAllusers() {
		try {
			Session s = HibernateUtil.getSessionFactory().openSession();
			List<User> users = new ArrayList<User>();
			users = s.createQuery("from User", User.class).list();
			

			if (users.isEmpty()) {
				System.out.println("No Users Found");
				s.close();
				return;
			} else {
				System.out.println("----------------------------------------------");
				for (User user : users) {
					System.out.println(user.getId() + "\t| " + user.getName() + "\t| " + user.getEmail());
				}
				System.out.println("----------------------------------------------");

			}
			s.close();
		} catch (Exception e) {
			System.out.println("Error fetching users: " + e.getMessage());
		}
	}
	
	public void getUserById(int id) {
		try {
			System.out.println("-----------------------------------------------");

			if (user != null) {
				System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getEmail());
			} else {
				System.out.println("User Not Found");
			}
			System.out.println("-----------------------------------------------");

			s.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
