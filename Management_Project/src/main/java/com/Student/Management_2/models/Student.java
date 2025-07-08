package com.Student.Management_2.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Attandence> attendanceList;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Fees fees;

    public Student() {}

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

    public int getCourseId() {
        return this.course != null ? this.course.getId() : 0;
    }

    public Object getStudentId() {
        return this.id > 0 ? this.id : null;
    }

    public List<Attandence> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attandence> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public Fees getFees() {
        return fees;
    }

    public void setFees(Fees fees) {
        this.fees = fees;
    }
}
