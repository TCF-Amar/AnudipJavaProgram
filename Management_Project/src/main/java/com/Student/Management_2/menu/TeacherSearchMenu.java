package com.Student.Management_2.menu;

import java.util.Scanner;
import com.Student.Management_2.services.TeacherServices;

public class TeacherSearchMenu {

	private final Scanner sc = new Scanner(System.in);
	private final TeacherServices teacherServices = new TeacherServices();

	public void show() {
		while (true) {
			System.out.println("=================================");
			System.out.println("Welcome to Teacher Search Menu");
			System.out.println("=================================");
			System.out.println("1. Search Teacher by Name");
			System.out.println("2. Search Teacher by Email");
			System.out.println("3. Search Teacher by ID");
			System.out.println("0. <-- Back");
			System.out.print("Enter your choice: ");

			int choice;
			try {
				choice = sc.nextInt();
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, please enter a number.");
				continue;
			}

			switch (choice) {
			case 1:
				teacherServices.getTeachersByName();
				break;
			case 2:
				teacherServices.getTeacherByEmail();
				break;
			case 3:
				teacherServices.getTeacherById();
				break;
			case 0:
				System.out.println("=================================");
				System.out.println("Returning to main menu...");
				System.out.println("=================================");
				return;
			default:
				System.out.println("=================================");
				System.out.println("Invalid choice, please try again.");
				System.out.println("=================================");
				break;
			}

			System.out.println(); // Add space after each operation
		}
	}
}
