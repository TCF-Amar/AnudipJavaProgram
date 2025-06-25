package com.Student.Managment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Student.Managment.utils.HibernateUtils;
import com.Student.Managment.models.Course;
import com.Student.Managment.models.Student;

public class CourseDAO {

	// CREATE
	@SuppressWarnings("deprecation")
	public void saveCourse(Course course) {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.save(course);
			tx.commit();
			System.out.println("✅ Course saved successfully.");
		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			System.err.println("❌ Failed to save course: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// READ (by ID)
	public Course getCourseById(int id) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			return session.get(Course.class, id);
		} catch (Exception e) {
			System.err.println("❌ Failed to fetch course: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	// READ (all)
	public List<Course> getAllCourses() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Query<Course> query = session.createQuery("FROM Course", Course.class);
			return query.getResultList();
		} catch (Exception e) {
			System.err.println("❌ Failed to fetch courses: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	// UPDATE
	@SuppressWarnings("deprecation")
	public void updateCourse(Course course) {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.update(course);
			tx.commit();
			System.out.println("✅ Course updated successfully.");
		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			System.err.println("❌ Failed to update course: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// DELETE
	@SuppressWarnings("deprecation")
	public void deleteCourse(int id) {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			Course course = session.get(Course.class, id);
			if (course != null) {
				session.delete(course);
				System.out.println("✅ Course deleted successfully.");
			} else {
				System.out.println("⚠️ Course not found for ID: " + id);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			System.err.println("❌ Failed to delete course: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public List<String> getStudent1ByCourseId(int courseId) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Course course = session.get(Course.class, courseId);
			if(course == null) {
				return List.of();
			} 
			return course.getStudents().stream().map(Student::getName).toList();
		} catch (Exception e) {
			e.printStackTrace();
			return List.of();
			
		}

	}
}
