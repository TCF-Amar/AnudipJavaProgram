package com.Student.Managment.menu;

import java.util.Scanner;

import com.Student.Managment.services.CourseServices;

public class CourseMenu {

	private final Scanner sc = new Scanner(System.in);
	private final CourseServices courseService = new CourseServices();
	
	
	public void showCourseMenu() {
		while(true) {
			System.out.println("\nCourse Menu");
			System.out.println("1. Add Course");
			System.out.println("2. Update Course");
			System.out.println("3. Delete Course");
			System.out.println("4. View Course by ID");
			System.out.println("5. View All Courses");
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
					courseService.createCourse();
					break;
				case 2:
					courseService.updateCourse();
					break;
				case 3:
					courseService.deleteCourse();
					break;
				case 4:
					courseService.viewCourseById();
					break;
				case 5:
					courseService.viewAllCourses();
					break;
				case 6: {
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
