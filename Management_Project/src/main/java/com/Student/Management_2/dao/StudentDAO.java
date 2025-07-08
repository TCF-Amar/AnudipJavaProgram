package com.Student.Management_2.dao;

import java.time.LocalDateTime;
import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Student.Management_2.enums.FeeStatus;
import com.Student.Management_2.models.Course;
import com.Student.Management_2.models.Fees;
import com.Student.Management_2.models.Student;
import com.Student.Management_2.utils.HibernateUtils;

public class StudentDAO {

	private static final Scanner sc = new Scanner(System.in);
	private List<Student> students = new ArrayList<>();

	// ✅ CREATE
	@SuppressWarnings("deprecation")
	public Boolean createStudent(String name, String email) {
	    Session session = null;
	    Transaction tx = null;

	    try {
	        session = HibernateUtils.getSessionFactory().openSession();
	        tx = session.beginTransaction();

	        Student student = new Student();
	        student.setName(name);
	        student.setEmail(email);

	        // Show available courses
	        System.out.println("Courses");
	        System.out.println("---------------------");
	        List<Course> courses = session.createQuery("FROM Course", Course.class).list();
	        for (Course c : courses) {
	            System.out.println(c.getId() + "\t" + c.getCourseName() + "\t₹" + c.getFeesAmaount());
	        }

	        System.out.print("Enter Course ID to assign to the student: ");
	        Integer courseId = sc.nextInt();
	        sc.nextLine();

	        Course selectedCourse = session.get(Course.class, courseId);
	        if (selectedCourse == null) {
	            System.out.println("❌ Invalid Course ID.");
	            return false;
	        }

	        student.setCourse(selectedCourse);

	        Double feesAmount = selectedCourse.getFeesAmaount();
	        System.out.println("Fees for the selected course: ₹" + feesAmount);

	        System.out.print("Enter Paid Amount: ");
	        Double paidAmount = sc.nextDouble();
	        sc.nextLine();

	        Double dueAmount = feesAmount - paidAmount;
	        String status;
	        if (paidAmount <= 0) {
	            status = "due";
	        } else if (dueAmount <= 0) {
	            status = "paid";
	        } else {
	            status = "partial";
	        }

	        System.out.println("Due Amount: ₹" + dueAmount);
	        System.out.println("Status: " + status);

	        // Create Fees object
	        Fees fee = new Fees();
	        fee.setAmount(feesAmount);
	        fee.setPaidAmount(paidAmount);
	        fee.setDueAmount(dueAmount);
	        fee.setStatus(FeeStatus.valueOf(status.toUpperCase()));
	        fee.setPaymentDate(LocalDateTime.now()); // Use LocalDate for date

	        // Set relationship
	        fee.setStudent(student);
	        student.setFees(fee);

	        // Save student (fees will be saved via cascade)
	        session.save(student);
	        tx.commit();

	        System.out.println("✅ Student and Fees saved successfully.");
	        return true;

	    } catch (Exception e) {
	        e.printStackTrace();  // Important for debugging
	        return false;

	    } finally {
	        if (tx != null && tx.isActive()) {
	            tx.rollback();
	        }
	        if (session != null) {
	            session.close();
	        }
	    }
	}


	// ✅ READ by ID
	public Student getStudentById(int id) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Student student = session.get(Student.class, id);
			if (student != null) {
				System.out.println("------------------------------------------");
				System.out.println("✅ Student found: " + student.getName());
				System.out.println("------------------------------------------");
			} else {
				System.out.println("------------------------------------------");
				System.out.println("❌ No student found with ID: " + id);
				System.out.println("------------------------------------------");
			}
			return student;
		} catch (HibernateException e) {
			System.out.println("------------------------------------------");
			System.out.println("❌ Error retrieving student: " + e.getMessage());
			System.out.println("------------------------------------------");
			return null;
		}
	}

	// ✅ READ by Email
	public Student getStudentByEmail(String email) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Student student = session.createQuery("FROM Student WHERE email = :email", Student.class)
					.setParameter("email", email).uniqueResult();

			if (student == null) {
				System.out.println("------------------------------------------");
				System.out.println("❌ No student found with email: " + email);
				System.out.println("------------------------------------------");
			}
			return student;
		} catch (HibernateException e) {
			System.out.println("------------------------------------------");
			System.out.println("❌ Error retrieving student by email: " + e.getMessage());
			System.out.println("------------------------------------------");
			return null;
		}
	}

	// ✅ READ ALL
	public List<Student> getAllStudents() {
		Session session = null;
		List<Student> students = new ArrayList<>();
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			students = session.createQuery("FROM Student", Student.class).list();
			if (students.isEmpty()) {
				System.out.println("------------------------------------------");
				System.out.println("❌ No students found.");
				System.out.println("------------------------------------------");

			} else {
				System.out.println("------------------------------------------");
				System.out.println("✅ Students retrieved successfully.");

				System.out.println("------------------------------------------");
			}
		} catch (HibernateException e) {
			System.out.println("------------------------------------------");
			System.out.println("❌ Error retrieving students: " + e.getMessage());
			System.out.println("------------------------------------------");
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return students;
	}

	// ✅ UPDATE
	@SuppressWarnings("deprecation")
	public Boolean updateStudent(int id, String newName, String newEmail, int newCourseId) {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();

			Student student = session.get(Student.class, id);
			if (student == null) {
				System.out.println("❌ Student not found with ID: " + id);
				return false;
			}

			Course newCourse = session.get(Course.class, newCourseId);
			if (newCourse == null) {
				System.out.println("❌ Invalid course ID: " + newCourseId);
				return false;
			}

			student.setName(newName);
			student.setEmail(newEmail);
			student.setCourse(newCourse);

			session.update(student);
			tx.commit();
			return true;

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("------------------------------------------");
			System.out.println("❌ Error updating student: " + e.getMessage());
			System.out.println("------------------------------------------");
			return false;
		}
	}

	// ✅ DELETE
	@SuppressWarnings("deprecation")
	public Boolean deleteStudentById(int id) {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();

			Student student = session.get(Student.class, id);
			if (student == null) {
				System.out.println("❌ Student not found with ID: " + id);
				return false;
			}

			session.delete(student);
			tx.commit();
			return true;

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("------------------------------------------");
			System.out.println("❌ Error deleting student: " + e.getMessage());
			System.out.println("------------------------------------------");
			return false;
		}
	}

	public List<Student> getStudentByName(String name) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			List<Student> students = session.createQuery("FROM Student WHERE name LIKE :name", Student.class)
					.setParameter("name", "%" + name + "%").list();

			return students;
		} catch (HibernateException e) {
			System.out.println("------------------------------------------");
			System.out.println("❌ Error retrieving students by name: " + e.getMessage());
			System.out.println("------------------------------------------");
			return new ArrayList<>();
		}
	}
	
	  public List<Student> getStudentsByCourseId(int courseId) {
	      Session session = HibernateUtils.getSessionFactory().openSession();  
		  List<Student> result = session.createQuery("FROM Student WHERE course.id = :courseId", Student.class)
	              .setParameter("courseId", courseId)
	              .list();
	        for (Student s : students) {
	            if (s.getCourseId() == courseId) {
	                result.add(s);
	            }
	        }
	        return result;
	    }

}
