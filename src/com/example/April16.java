package com.example;

import java.util.Scanner;

class Students {

	public int rollNo;
	public String stdName;
	public int age;
	public String address;

	public void setData() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Student Roll No.: ");
		rollNo = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Student Name: ");
		stdName = sc.nextLine();

		System.out.print("Enter Student Age: ");

		age = sc.nextInt();

		System.out.print("Enter Student Address: ");
		sc.nextLine();

		address = sc.nextLine();

		sc.close();
	}

	public void getData() {

		System.out.println("Student Roll No.: " + rollNo);
		System.out.println("Student Name: " + stdName);
		System.out.println("Student age: " + age);
		System.out.println("Student ddress: " + address);

	}

}

public class April16 {

	public static void main(String[] args) {

		Students student = new Students();

		student.setData();
		System.out.println("==========================");
		student.getData();

	}

}
