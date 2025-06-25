package com.Student.Managment.handler;

import java.util.Scanner;

public class TeacherHandler {
	private final Scanner sc = new Scanner(System.in);

	public void show() {
		while (true) {
			System.out.println("\n📋 User Menu");
			System.out.println("1. Manage Students");
			System.out.println("2. Manage Courses");
			System.out.println("3. Logout");
			System.out.print("Enter your choice: ");

			int choice = -1;
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("❌ Invalid input. Please enter a number.");
				continue;
			}

			switch (choice) {
			
			case 1:
				System.out.println("👨‍🎓 Manage Students module coming soon...");
				break;
			case 2:
				System.out.println("📚 Manage Courses module coming soon...");
				break;
			case 3: {
				System.out.println("👋 Logging out from Admin Menu.");
				return;
			}
			default:
				System.out.println("❌ Invalid choice. Please try again.");
				break;
			}
		}
	}

}
