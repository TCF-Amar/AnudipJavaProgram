package com.example;

import java.util.*;

public class March24 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter String: ");
		
//		sc.nextLine();
		
		String  str = sc.nextLine();
		
//		int count  = str.split(" ").length;
		
//		System.out.println(count);
		
		
//		System.out.println(str.toUpperCase());
//		System.out.println(str.toLowerCase());
//		System.out.println(str.charAt(3));
//		System.out.println(str.codePointAt(2));
		
//		System.out.println(str.compareTo("Hello"));
//		System.out.println(str.compareToIgnoreCase("Hello"));
//		System.out.println(str.equals("Hello"));
//		System.out.println(str.charAt(4));
//		System.out.println(str.indexOf("ello"));
		
//		int i =100 ;
//		String sss = String.valueOf(i);
		
//		System.out.println(sss);
		
//		System.out.println(str.trim());
//		System.out.println(str.strip());
		
		char []c= new char[10];
		
		str.getChars(0, str.length(), c, 0);
		System.out.print("[");
		 for(char cc:c) {
			 
			 System.out.print(cc+" ");
		 }
		 System.out.print("]");
		
		
		
		
		
	}

}
