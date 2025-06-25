package com.Student.Managment.services;

import java.util.Scanner;

import com.Student.Managment.dao.UserDAO;
import com.Student.Managment.handler.*;
import com.Student.Managment.models.*;

public class UserServices {
	Scanner sc = new Scanner(System.in);
	UserDAO userdao = new UserDAO();
	AdminHandler am = new AdminHandler();

	public void registerService() {
		System.out.print("Enter Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Email Address: ");
		String email = sc.nextLine();

		System.out.print("Enter Password: ");
		String password = sc.nextLine();

		boolean res = userdao.registerUser(name, email, password);

		if (res) {
			System.out.println("================================");
			System.out.println("✅ Account Successfully Created");
			System.out.println("================================");

		} else {
			System.out.println("================================");
			System.out.println("❌ Something went wrong. Try again.");
			System.out.println("================================");

		}
	}

	public void loginServices() {
		System.out.print("Enter Email: ");
		String email = sc.nextLine();

		System.out.print("Enter Password: ");
		String password = sc.nextLine();

		User user = userdao.loginUser(email, password);

		if (user != null) {
			System.out.println("================================");
			System.out.println("✅ Login Successful. Welcome, " + user.getName() + "!");
			System.out.println("================================");

			switch (user.getRole()) {
			case Admin:
				new AdminHandler().show();
				break;
			case Teacher:
				new TeacherHandler().show();
				break;
			default:
				break;
			}
		} else {
			System.out.println("================================");
			System.out.println("❌ Invalid email or password.");
			System.out.println("================================");

		}

	}

	public void updateTeacher() {
		User user = new User();
		System.out.print("Enter User ID to Update: ");
		int userId = Integer.parseInt(sc.nextLine());
		user.setId(userId);
		System.out.print("Enter New Name: ");
		String name = sc.nextLine();
		user.setName(name);
		System.out.print("Enter New Email: ");

		String email = sc.nextLine();
		user.setEmail(email);
		System.out.print("Enter New Password: ");
		String password = sc.nextLine();
		user.setPassword(password);
		System.out.print("Enter New Role (Admin/Teacher): ");
		String roleInput = sc.nextLine();
		UserRole role = UserRole.valueOf(roleInput);
		user.setRole(role);
		System.out.println("================================");
		System.out.println("Updating User...");
		System.out.println("================================");
		if (user.getId() <= 0) {
			System.out.println("================================");
			System.out.println("❌ Invalid User ID. Please try again.");
			System.out.println("================================");
			return;
		}
		if (user.getName().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
			System.out.println("================================");
			System.out.println("❌ Name, Email, and Password cannot be empty.");
			System.out.println("================================");
			return;
		}
		if (role == null) {
			System.out.println("================================");
			System.out.println("❌ Invalid Role. Please enter either 'Admin' or 'Teacher'.");
			System.out.println("================================");
			return;
		}
		System.out.println("================================");
		System.out.println("Updating User with ID: " + user.getId());
		System.out.println("================================");

		boolean res = userdao.updateUser(user);

		if (res) {
			System.out.println("================================");
			System.out.println("✅ User Updated Successfully");
			System.out.println("================================");

		} else {
			System.out.println("================================");
			System.out.println("❌ Something went wrong. Try again.");
			System.out.println("================================");

		}
	}

	public void deleteUser() {
		System.out.print("Enter User ID to Delete: ");
		int userId = Integer.parseInt(sc.nextLine());

		if (userId <= 0) {
			System.out.println("================================");
			System.out.println("❌ Invalid User ID. Please try again.");
			System.out.println("================================");
			return;
		}

		boolean res = userdao.deleteUser(userId);

		if (res) {
			System.out.println("================================");
			System.out.println("✅ User Deleted Successfully");
			System.out.println("================================");

		} else {
			System.out.println("================================");
			System.out.println("❌ Something went wrong. Try again.");
			System.out.println("================================");

		}
	}
	
		public void viewUserById() {
		System.out.print("Enter User ID to View: ");
		int userId = Integer.parseInt(sc.nextLine());

		if (userId <= 0) {
			System.out.println("================================");
			System.out.println("❌ Invalid User ID. Please try again.");
			System.out.println("================================");
			return;
		}

		User user = userdao.getUserById(userId);

		if (user != null) {
			System.out.println("================================");
			System.out.println("User Details:");
			System.out.println("ID: " + user.getId());
			System.out.println("Name: " + user.getName());
			System.out.println("Email: " + user.getEmail());
			System.out.println("Role: " + user.getRole());
			System.out.println("================================");

		} else {
			System.out.println("================================");
			System.out.println("❌ User not found.");
			System.out.println("================================");

		}
	}
		
	public void viewAllUsers() {
		System.out.println("================================");
		System.out.println("Fetching All Users...");
		System.out.println("================================");

		userdao.getAllUsers().forEach(user -> {
			System.out.print("ID: " + user.getId());
			System.out.print(", Name: " + user.getName());
			System.out.print(", Email: " + user.getEmail());
			System.out.print(", Role: " + user.getRole());
			System.out.println("-------------------------------");
		});
		if (userdao.getAllUsers().isEmpty()) {
			System.out.println("No users found.");
		}
	}
	
}
