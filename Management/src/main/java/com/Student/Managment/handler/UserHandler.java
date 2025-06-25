package com.Student.Managment.handler;

import java.util.Scanner;

import com.Student.Managment.services.UserServices;

public class UserHandler {

	public void show() {
		try (Scanner scanner = new Scanner(System.in)) {
			UserServices userservices = new UserServices();

			while (true) {
				System.out.println("\n==========================");
				System.out.println("🎓 Student Management System");
				System.out.println("==========================");
				System.out.println("1. Register User");
				System.out.println("2. Login User");
				System.out.println("3. Exit");
				System.out.print("Enter Your Choice: ");

				int choice = -1;
				try {
					choice = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("❌ Invalid input. Please enter a number.");
					continue;
				}

				switch (choice) {
				case 1:
					userservices.registerService();
					break;
				case 2:
					userservices.loginServices();
					break;
				case 3: {
					System.out.println("👋 Exiting... Goodbye!");
					System.exit(0);
				}
				default: {
					System.out.println("=================");
					System.out.println("❌ Invalid Input");
					System.out.println("=================");
				}
				}
			}
		}
	}

}
