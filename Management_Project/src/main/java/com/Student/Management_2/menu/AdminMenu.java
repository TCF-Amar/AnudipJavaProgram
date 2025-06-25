package com.Student.Management_2.menu;

import java.util.Scanner;
import com.Student.Management_2.services.AuthServices;

public class AdminMenu {

    private static final Scanner sc = new Scanner(System.in);
    private static final AuthServices authServices = new AuthServices(); // ideally injected/shared

    public static void show() {
        while (true) {
            System.out.println("=================================");
            System.out.println("Welcome to Admin Menu");
            System.out.println("=================================");
            System.out.println("1. Manage Teachers");
            System.out.println("2. Manage Students");
            System.out.println("3. Manage Courses");
            System.out.println("4. View Reports");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");

            int choice = -1;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    AdminTeacherMenu.show();
                    break;
                case 2:
                    AdminStudentMenu.show();
                    break;
                case 3:
                    AdminCourseMenu.show();
                    break;
                case 4:
                    System.out.println("Showing reports...");
                    break;
                case 0:
                    System.out.println("==================================");
                    System.out.println("Logged out successfully: " + authServices.getAdmin());
                    System.out.println("==================================");
                    return;
                default:
                    System.out.println("==================================");
                    System.out.println("Invalid choice, please try again.");
                    System.out.println("==================================");
            }

            System.out.println(); // spacing for clarity
        }
    }
}
