package com.mavan.amarjeetm.models;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
	@Id 
	private int id;
	@Column(name = "course_name")
	
	private String courseName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	
	
	
}
