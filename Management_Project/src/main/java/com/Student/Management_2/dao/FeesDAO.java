package com.Student.Management_2.dao;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Student.Management_2.enums.FeeStatus;
import com.Student.Management_2.models.Student;
import com.Student.Management_2.utils.HibernateUtils;

public class FeesDAO {

	public Boolean payFees(int studentId, double amount) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			// Fetch the student from the database
			Student existingStudent = session.get(Student.class, studentId);
			if (existingStudent == null) {
				System.out.println("Student not found with ID: " + studentId);
				return false;
			}
			if (amount <= 0) {
				System.out.println("Invalid amount. Amount should be greater than zero.");
				return false;
			}
			// Update the student's fees information
			
			existingStudent.getFees().setPaidAmount(existingStudent.getFees().getPaidAmount() + amount);
			existingStudent.getFees().setDueAmount(existingStudent.getFees().getDueAmount() - amount);
			existingStudent.getFees().setPaymentDate(LocalDateTime.now());
			if (existingStudent.getFees().getDueAmount() <= 0) {
				existingStudent.getFees().setStatus(FeeStatus.PAID);
			} else {
				existingStudent.getFees().setStatus(FeeStatus.PARTIAL);
			}
			System.out.println("Remening Amount: "+existingStudent.getFees().getDueAmount());
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();

		}

		return true;
	}

}
