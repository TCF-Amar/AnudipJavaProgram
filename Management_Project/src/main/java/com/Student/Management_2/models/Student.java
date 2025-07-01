package com.Student.Management_2.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "students") // Optional: explicitly name the table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true) // Assuming email must be unique
    private String email;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Attandence> attendanceList;

	private int courseId;

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getCourseId() { return getCourseId(); }
    public void setCourseId(int courseId) { this.courseId = courseId; }

	public Object getStudentId() {
		if (this.id > 0) {
			return this.id;
		}
		return null;
	}
}
