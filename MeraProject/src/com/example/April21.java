package com.example;
//
//class Vehicle {
//	
//	public Vehicle() {
//		System.out.println("Veicle cunstroctor");
//	}
//	
//	void start() {
//		System.out.println("Vehicle starts 🚘");
//	}
//}
//
//class Car extends Vehicle {
//	void drive() {
//		
//		System.out.println("Car drives 🚗");
//	}
//}
//
//class SuperCar extends Car {
//	void superCar() {
//		System.out.println("Supar car Class Method");
//	}
//}
//
//
//class PetrolCar extends Car{
//	
//	void petrolCar() {
//		System.out.println("Petrol Car ");
//	}
//}

class Emp{
	
	int emp_id ;
	String name;
	double sallary;
	public Emp() {
	
		emp_id = 00;
		name =null;
		sallary = 1000;
	}
	public Emp(int emp_id, String name) {
	
		this.emp_id = emp_id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Emp [emp_id=" + emp_id + ", name=" + name + ", sallary=" + sallary + "]";
	}
	
	
}

public class April21 {

	
	public static void hello() {
		System.out.println("Hello");
	}
	
	public static int hello(int a) {
		System.out.println("Hello");
		return a;
	}
	
	
	
	public static void main(String[] args) {

		Emp e = new Emp();
		Emp e2 = new Emp(1,"Amar");

		System.out.println(e);
		System.out.println(e2);
		
		
	}

}
