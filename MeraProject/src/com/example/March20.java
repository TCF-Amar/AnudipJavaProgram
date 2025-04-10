package com.example;


class Outer{
	
	private int num;
	
	
	
	public Outer(int num) {
//		super();
		this.num = num;
	}



	class Inner{
		
		class Inner1{
			
			class Inner2{
				void printnum() {
					System.out.println(num*num);
				}	
				
			}
		}
		
	}
	
	
	
}



class Parent {
	
	 int a = 10 ;
	public Parent() {
		
		System.out.println("Hello From parent.");
	}
	
}



class Child extends Parent {
	
	public  Child(){
		
		System.out.println("Hello From Child"+ super.a);
	}
	
}

public class March20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer outer = new Outer(10);
		
		Outer.Inner inner1 = outer.new Inner();
		
		Outer.Inner.Inner1 inner2 = inner1.new Inner1();
		
		Outer.Inner.Inner1.Inner2 inner3 = inner2.new Inner2();
		
		
		
		Child c = new Child();
		
		
		
		
		
	}

}
