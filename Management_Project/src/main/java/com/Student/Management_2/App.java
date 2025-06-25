package com.Student.Management_2;

import java.util.Scanner;
import com.Student.Management_2.services.AuthServices;

public class App {

	private static final   Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        AuthServices authServices = new AuthServices(); // create only once

        while (true) {
            System.out.println("========================="); 
            System.out.println("        Login Menu       ");
            System.out.println("=========================");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Teacher");
            System.out.println("0. Exit");
            System.out.print("Enter Your Choice: ");

            int choice = -1;

            try {
                choice = Integer.parseInt(sc.nextLine()); // Use nextLine to avoid scanner bug
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    authServices.adminLogin();
                    break;
                case 2:
                    authServices.TeacherLogin();
                    break;
                case 0:
                    System.out.println("==========================");
                    System.out.println("Good Bye!");
                    System.out.println("==========================");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("==========================");
                    System.out.println("X Invalid Input");
                    System.out.println("==========================");
                    break;
            }

            System.out.println(); 
        }
    }
}
