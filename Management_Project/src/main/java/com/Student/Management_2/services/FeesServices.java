package com.Student.Management_2.services;

import java.util.Scanner;

import org.hibernate.Session;

import com.Student.Management_2.dao.FeesDAO;
import com.Student.Management_2.models.Student;
import com.Student.Management_2.utils.HibernateUtils;

public class FeesServices {

	private static final FeesDAO feesDAO = new FeesDAO();
	private static final Scanner sc = new Scanner(System.in);

	public void payFeesService() {
		Session session = null;

		System.out.println("=================================");
		System.out.println("💰 Welcome to Fees Payment Service");
		System.out.println("=================================");
		System.out.print("Enter Student ID: ");
		int studentId = -1;
		try {
			studentId = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("❌ Invalid Student ID. Please enter a valid number.");
			return;
		}
		if (studentId <= 0) {
			System.out.println("❌ Invalid Student ID. Please enter a positive number.");
			return;
		}

		session = HibernateUtils.getSessionFactory().openSession();
		Student s = session.get(Student.class, studentId);

		if (s == null) {
			System.out.println("❌ Student not found ");
			return;
		}

		System.out.println("Name: "+s.getName() +"\t Total Amount: "+ s.getFees().getAmount() +"\t Due Ampunt: " + s.getFees().getDueAmount()+
				"\t Paid Amount: " + s.getFees().getPaidAmount() + "\t Status: " + s.getFees().getStatus());

		System.out.print("Enter Amount to Pay: ");
		double amount = -1;
		try {
			amount = Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("❌ Invalid amount. Please enter a valid number.");
			return;
		}
		if (amount <= 0) {
			System.out.println("❌ Invalid amount. Amount should be greater than zero.");
			return;
		}
		// Call the DAO method to pay fees
		Boolean res = feesDAO.payFees(studentId, amount);
		if (res) {
			System.out.println("✅ Fees paid successfully " );
		} else {
			System.out.println("❌ Failed to pay fees ");
		}

	}

	public void viewFeesService() {
		Session session = null;

		System.out.println("=================================");
		System.out.println("💰 Welcome to Fees View Service");
		System.out.println("=================================");
		System.out.print("Enter Student ID: ");
		int studentId = -1;
		try {
			studentId = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("❌ Invalid Student ID. Please enter a valid number.");
			return;
		}
		if (studentId <= 0) {
			System.out.println("❌ Invalid Student ID. Please enter a positive number.");
			return;
		}

		session = HibernateUtils.getSessionFactory().openSession();
		Student s = session.get(Student.class, studentId);

		if (s == null) {
			System.out.println("❌ Student not found with ID: " + studentId);
			return;
		}

		System.out.println("Name: "+s.getName() +"\t Total Amount: "+ s.getFees().getAmount() +"\t Due Ampunt: " + s.getFees().getDueAmount()+
				"\t Paid Amount: " + s.getFees().getPaidAmount() + "\t Status: " + s.getFees().getStatus());

		session.close();
	}
	
//	View all student fees via course 
	public void viewAllFeesByCourseService() {
		Session session = null;

		System.out.println("=================================");
		System.out.println("💰 Welcome to Fees View Service by Course");
		System.out.println("=================================");
		System.out.print("Enter Course ID: ");
		int courseId = -1;
		try {
			courseId = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("❌ Invalid Course ID. Please enter a valid number.");
			return;
		}
		if (courseId <= 0) {
			System.out.println("❌ Invalid Course ID. Please enter a positive number.");
			return;
		}

		session = HibernateUtils.getSessionFactory().openSession();
		
		session.createQuery("FROM Student WHERE course.id = :courseId", Student.class)
				.setParameter("courseId", courseId)
				.getResultList()
				.forEach(student -> {
					System.out.println("Name: "+student.getName() +"\t Total Amount: "+ student.getFees().getAmount() +"\t Due Ampunt: " + student.getFees().getDueAmount()+
							"\t Paid Amount: " + student.getFees().getPaidAmount() + "\t Status: " + student.getFees().getStatus());
				});

		session.close();
	}
}
