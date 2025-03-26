package com.example;

class StrigBufferConcept{
	
	
	public void display() {
		String s1 = "Hello";
		System.out.println(s1.hashCode());
		 s1 = s1+"World";
		System.out.println(s1.hashCode());
		
		s1 =s1.concat("he");
	System.out.println(s1);
	}
	
	
}



public class March21 {
//1. string is immutable 
//2. SCP(String Constant Pool)
	public static void main(String[] args) {
		StrigBufferConcept s = new StrigBufferConcept();
		s.display();
//		char a = 65;
		
//		System.out.println(a);
		

	}

}
