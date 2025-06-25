package com.Student.Management_2.services;

import java.util.List;
import java.util.Scanner;

import com.Student.Management_2.dao.StudentDAO;
import com.Student.Management_2.models.Student;

public class StudentServices {

	private static final Scanner sc = new Scanner(System.in);
	private static final StudentDAO studentDAO = new StudentDAO();

	// ✅ CREATE
	public void createStudentServices() {
		System.out.print("Enter Student Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Student Email: ");
		String email = sc.nextLine();

		Boolean res = studentDAO.createStudent(name, email);
		if (res) {
			System.out.println("------------------------------------------");
			System.out.println("☑ Student added successfully.");
			System.out.println("------------------------------------------");
		} else {
			System.out.println("------------------------------------------");
			System.out.println("❌ Failed to add student.");
			System.out.println("------------------------------------------");
		}
	}

	// ✅ READ: Get by ID
	public void getStudentByIdService() {
		System.out.print("Enter Student ID: ");
		try {

			int id = Integer.parseInt(sc.nextLine());

			Student student = studentDAO.getStudentById(id);
			if (student != null) {
				System.out.println("------------------------------------------");
				printStudent(student);
				System.out.println("------------------------------------------");
			} else {
				System.out.println("------------------------------------------");
				System.out.println("Student not Found");
				System.out.println("------------------------------------------");

			}
		} catch (Exception e) {
			System.out.println("------------------------------------------");
			System.out.println("Invalid Input Format (1, 2, 3, 0)");
			System.out.println("------------------------------------------");
		}

	}

	// ✅ READ: Get by Email
	public void getStudentByEmailService() {
		System.out.print("Enter Student Email: ");
		String email = sc.nextLine();

		Student student = studentDAO.getStudentByEmail(email);
		if (student != null) {
			System.out.println("------------------------------------------");
			printStudent(student);
			System.out.println("------------------------------------------");
		} 

	}

	// ✅ READ: Get by Name (can return multiple students)
	public void getStudentByNameService() {
		System.out.print("Enter Student Name: ");
		String name = sc.nextLine();

		List<Student> students = studentDAO.getStudentByName(name);
		if (!students.isEmpty()) {
			System.out.println("------------------------------------------");
			for (Student s : students) {
				printStudent(s);
			}
			System.out.println("------------------------------------------");
		} else {
			System.out.println("------------------------------------------");
			System.out.println("Student not Found");
			System.out.println("------------------------------------------");

		}
	}

	// ✅ READ: Get all students
	public void getAllStudentsService() {
		List<Student> students = studentDAO.getAllStudents();
		if (!students.isEmpty()) {
			System.out.println("------------------------------------------");
			for (Student s : students) {
				printStudent(s);
			}
			System.out.println("------------------------------------------");
		}
	}

	// ✅ UPDATE
	public void updateStudentService() {
		System.out.print("Enter Student ID to update: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter new Name: ");
		String newName = sc.nextLine();

		System.out.print("Enter new Email: ");
		String newEmail = sc.nextLine();

		System.out.print("Enter new Course ID: ");
		int courseId = sc.nextInt();
		sc.nextLine();

		Boolean res = studentDAO.updateStudent(id, newName, newEmail, courseId);
		if (res) {
			System.out.println("------------------------------------------");
			System.out.println("☑ Student updated successfully.");
			System.out.println("------------------------------------------");
		} else {
			System.out.println("------------------------------------------");
			System.out.println("❌ Failed to update student.");
			System.out.println("------------------------------------------");
		}
	}

	// ✅ DELETE
	public void deleteStudentService() {
		System.out.print("Enter Student ID to delete: ");
		int id = sc.nextInt();
		sc.nextLine();

		Boolean res = studentDAO.deleteStudentById(id);
		if (res) {
			System.out.println("------------------------------------------");
			System.out.println("☑ Student deleted successfully.");
			System.out.println("------------------------------------------");
		} else {
			System.out.println("------------------------------------------");
			System.out.println("❌ Failed to delete student.");
			System.out.println("------------------------------------------");
		}
	}

	// 🔸 Helper method to print student details
	private void printStudent(Student s) {
		System.out.print("ID: " + s.getId());
		System.out.print("\tName: " + s.getName());
		System.out.print("\tEmail: " + s.getEmail());
		System.out.println("\tCourse: " + (s.getCourse() != null ? s.getCourse().getCourseName() : "None"));
	}
}
