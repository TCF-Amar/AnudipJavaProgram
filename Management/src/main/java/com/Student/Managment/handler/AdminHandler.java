package com.Student.Managment.handler;

import java.util.Scanner;

import com.Student.Managment.menu.CourseMenu;
import com.Student.Managment.menu.StudentMenu;
import com.Student.Managment.menu.UserMenu;

public class AdminHandler {

	private final Scanner sc = new Scanner(System.in);

	public void show() {
		while (true) {
			System.out.println("\n📋 Admin Menu");
			System.out.println("1. Manage Users");
			System.out.println("2. Manage Students");
			System.out.println("3. Manage Courses");
			System.out.println("0. Logout");
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
				new UserMenu().showUsermenu();
				break;
			case 2:
				new StudentMenu().showStudentMenu();
				break;
			case 3:
				new CourseMenu().showCourseMenu();
				break;
			case 0: {
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
