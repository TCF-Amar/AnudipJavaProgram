package com.Student.Managment.services;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.Student.Managment.utils.HibernateUtils;
import com.Student.Managment.dao.CourseDAO;
import com.Student.Managment.models.Course;

public class CourseServices {
	private final Scanner sc = new Scanner(System.in);
	private final CourseDAO courseDao = new CourseDAO();

	// CREATE a course
	public void createCourse() {
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();

			System.out.print("Enter course name: ");
			String courseName = sc.nextLine();

			System.out.print("Enter course duration (in years): ");
			int duration = sc.nextInt();
			sc.nextLine(); // consume newline

			System.out.print("Enter course fees: ");
			long fees = sc.nextLong();
			sc.nextLine(); // consume newline

			Course exists = session.createQuery("FROM Course WHERE course_name = :course_name", Course.class)
					.setParameter("course_name", courseName).uniqueResult();

			if (exists != null) {
				System.out.println("⚠️ Course already exists.");
			} else {
				Course course = new Course();
				course.setCourse_name(courseName);
				course.setDuration(duration);
				course.setFees(fees);

				courseDao.saveCourse(course);
				System.out.println("✅ Course created successfully.");
			}
		} catch (Exception e) {
			System.err.println("❌ Error creating course: " + e.getMessage());
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void viewCourseById() {
		System.out.print("Enter course ID: ");
		int id = Integer.parseInt(sc.nextLine());

		Course course = courseDao.getCourseById(id);

		if (course != null) {
			System.out.println("\n📘 Course Details:");
			System.out.println("ID: " + course.getId());
			System.out.println("Name: " + course.getCourse_name());
			System.out.println("Duration: " + course.getDuration() + " months");
			System.out.println("Fees: ₹" + course.getFees());
		} else {
			System.out.println("❌ Course not found with ID: " + id);
		}
	}

	// VIEW all courses
	public void viewAllCourses() {
		List<Course> courses = courseDao.getAllCourses();
		if (courses.isEmpty()) {
			System.out.println("⚠️ No courses found.");
		} else {
			System.out.println("\n📋 Course List:");
			for (Course c : courses) {
				System.out.println("ID: " + c.getId() + ", Name: " + c.getCourse_name() + ", Duration: "
						+ c.getDuration() + " months" + ", Fees: ₹" + c.getFees());
			}
		}
	}

	// UPDATE a course
	public void updateCourse() {
		System.out.print("Enter Course ID to update: ");
		int id = sc.nextInt();
		sc.nextLine(); // consume newline

		Course course = courseDao.getCourseById(id);
		if (course == null) {
			System.out.println("❌ Course not found.");
			return;
		}

		System.out.print("Enter new course name: ");
		String newName = sc.nextLine();

		System.out.print("Enter new duration (months): ");
		int newDuration = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter new fees: ");
		long newFees = sc.nextLong();
		sc.nextLine();

		course.setCourse_name(newName);
		course.setDuration(newDuration);
		course.setFees(newFees);

		courseDao.updateCourse(course);
		System.out.println("✅ Course updated successfully.");
	}

	// DELETE a course
	public void deleteCourse() {
		System.out.print("Enter Course ID to delete: ");
		int id = sc.nextInt();
		sc.nextLine();

		Course course = courseDao.getCourseById(id);
		if (course == null) {
			System.out.println("❌ Course not found.");
			return;
		}

		courseDao.deleteCourse(id);
		System.out.println("🗑️ Course deleted successfully.");
	}
	
	
	public void enrolledStudentsInCourse() {
		System.out.print("Enter Course ID to view enrolled students: ");
		int courseId = sc.nextInt();
		sc.nextLine();

		Course course = courseDao.getCourseById(courseId);
		if (course == null) {
			System.out.println("❌ Course not found.");
			return;
		}
		List<String> studentNames = courseDao.getStudent1ByCourseId(courseId);
		if (studentNames.isEmpty()) {
			System.out.println("⚠️ No students enrolled in this course.");
		} else {
			System.out.println("\n📚 Enrolled Students in Course ID " + courseId + ":");
			for (String name : studentNames) {
				System.out.println("- " + name);
			}
		}
	}
	
	
}
