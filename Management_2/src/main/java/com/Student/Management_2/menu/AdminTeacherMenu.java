package com.Student.Management_2.menu;

import java.util.Scanner;

import com.Student.Management_2.services.TeacherServices;

public class AdminTeacherMenu {

	private static final Scanner sc = new Scanner(System.in);

	public static void show() {
		while (true) {
			System.out.println("=================================");
			System.out.println("Welcome to Admin Teacher Menu");
			System.out.println("=================================");
			System.out.println("1. Add Teacher");
			System.out.println("2. View All Teachers");
			System.out.println("3. Search Teacher");
			System.out.println("4. Update Teacher");
			System.out.println("5. Delete Teacher");
			System.out.println("0. Back to Main Menu");
			System.out.print("Enter your choice: ");

			Integer choice = -1;

			try {
				choice = sc.nextInt();
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, please enter a number.");
				continue;
			}

			switch (choice) {
			case 1:
				new TeacherServices().createTeacher();
				break;
			case 3:
				new TeacherSearchMenu().show();
				break;
			case 2:
				new TeacherServices().getAllTeacherServices();
				break;
			case 4:
				new TeacherServices().teacherUpdateServices();
				break;
			case 5:
				new TeacherServices().deleteTeacherServices();
				break;
			case 0:
				System.out.println("==================================");
				System.out.println("Logged out successfully");
				System.out.println("==================================");
				return;
			default:
				System.out.println("----------------------------------");
				System.out.println("Invalid choice, please try again.");
				System.out.println("----------------------------------");
				break;
			}

		}
	}

}
