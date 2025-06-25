package com.Student.Management_2.services;

import java.util.List;
import java.util.Scanner;

import com.Student.Management_2.dao.TeacherDAO;
import com.Student.Management_2.models.Teacher;

public class TeacherServices {

	private final Scanner sc = new Scanner(System.in);
	private final TeacherDAO teacherDAO = new TeacherDAO();

	public void createTeacher() {

		System.out.println("Enter teacher name: ");
		String name = sc.nextLine();
		System.out.println("Enter teacher email: ");
		String email = sc.nextLine();
		System.out.println("Enter teacher password: ");
		String password = sc.nextLine();

		Teacher teacher = new Teacher();
		teacher.setName(name);
		teacher.setEmail(email);
		teacher.setPassword(password);
		Boolean res = teacherDAO.addTeacher(teacher);

		if (res) {
			System.out.println("------------------------------");
			System.out.println("Teacher Added successfully!");
			System.out.println("------------------------------");
		} else {
			System.out.println("------------------------------");
			System.out.println("Somthing went wrong");
			System.out.println("------------------------------");

		}
	}

	public void getTeacherByEmail() {

		System.out.println("Enter teacher email to search: ");
		String email = sc.nextLine();
		Teacher teacher = teacherDAO.getTeacherByEmail(email);
		if (teacher != null) {
			System.out.println("----------------------------------------");
			print(teacher);
			System.out.println("----------------------------------------");

		} else {
			System.out.println("------------------------------------------");
			System.out.println("No teacher found with the provided email.");
			System.out.println("------------------------------------------");

		}

	}

	public void getTeachersByName() {
		System.out.println("Enter teacher name to search: ");
		String name = sc.nextLine();
		List<Teacher> teachers = teacherDAO.getTeachersByName(name);

		if (teachers.isEmpty()) {
			System.out.println("----------------------------------------");
			System.out.println("No teachers found with the provided name.");
			System.out.println("----------------------------------------");

		} else {
			System.out.println("----------------------------------------");
			for (Teacher teacher : teachers) {
				print(teacher);
			}
			System.out.println("----------------------------------------");

		}
	}

	public void getTeacherById() {

		System.out.println("Enter teacher ID to search: ");
		int id = -1;
		try {
			id = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("------------------------------");
			System.out.println("Invalid input, please enter a valid ID.");
			System.out.println("------------------------------");

			return;
		}

		Teacher teacher = teacherDAO.getTeacherById(id);
		if (teacher != null) {
			System.out.println("----------------------------------------");

			print(teacher);
			System.out.println("----------------------------------------");

		} else {
			System.out.println("------------------------------");
			System.out.println("No teacher found with the provided ID.");
			System.out.println("------------------------------");

		}
	}

	public void getAllTeacherServices() {

		List<Teacher> teachers = teacherDAO.getAllTeachers();
		if (teachers.isEmpty()) {
			System.out.println("------------------------------");
			System.out.println("No teachers found.");
			System.out.println("------------------------------");

		} else {
			System.out.println("----------------------------------------");

			for (Teacher teacher : teachers) {
				print(teacher);
			}
			System.out.println("----------------------------------------");

		}
	}

	public void teacherUpdateServices() {
		System.out.println("Enter email of the teacher to update: ");
		String email = sc.nextLine();
		Boolean res = teacherDAO.updateTeacher(email);
		if (res) {
			System.out.println("----------------------------------------");
			System.out.println("Updated Success fully");
			System.out.println("----------------------------------------");
		} else {
			System.out.println("----------------------------------------");
			System.out.println("Somting went wrong");
			System.out.println("----------------------------------------");

		}

	}

	public void deleteTeacherServices() {
		System.out.println("Enter teacher ID to delete: ");
		int id = -1;
		try {
			id = sc.nextInt();
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, please enter a valid ID.");
			return;
		}

		Boolean res = teacherDAO.deleteTeacher(id);

		if (res) {
			System.out.println("----------------------------------------");
			System.out.println("Deleted success fully");
			System.out.println("----------------------------------------");

		} else {
			System.out.println("----------------------------------------");
			System.out.println("Somthing went wrong");
			System.out.println("----------------------------------------");

		}
	}

	public void print(Teacher t) {
		System.out.println("ID:" + t.getId() + "\tName: " + t.getName() + "\tEmail:" + t.getEmail() );

	}

}
