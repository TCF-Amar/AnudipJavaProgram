package com.advancejava;

import java.util.Scanner;

public class ExceptionHandling {

	public static void main(String[] args) {

		System.out.print("Write Somthing: ");

		Scanner sc = new Scanner(System.in);

		try {
			String str = sc.nextLine();
			if (str.length() <= 0) {
				throw new StringException("String length must be greater than 0");
			} else {
				System.out.println("String Value is: " + str);
			}
		} catch (StringException se) {
			System.out.println("Exception occurred: " + se.getMessage());
		} finally {
			sc.close();
		}

	}

}
