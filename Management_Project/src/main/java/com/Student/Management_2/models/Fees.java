package com.Student.Management_2.models;

import java.time.LocalDateTime;

import com.Student.Management_2.enums.FeeStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "fees")
public class Fees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "amount", nullable = false)
	private double amount;

//	paid amount
	@Column(name = "paid_amount", nullable = false)
	private double paidAmount;

	@Column(name = "due_amount", nullable = false)
	private double dueAmount;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private FeeStatus status;
	
	@Column(name = "payment_date")
	private LocalDateTime paymentDate; // Date format can be adjusted as needed

	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public Fees() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public FeeStatus getStatus() {
		return status;
	}

	public void setStatus(FeeStatus status) {
		this.status = status;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

}
