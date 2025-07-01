package com.Student.Management_2.services;

import java.util.Scanner;

import org.hibernate.Session;

import com.Student.Management_2.menu.AdminMenu;
import com.Student.Management_2.menu.TeacherMenu;
import com.Student.Management_2.models.Teacher;
import com.Student.Management_2.utils.HibernateUtils;

public class AuthServices {
	private Scanner sc = new Scanner(System.in);
	private final String admin = "Admin";
	private final String adminemail = "admin@gmail.com";
	private final String adminpass = "admin123";

	public void adminLogin() {

		System.out.print("Enter admin email(admin@gmail.com): ");
		String email = sc.nextLine();

		System.out.print("Enter password(admin123): ");
		String password = sc.nextLine();

		if (email.equals(adminemail) && password.equals(adminpass)) {
			System.out.println("----------------------------------");
			System.out.println("Logged in successfully " + this.admin);
			System.out.println("----------------------------------");
			AdminMenu.show();
		} else {
			System.out.println("----------------------------------");
			System.out.println("Invalid email or password");
			System.out.println("Please try again");
			System.out.println("----------------------------------");
		}

	}

	public String getAdmin() {
		return admin;
	}

	public String getAdminemail() {
		return adminemail;
	}

	public void TeacherLogin() {
		System.out.println("Enter teacher email: ");
		String email = sc.nextLine();

		System.out.println("Enter teacher password: ");
		String password = sc.nextLine();

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Teacher teacher = session.createQuery("FROM Teacher WHERE email=:email", Teacher.class)
					.setParameter("email", email).uniqueResult();

			if (teacher != null && teacher.getPassword().equals(password)) {
				System.out.println("----------------------------------");
				System.out.println("Logged in successfully as " + teacher.getName());
				System.out.println("----------------------------------");
				TeacherMenu.show();
			} else {
				System.out.println("----------------------------------");
				System.out.println("Invalid email or password");
				System.out.println("Please try again");
				System.out.println("----------------------------------");
			}
		} catch (Exception e) {
			System.out.println("----------------------------------");
			System.out.println("An error occurred while logging in: " + e.getMessage());
			System.out.println("Please try again");
			System.out.println("----------------------------------");
		}

	}

}
