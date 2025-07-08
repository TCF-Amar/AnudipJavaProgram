package com.Student.Management_2.services;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.Student.Management_2.dao.AttandanceDAO;
import com.Student.Management_2.dao.CourseDAO;
import com.Student.Management_2.dao.StudentDAO;
import com.Student.Management_2.models.Attandence;
import com.Student.Management_2.models.Course;
import com.Student.Management_2.models.Student;
import com.Student.Management_2.utils.HibernateUtils;

public class AttendanceServices {

	@SuppressWarnings("unused")
	private final CourseDAO courseDAO;
	private final StudentDAO studentDAO;
	private final AttandanceDAO attendanceDAO;

	public AttendanceServices() {
		this.courseDAO = new CourseDAO();
		this.studentDAO = new StudentDAO();
		this.attendanceDAO = new AttandanceDAO();
	}

	public AttendanceServices(CourseDAO courseDAO, StudentDAO studentDAO, AttandanceDAO attendanceDAO) {
		this.courseDAO = courseDAO;
		this.studentDAO = studentDAO;
		this.attendanceDAO = attendanceDAO;
	}

	// ✅ 1. Take Attendance
	@SuppressWarnings({ "resource", "unused" })
	public void takeAttendanceForCourse() {
		Scanner scanner = new Scanner(System.in);

		Session s = HibernateUtils.getSessionFactory().openSession();

		CourseDAO courseDAO = new CourseDAO();
		List<Course> cuorse = courseDAO.getAllCourses();
		for (Course course : cuorse) {
			System.out.println("Course ID: " + course.getId() + ", Course Name: " + course.getCourseName());
		}

		System.out.print("Enter Course ID to take attendance: ");
		int courseId = scanner.nextInt();
		scanner.nextLine();

		List<Student> students = studentDAO.getStudentsByCourseId(courseId);

		if (students.isEmpty()) {
			System.out.println("No students found in this course.");
			return;
		}

		for (Student student : students) {
			System.out.print("Name: " + student.getName() + " (P/A): ");
			String status = scanner.nextLine().trim().toUpperCase();
			if (!status.equals("P") && !status.equals("A")) {
				System.out.println("Invalid input, marking Absent.");
				status = "A";
			}
			attendanceDAO.markAttendance(student, courseId, status);
		}

		System.out.println("Attendance taken successfully!");
	}

	// ✅ 2. Get Attendance By Student ID
	public void getAttendanceByStudentId() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Student ID: ");
		int studentId = sc.nextInt();

		List<Attandence> records = attendanceDAO.getAttendanceByStudentId(studentId);

		if (records.isEmpty()) {
			System.out.println("No attendance found for this student.");
		} else {
			for (Attandence att : records) {
				System.out.println(att.getStudent().getName() + "- " + att.getDate() + " - Course ID: "
						+ att.getCourseId() + " - Status: " + att.getStatus());
			}
		}
	}

	// ✅ 3. Update Attendance Status
	public void updateAttendanceStatus() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Attendance ID to update: ");
		int attendanceId = sc.nextInt();
		sc.nextLine(); // consume \n
		System.out.print("Enter new status (P/A): ");
		String newStatus = sc.nextLine().trim().toUpperCase();

		boolean success = attendanceDAO.updateStatusById(attendanceId, newStatus);
		if (success) {
			System.out.println("Attendance updated successfully.");
		} else {
			System.out.println("Attendance record not found.");
		}
	}

	// ✅ 4. Delete Attendance By ID
	public void deleteAttendanceById() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Attendance ID to delete: ");
		int id = sc.nextInt();

		boolean success = attendanceDAO.deleteAttendanceById(id);
		if (success) {
			System.out.println("Attendance deleted successfully.");
		} else {
			System.out.println("Attendance not found.");
		}
	}

	// ✅ 5. View All Attendance
	public void viewAllAttendance() {
		
		// Fetch all attendance records for the given course ID
		
		List<Attandence> records = attendanceDAO.getAllAttendance();
		if (records.isEmpty()) {
			System.out.println("No attendance records found.");
		} else {
			for (Attandence att : records) {
				System.out.println(att.getStudent().getName() + " - Course ID: " + att.getCourseId() + " - Status: "
						+ att.getStatus());
			}
		}
	}
	// ✅ 6. Get Attendance By Course and Date
	public void getAttendanceByDate() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Date (YYYY-MM-DD): ");
		String date = sc.nextLine();

		List<Attandence> records = attendanceDAO.getAttendanceByCourseAndDate( date);

		if (records.isEmpty()) {
			System.out.println("No attendance found for this course on the given date.");
		} else {
			for (Attandence att : records) {
				System.out.println(att.getStudent().getName() + " - Status: " + att.getStatus());
			}
		}
	}
}
