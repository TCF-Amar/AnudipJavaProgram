package com.example;

 abstract class Employee1 {
	 abstract int calculateSallary();
 }
 
 
 class Manager extends Employee1 {
	 
	 @Override
	 public int calculateSallary() {
		 int sallary = 10000;
		 int bonus = 2000;
		 int total = sallary + bonus;
		 return total;
	 }
 }
 
 class Accountant extends Employee1 {
	 
	 @Override
	 public int calculateSallary() {
		 int sallary = 5000;
		 int expense = 1000;
		 int total = sallary - expense;
		 return total;
		 
	 }
 }
 

public class Aaril22 {

	public static void main(String[] args) {
		
		Employee1 emp = new Manager();
		
		System.out.println("Manager Salary: " + emp.calculateSallary());
		
		emp = new Accountant();
		
		System.out.println("Accountant Salary: " + emp.calculateSallary());
		
		

	}

}
