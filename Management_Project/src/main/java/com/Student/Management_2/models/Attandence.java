package com.Student.Management_2.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "attendance")
public class Attandence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "date", nullable = false)
	private Date date;
	@Column(name = "status", nullable = false)
	private String status;// Present or Absent

	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;

	public Attandence() {
		super();
	}

	public Attandence(Date date, String status, Student student) {
		super();
		this.date = date;
		this.status = status;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getCourseId() {
		if (student != null && student.getCourse() != null) {
			return String.valueOf(student.getCourse().getId());
		}

		return null;
	}

}
