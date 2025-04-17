package com.example;

import java.util.Scanner;

public class FindMaxNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter First Num.: ");
		int num1 = sc.nextInt();
		
		System.out.print("Enter Second Num.: ");
		int num2 = sc.nextInt();
		
		
		System.out.println(num1>num2? "First Number is Maximum" :"Second Number is  Maximum");
	}

}
