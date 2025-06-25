package com.Student.Managment.menu;

import java.util.Scanner;

import com.Student.Managment.services.StudentService;

public class StudentMenu {
	private final Scanner sc = new Scanner(System.in);

	private final StudentService studentService = new StudentService();

	public void showStudentMenu() {
		while (true) {
			System.out.println("\n👨‍🎓 Student Management");
			System.out.println("1. Add Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. View Student by ID");
			System.out.println("5. View All Students");
			System.out.println("6. Enroll Student in Course");
			System.out.println("7. View Enrolled Courses");
			System.out.println("0. Back");
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
				studentService.createStudent();
				break;
			case 2:
				studentService.updateStudent();
				break;
			case 3:
				studentService.deleteStudent();
				break;
			case 4:
				studentService.viewStudentById();
				break;
			case 5:
				studentService.viewAllStudents();
				break;
			case 6:
				studentService.enrollStudentInCourse();
				break;
			case 7:
				studentService.viewEnrolledCourses();
				break;
			case 0: {
				System.out.println("🔙 Returning to Admin Menu...");
				return;
			}
			default:
				System.out.println("❌ Invalid choice. Please try again.");
				break;
			}
		}
	}
}
