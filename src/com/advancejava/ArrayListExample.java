package com.advancejava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class Student {
    int rollNo;
    String name;
    String course;

    public Student(int rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student: rollNo=" + rollNo + ", name=" + name + ", course=" + course ;
    }
}

class StudentOp {
    List<Student> student = new ArrayList<>();

    public void addStudent() {
        student.add(new Student(1, "Amar", "BCA"));
        student.add(new Student(2, "Jeet", "BCA"));
        student.add(new Student(3, "Sonu", "BCA"));
        student.add(new Student(4, "Monu", "BCA"));

      
    }
    
    public void getStudent() {
    	Iterator  i = student.iterator();
    	while(i.hasNext()) {
    		Student data = (Student)i.next();
    		System.out.println(data);
    	}
    	
    }
}

public class ArrayListExample {
    public static void main(String[] args) {
        StudentOp s = new StudentOp();
        s.addStudent(); 
        s.getStudent();
    }
}
