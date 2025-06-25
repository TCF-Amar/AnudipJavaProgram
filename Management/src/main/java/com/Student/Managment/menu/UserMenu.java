package com.Student.Managment.menu;

import java.util.Scanner;

import com.Student.Managment.services.UserServices;

public class UserMenu {
private final UserServices us = new  UserServices();

	private final Scanner sc = new Scanner(System.in);
	public void showUsermenu() {
		
		while (true) {

			System.out.println("\nUser Menu");
			System.out.println("1. Add new Teacher");
			System.out.println("2. Update Teacher");
			System.out.println("3. Delete Teacher");
			System.out.println("4. View Teacher by ID");
			System.out.println("5. View All Teachers");
			System.out.println("6. Back");
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
				us.registerService();
				break;
			case 2:
				us.updateTeacher();
				break;
			case 3:
			
				us.deleteUser();
				break;
			case 4:
				us.viewUserById();
				break;
			case 5:
				us.viewAllUsers();
				break;
			case 6: {
				System.out.println("🔙 Returning to previous menu...");
				return;
			}
			default:
				System.out.println("❌ Invalid choice. Please try again.");
				break;
			}
		}
	}

}
