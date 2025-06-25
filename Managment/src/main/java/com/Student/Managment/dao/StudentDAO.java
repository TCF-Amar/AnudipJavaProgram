package com.Student.Managment.dao;

import com.Student.Managment.models.Student;
import com.Student.Managment.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {

    @SuppressWarnings("deprecation")
    public void saveStudent(Student student) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            tx = session.beginTransaction();

            session.save(student);

            tx.commit();
            System.out.println("✅ Student saved successfully.");
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback(); // only rollback if still active
            }
            System.out.println("❌ Failed to save student: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close(); // close safely
            }
        }
    }


    @SuppressWarnings("deprecation")
	public void updateStudent(Student student) {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(student);
            tx.commit();
            System.out.println("✅ Students updated successfully.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
	public void deleteStudent(int studentId) {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Student Student = session.get(Student.class, studentId);
            if (Student != null) {
                session.delete(Student);
                System.out.println("🗑️ Students deleted successfully.");
            } else {
                System.out.println("❌ Students not found.");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public Student getStudentById(int studentId) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(Student.class, studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> getAllStudents() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // enroll student courses (Many to Many)
    public void enrollStudentInCourse(int studentId, int courseId) {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            Course course = session.get(Course.class, courseId);
            if (student != null && course != null) {
                student.getCourses().add(course);
                course.getStudents().add(student); 
                session.update(student);
                session.update(course);
                tx.commit();
                System.out.println("✅ Student enrolled in course successfully.");
            } else {
                System.out.println("❌ Student or course not found.");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
