package com.example;

import java.util.Scanner;

class Fun{
	
	int num ;
	
//	without para....
	public void fun1(){
		
		System.out.println("Hello wiout para..");
	}
//	call by value
	public void fun2(int n, int m) {
		
		System.out.println(n+m);
	}
	
//	call by ref.....
	public  void incNum(Fun o) {
		o.num = o.num + 10;
		
		System.out.println(o.num);
	}
}



class Employee{
	
	private int id;
	public String  name;
	private double salary;
	
	
	
	
	public Employee() {
		super();
	}


	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	
	public void searchEmp(Employee e[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Imp id: ");
		int id = sc.nextInt();
		sc.close();
		
		boolean search =  false;
		
		
	for(Employee emp:e) {
		if(emp.id == id) {
			System.out.println(emp);
			break;
		}
		}
		
	}
	
	
}

class Student{
	
	private int rollNo;
	public String  name;
	private double marks;
	
	
	
	
	public Student() {
		
	}


	public Student(int rollNo, String name, double marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "rollNo: " + rollNo + "\nname: " + name + "\nmarks: " + marks;
	}


	public void searchStu(Student s[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Student Roll No. : ");
		
		int rNo = sc.nextInt();
		
		sc.close();
		
		boolean search = false;
		
	for(Student std:s) {
		if( std.rollNo == rNo) {
			System.out.println(std);
			search = true;
			break;
			}
		}
		
	if(search == false) {
		System.out.println("Student Not Found");
		}
	
	}
	
	
}



public class March25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Fun f = new Fun();
//		
//		f.fun1();
//		f.fun2(10, 14);
//		
//		System.out.println(f.num);
//		
//		f.incNum(f);
//		System.out.println(f.num);
		
		
//		Employee emp = new Employee();
//
//		Employee e[] = {new Employee(1,"Amar",1000),
//						new Employee(2,"Jeet",1093)
//		};
//		
		Student s = new Student();
		
		
		Student []ss = {
				new Student(111, "Amar", 70),
				new Student(222, "Jeet", 50),
				new Student(333, "Test1", 40),
				new Student(444, "Test2", 60)
		};
		
		
		s.searchStu(ss);
		
	}

}
