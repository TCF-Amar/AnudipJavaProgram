package com.Student.Management_2.menu;

import java.util.Scanner;

import com.Student.Management_2.services.CourseServices;
import com.Student.Management_2.services.StudentServices;

public class TeacherMenu {

	private static final Scanner sc = new Scanner(System.in);
	private static final StudentServices studentServices = new StudentServices();
	private static final CourseServices courseServices = new CourseServices();

	public static void show() {
		while (true) {
			System.out.println("=================================");
			System.out.println("👨‍🏫 Welcome to Teacher Menu");
			System.out.println("=================================");
			System.out.println("1. View Profile");
			System.out.println("2. View All Courses");
			System.out.println("3. View All Students");
			System.out.println("4. Search Student");
			System.out.println("5. Search Course");
			System.out.println("0. Logout");
			System.out.print("Enter your choice: ");

			int choice = -1;
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("❌ Invalid input, please enter a number.");
				continue;
			}

			switch (choice) {
			case 1:
				// 🔒 TODO: View teacher profile (when teacher login implemented)
				System.out.println("🔒 View profile is under construction.");
				break;
			case 2:
				courseServices.getAllCourses();
				break;
			case 3:
				studentServices.getAllStudentsService();
				break;
			case 4:
				searchStudent();
				break;
			case 5:
				searchCourse();
				break;
			case 0:
				System.out.println("✅ Logged out successfully.");
				return;
			default:
				System.out.println("⚠️ Invalid choice, please try again.");
				break;
			}
		}
	}

	// ✅ Search student by name or email
	public static void searchStudent() {
		while (true) {
			System.out.println("---- Search Student ----");
			System.out.println("1. By Name");
			System.out.println("2. By Email");
			System.out.println("0. back");
			System.out.print("Enter choice: ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1:
				studentServices.getStudentByNameService();
				break;
			case 2:
				studentServices.getStudentByEmailService();
				break;
			case 0:
				return;
			default:
				System.out.println("⚠️ Invalid choice.");
				break;
			}
		}
	}

	// ✅ Search course by ID or name
	public static void searchCourse() {
		while (true) {

			System.out.println("---- Search Course ----");
			System.out.println("1. By ID");
			System.out.println("2. By Name");
			System.out.println("0. Back");
			System.out.print("Enter choice: ");
			int choice = Integer.parseInt(sc.nextLine());

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
				System.out.println("⚠️ Invalid choice.");
				break;
			}
		}
	}

}
