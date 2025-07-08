package com.Student.Management_2.services;

import java.util.List;
import java.util.Scanner;

import com.Student.Management_2.dao.CourseDAO;
import com.Student.Management_2.models.Course;

public class CourseServices {

	private static final Scanner sc = new Scanner(System.in);
	private final CourseDAO courseDAO = new CourseDAO();

	// ✅ 1. Add course
	public void addCourse() {
		System.out.print("Enter Course Name: ");
		String courseName = sc.nextLine();
 
		System.out.print("Enter Course Duration (in years): ");
		Integer duration = sc.nextInt();

		System.out.print("Enter Course Fees: ");
		Double fees = sc.nextDouble();
		sc.nextLine(); // Clear buffer

		Boolean res = courseDAO.addCourse(courseName, duration, fees);

		if (res) {
			System.out.println("------------------------------");
			System.out.println("✅ Course added successfully.");
			System.out.println("------------------------------");

		} else {
			System.out.println("------------------------------");
			System.out.println("⚠️ Course already exists.");
			System.out.println("------------------------------");

		}
	}

	// ✅ 2. Get course by ID
	public void getCourseById() {
		System.out.print("Enter Course ID: ");
		Long id = sc.nextLong();
		sc.nextLine();

		Course course = courseDAO.getCourseById(id);
		if (course != null) {
			System.out.println("--------+---------------+--------------+---------");
			System.out.println("Id\t|CourseName\t|Duration\t|Fees\t|");
			System.out.println("--------+---------------+--------------+---------");
			printCourse(course);
			System.out.println("--------+---------------+--------------+---------");
		} else {
			System.out.println("------------------------------");
			System.out.println("❌ Course not found.");
			System.out.println("------------------------------");

		}
	}

	// ✅ 3. Get course by Name
	public void getCourseByName() {
		System.out.print("Enter Course Name: ");
		String name = sc.nextLine();

		Course course = courseDAO.getCourseByName(name);
		if (course != null) {
			System.out.println("--------+---------------+--------------+---------");
			System.out.println("Id\t|CourseName\t|Duration\t|Fees\t");
			System.out.println("--------+---------------+--------------+---------");
			printCourse(course);
			System.out.println("--------+---------------+--------------+---------");
		} else {
			System.out.println("------------------------------");
			System.out.println("❌ Course not found.");
			System.out.println("------------------------------");
		}
	}

	// ✅ 4. Get all courses
	public void getAllCourses() {
		List<Course> list = courseDAO.getAllCourses();

		if (list != null && !list.isEmpty()) {
			System.out.println("--------+---------------+--------------+---------");
			System.out.println("Id\t|CourseName\t|Duration\t|Fees\t");
			System.out.println("--------+---------------+--------------+---------");
			for (Course c : list) {
				printCourse(c);
			}
			System.out.println("--------+---------------+--------------+---------");

		} else {
			System.out.println("------------------------------");
			System.out.println("⚠️ No courses available.");
			System.out.println("------------------------------");

		}

	}

	// ✅ 5. Update course
	public void updateCourse() {
		System.out.print("Enter Course ID to update: ");
		Long id = sc.nextLong();
		sc.nextLine();

		System.out.print("Enter new Course Name: ");
		String newName = sc.nextLine();

		System.out.print("Enter new Duration (in years): ");
		Integer newDuration = sc.nextInt();

		System.out.print("Enter new Fees: ");
		Double newFees = sc.nextDouble();
		sc.nextLine();

		Boolean updated = courseDAO.updateCourse(id, newName, newDuration, newFees);
		if (updated) {
			System.out.println("------------------------------");
			System.out.println("✅ Course updated successfully.");
			System.out.println("------------------------------");

		} else {
			System.out.println("------------------------------");
			System.out.println("❌ Failed to update course (maybe not found).");
			System.out.println("------------------------------");
		}
	}

	// ✅ 6. Delete course
	public void deleteCourseById() {
		System.out.print("Enter Course ID to delete: ");
		Long id = sc.nextLong();
		sc.nextLine();

		Boolean deleted = courseDAO.deleteCourseById(id);
		if (deleted) {
			System.out.println("------------------------------");
			System.out.println("✅ Course deleted successfully.");
			System.out.println("------------------------------");
		} else {
			System.out.println("------------------------------");
			System.out.println("❌ Course not found.");
			System.out.println("------------------------------");
		}
	}

	// 🔹 Helper method to display a course
	private void printCourse(Course c) {
		System.out.print(c.getId() + "\t|");
		System.out.print(c.getCourseName() + "\t\t|");
		System.out.print(c.getDuration() + " years" + "\t\t|");
		System.out.println("₹" + c.getFeesAmaount());
	}
}
