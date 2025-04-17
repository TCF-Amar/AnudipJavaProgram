package com.advancejava;

import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//		System.out.print("Enter a number: ");
//		int n = sc.nextInt();
//		
//		if (n < 0) System.out.println("Negative Number");
//		
//		else System.out.println("Positive Number");
//		

//		System.out.print("Enter Marks: ");

//		int marks = sc.nextInt();

//		if (marks < 0 || marks > 100) {
//			System.out.println("Invalid Marks");
//		} else if (marks >= 90) {
//			System.out.println("Grade A");
//		} else if (marks >= 80) {
//			System.out.println("Grade B");
//		} else if (marks >= 70) {
//			System.out.println("Grade C");
//		} else if (marks >= 60) {
//			System.out.println("Grade D");
//		}
//
//		else if (marks >= 33) {
//			System.out.println("Grade E");
//		} else {
//			System.out.println("failed");
//		}

//		System.out.println("Enter three numbers: ");	
//		
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		int c = sc.nextInt();
//		
//		if (a > b && a > c)
//			System.out.println("a is greater");
//
//		else if (b > a && b > c)
//			System.out.println("b is greater");
//
//		else
//			System.out.println("c is greater");
//	

//		
//		int num1 = 10, num2 =20;
//		
//		System.out.println("Before Swapping: ");
//		System.out.println("num1: " + num1);
//		System.out.println("num2: " + num2);
//		
//		num1 = num1 + num2; // num1 = 30 = 10 + 20
//		num2 = num1 - num2; // num2 = 30 - 20 = 10
//		num1 = num1 - num2; // num1 = 30 - 10 = 20
//		
//		System.out.println("After Swapping: ");
//		System.out.println("num1: " + num1);
//		System.out.println("num2: " + num2);

//		for (int i = 1; i <= 7; i++)
//			System.out.println("*");
//		for(int i = 1; i <= 5; i++)
//			System.out.print("* ");

//		System.out.print("Enter a number: ");
//		int n = sc.nextInt();
//		int sum = 0;

//		for (int i = n; i >= 1; i--)
//			sum = sum + i;

//		while (n >= 1) {
//			sum = sum + n;
//			n--;
//		}

//		System.out.println("Sum Of No.: " + sum);

		int arr[] = { 1, 2, 3, 4, 5 };
		
		int sumArry = 0;

		for (int i : arr) {
			sumArry += i;
		}

		System.out.println("Sum Of Array: " + sumArry);
		
		
	}

}
