package com.Student.Management_2.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Student.Management_2.models.Attandence;
import com.Student.Management_2.models.Student;
import com.Student.Management_2.utils.HibernateUtils;

public class AttandanceDAO {

	// ✅ 1. Mark Attendance
	@SuppressWarnings("deprecation")
	public void markAttendance(Student student, int courseId, String status) {
		Transaction tx = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();

			Attandence attendance = new Attandence();
//            date in format yyyy-MM-dd
			Date date = new Date();
			String formattedDate = String.format("%1$td-%1$tm-%1$tY", date);
			attendance.setDate(formattedDate);
			attendance.setStatus(status);
			attendance.setStudent(student);

			session.save(attendance);
			tx.commit();

			System.out.println("Attendance marked for Student ID: " + student.getStudentId() + ", Course ID: "
					+ courseId + ", Status: " + status);
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	// ✅ 2. Get Attendance By Student ID
	public List<Attandence> getAttendanceByStudentId(int studentId) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			String hql = "FROM Attandence WHERE student.id = :studentId";
			return session.createQuery(hql, Attandence.class).setParameter("studentId", studentId).list();
		} catch (Exception e) {
			e.printStackTrace();
			return List.of(); // return empty list on error
		}
	}

	// ✅ 3. Update Attendance Status by ID
	@SuppressWarnings("deprecation")
	public boolean updateStatusById(int attendanceId, String newStatus) {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();

			Attandence attendance = session.get(Attandence.class, attendanceId);
			if (attendance != null) {
				attendance.setStatus(newStatus);
				session.update(attendance);
				tx.commit();
				return true;
			} else {
				System.out.println("No attendance found with ID: " + attendanceId);
				return false;
			}
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	// ✅ 4. Delete Attendance by ID
	@SuppressWarnings("deprecation")
	public boolean deleteAttendanceById(int attendanceId) {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();

			Attandence attendance = session.get(Attandence.class, attendanceId);
			if (attendance != null) {
				session.delete(attendance);
				tx.commit();
				return true;
			} else {
				System.out.println("No attendance found with ID: " + attendanceId);
				return false;
			}
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	// ✅ 5. Get All Attendance Records
	public List<Attandence> getAllAttendance() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			return session.createQuery("FROM Attandence", Attandence.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			return List.of();
		}
	}
	
	// ✅ 6. Get Attendance By Course and Date
	public List<Attandence> getAttendanceByCourseAndDate(String date) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			String hql = "FROM Attandence WHERE date = :date";
			return session.createQuery(hql, Attandence.class)
					.setParameter("date", date)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			return List.of(); // return empty list on error
		}
	}
	
}
