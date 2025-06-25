package com.Student.Management_2.menu;

import java.util.Scanner;

import com.Student.Management_2.services.StudentServices;

public class AdminStudentMenu {

	private static final StudentServices ss = new StudentServices();
	private static final Scanner sc = new Scanner(System.in);
 
	public static void show() {
		while (true) {
			System.out.println("=================================");
			System.out.println("👨‍🎓 Welcome to Admin Student Menu");
			System.out.println("=================================");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Search Student");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("0. Back to Main Menu");
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
					ss.createStudentServices();
					break;
				case 2:
					ss.getAllStudentsService();
					break;
				case 3:
					searchStudentSubMenu();
					break;
				case 4:
					ss.updateStudentService();
					break;
				case 5:
					ss.deleteStudentService();
					break;
				case 0:
					System.out.println("✅ Logged out successfully.");
					return;
				default:
					System.out.println("⚠️ Invalid choice, please try again.");
			}
		}
	}

	// ✅ Sub-menu for searching student
	private static void searchStudentSubMenu() {
		while (true) {
			System.out.println("----------- Search Student -----------");
			System.out.println("1. Search by ID");
			System.out.println("2. Search by Email");
			System.out.println("3. Search by Name");
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
					ss.getStudentByIdService();
					break;
				case 2:
					ss.getStudentByEmailService();
					break;
				case 3:
					ss.getStudentByNameService();
					break;
				case 0:
					return;
				default:
					System.out.println("⚠️ Invalid choice, please try again.");
			}
		}
	}
}
