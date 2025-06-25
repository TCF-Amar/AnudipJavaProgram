package com.Student.Management_2.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Student.Management_2.models.Course;
import com.Student.Management_2.utils.HibernateUtils;

public class CourseDAO {

    @SuppressWarnings("deprecation")
    public boolean addCourse(String courseName, Integer duration, Long fees) {
        Transaction tx = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Course existing = session.createQuery("FROM Course WHERE courseName = :courseName", Course.class)
                    .setParameter("courseName", courseName)
                    .uniqueResult();

            if (existing != null) {
                return false; // Course already exists
            }

            Course course = new Course();
            course.setCourseName(courseName);
            course.setDuration(duration);
            course.setFees(fees);

            session.save(course);
            tx.commit();

            return true; // Course added successfully

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // ✅ Get course by ID
    public Course getCourseById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(Course.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ✅ Get course by Name
    public Course getCourseByName(String courseName) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Course WHERE courseName = :courseName", Course.class)
                    .setParameter("courseName", courseName)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ✅ Get all courses
    public List<Course> getAllCourses() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Course", Course.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ✅ Update course by ID
    @SuppressWarnings("deprecation")
	public boolean updateCourse(Long id, String newCourseName, Integer newDuration, Long newFees) {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Course course = session.get(Course.class, id);
            if (course == null) return false;

            course.setCourseName(newCourseName);
            course.setDuration(newDuration);
            course.setFees(newFees);

            session.update(course);
            tx.commit();

            return true;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // ✅ Delete course by ID
    @SuppressWarnings("deprecation")
	public boolean deleteCourseById(Long id) {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Course course = session.get(Course.class, id);
            if (course == null) return false;

            session.delete(course);
            tx.commit();

            return true;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
