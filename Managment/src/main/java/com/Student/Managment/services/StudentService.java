package com.Student.Managment.services;

import com.Student.Managment.dao.StudentDAO;
import com.Student.Managment.models.Student;
import com.Student.Managment.utils.HibernateUtils;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

public class StudentService {

	private final Scanner sc = new Scanner(System.in);
	private final StudentDAO studentDAO = new StudentDAO();

	public void createStudent() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		System.out.println("🧑 Enter Student Name:");
		String name = sc.nextLine();

		System.out.println("📧 Enter Student Email:");
		String email = sc.nextLine();

		Student studentExists = new Student();

		studentExists = session.createQuery("From Student WHERE email=:email", Student.class)
				.setParameter("email", email).uniqueResult();
		if (studentExists != null) {
			System.out.println("Student Already Exists");
		} else {

			Student student = new Student();
			student.setName(name);
			student.setEmail(email);

			studentDAO.saveStudent(student);
		}
	}

	public void updateStudent() {
		System.out.println("✏️ Enter Student ID to Update:");
		int id = Integer.parseInt(sc.nextLine());

		Student student = studentDAO.getStudentById(id);
		if (student == null) {
			System.out.println("❌ Student not found.");
			return;
		}

		System.out.print("New Name (" + student.getName() + "): ");
		String name = sc.nextLine();
		if (!name.isEmpty())
			student.setName(name);

		System.out.print("New Email (" + student.getEmail() + "): ");
		String email = sc.nextLine();
		if (!email.isEmpty())
			student.setEmail(email);

		studentDAO.updateStudent(student);
	}

	public void deleteStudent() {
		System.out.println("🗑️ Enter Student ID to Delete:");
		int id = Integer.parseInt(sc.nextLine());
		studentDAO.deleteStudent(id);
	}

	public void viewStudentById() {
		System.out.println("🔍 Enter Student ID:");
		int id = Integer.parseInt(sc.nextLine());
		Student student = studentDAO.getStudentById(id);
		if (student != null) {
			System.out.println("📄 Student ID: " + student.getId());
			System.out.println("Name: " + student.getName());
			System.out.println("Email: " + student.getEmail());
		} else {
			System.out.println("❌ Student not found.");
		}
	}

	public void viewAllStudents() {
		List<Student> student = studentDAO.getAllStudents();
		if (student != null && !student.isEmpty()) {
			System.out.println("\n📋 All Students:");
			for (Student s : student) {
				System.out.println("ID: " + s.getId() + " | Name: " + s.getName() + " | Email: " + s.getEmail());
			}
		} else {
			System.out.println("📭 No students found.");
		}
	}

	public void enrollStudentInCourse() {
		System.out.println("Enter Student ID:");
		int studentId = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Course ID:");
		int courseId = Integer.parseInt(sc.nextLine());
		studentDAO.enrollStudentInCourse(studentId, courseId);
	}
}
