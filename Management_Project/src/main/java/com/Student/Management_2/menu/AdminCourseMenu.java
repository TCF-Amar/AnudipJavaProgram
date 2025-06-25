package com.Student.Management_2.menu;

import java.util.Scanner;

import com.Student.Management_2.services.CourseServices;

public class AdminCourseMenu {
	private static final Scanner sc = new Scanner(System.in);
	private static final CourseServices courseServices = new CourseServices();

	public static void show() {
		while (true) {
			System.out.println("=================================");
			System.out.println("📚 Welcome to Admin Course Menu");
			System.out.println("=================================");
			System.out.println("1. Add Course");
			System.out.println("2. View All Courses");
			System.out.println("3. Search Course");
			System.out.println("4. Update Course");
			System.out.println("5. Delete Course");
			System.out.println("0. Back to Admin Menu");
			System.out.print("Enter your choice: ");

			int choice = -1;
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("❌ Invalid input, please enter a valid number.");
				continue;
			}

			switch (choice) {
				case 1:
					courseServices.addCourse();
					break;
				case 2:
					courseServices.getAllCourses();
					break;
				case 3:
					searchCourseMenu();
					break;
				case 4:
					courseServices.updateCourse();
					break;
				case 5:
					courseServices.deleteCourseById();
					break;
				case 0:
					System.out.println("✅ Returning to Admin Menu...");
					return;
				default:
					System.out.println("⚠️ Invalid choice, please try again.");
			}
		}
	}

	// ✅ Sub-menu for searching courses
	private static void searchCourseMenu() {
		while (true) {
			System.out.println("----------- Search Course -----------");
			System.out.println("1. Search by ID");
			System.out.println("2. Search by Name"); 
			System.out.println("0. Back");
			System.out.print("Enter your choice: ");

			int choice = -1;
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("❌ Invalid input.");
				continue;
			}

			switch (choice) {
				case 1:
					courseServices.getCourseById();
					break;
				case 2:
					courseServices.getCourseByName();
					break;
				case 0:
					return;
				default:
					System.out.println("⚠️ Invalid choice, please try again.");
			}
		}
	}
}
