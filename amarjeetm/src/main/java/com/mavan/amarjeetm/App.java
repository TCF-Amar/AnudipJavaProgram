package com.mavan.amarjeetm;

import java.util.Scanner;

import com.mavan.amarjeetm.services.UserServices;

public class App {
	public static void main(String[] args) {
		UserServices us = new UserServices();
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("1. Get All Users");
			System.out.println("2. Add New User ");
			System.out.println("3. Get User By Id ");
			System.out.println("4. Update User By Id");
			System.out.println("5. Delete User By Id");
			System.out.println("6. Login User ");

			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				us.getAllUsers();
				break;
			case 2:
				sc.nextLine(); 
				System.out.print("Enter User Name: ");
				String name = sc.nextLine();
				System.out.print("Enter User Email: ");
				String email = sc.nextLine();
				System.out.print("Enter User Password: ");

				String password = sc.nextLine();
				us.addNewUser( name, email, password);
				break;
			case 3:
				System.out.print("Enter User Id: ");
				int getId = sc.nextInt();
				us.getUserById(getId);
				break;
			case 4:
				System.out.print("Enter User Id to update: ");
				int updateId = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter New User Name: ");
				String newName = sc.nextLine();
				System.out.print("Enter New User Email: ");
				String newEmail = sc.nextLine();
				
				us.updateUserById(updateId, newName, newEmail);
				break;
			case 5:
				System.out.print("Enter User Id to delete: ");
				int deleteId = sc.nextInt();
				us.deleteUserById(deleteId);
				break;
				
			case 6:
				sc.nextLine(); 
				System.out.print("Enter User Email: ");
				String email1 = sc.nextLine();
				System.out.print("Enter User Password: ");
				String password1 = sc.nextLine();
				us.loginUser(email1, password1);
				break;
			case 0:
				System.out.println("Exiting...");
				sc.close();
				System.exit(0);
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}

	}
}
