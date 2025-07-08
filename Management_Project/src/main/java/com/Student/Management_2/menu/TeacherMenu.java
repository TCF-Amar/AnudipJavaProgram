package com.Student.Management_2.menu;

import java.util.Scanner;

import com.Student.Management_2.services.AttendanceServices;
import com.Student.Management_2.services.CourseServices;
import com.Student.Management_2.services.StudentServices;

public class TeacherMenu {

	private static final Scanner sc = new Scanner(System.in);
	private static final StudentServices studentServices = new StudentServices();
	private static final CourseServices courseServices = new CourseServices();
	private static final AttendanceServices attendanceServices = new AttendanceServices();

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
			System.out.println("6. Track Attendance ");
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
			case 6:
				attendanceManagementMenu();
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

	// ✅ Attendance Management Submenu
	public static void attendanceManagementMenu() {
		while (true) {
			System.out.println("\n---- Attendance Management ----");
			System.out.println("1. Take Attendance for Course");
			System.out.println("2. View Attendance by Student ID");
			System.out.println("3. View All Attendance");
			System.out.println("4. Update Attendance Status");
			System.out.println("5. Delete Attendance");
			System.out.println("6. Get Attendance by  Date");
			System.out.println("0. Back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice;
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("❌ Invalid input. Please enter a number.");
				continue;
			}

			switch (choice) {
			case 1:
				attendanceServices.takeAttendanceForCourse();
				break;
			case 2:
				attendanceServices.getAttendanceByStudentId();
				break;
			case 3:
				attendanceServices.viewAllAttendance();
				break;
			case 4:
				attendanceServices.updateAttendanceStatus();
				break;
			case 5:
				attendanceServices.deleteAttendanceById();
				break;
			case 6:
				attendanceServices.getAttendanceByDate();
				break;
			case 0:
				return;
			default:
				System.out.println("⚠️ Invalid choice.");
			}
		}
	}

}
