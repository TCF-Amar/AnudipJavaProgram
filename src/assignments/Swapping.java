package assignments;

public class Swapping {
	
	
	
	public static void methodfirst(int num1, int num2) {
		
		
		
		System.out.println("After Swapping ");
		System.out.println("Num1: " + num1);
		System.out.println("Num2: "+num2 );
		
		//Method: 1
		num1 = num1+num2; // num1 = 10 + 20 :: num1 = 30
		num2 = num1-num2; // num2 = 30 - 20 :: num2 = 10
		num1 = num1-num2; // num1 = 30 - 10 :: num1 = 20
		
		
		System.out.println("Before Swapping ");
		System.out.println("Num1: " + num1);
		System.out.println("Num2: "+num2 );
		
	}
	
	
	public static void methodsecond(int num1,int num2) {
		
		System.out.println("After Swapping ");
		System.out.println("Num1: " + num1);
		System.out.println("Num2: "+num2 );
		
		int temp = num1; // temp = 10
		num1 = num2; 	 // num1 = 20
		num2 = temp;	 // num2 = 10
		
		System.out.println("Before Swapping ");
		System.out.println("Num1: " + num1);
		System.out.println("Num2: "+num2 );
	}

	public static void main(String[] args) {

		int num1 = 10;
		int num2 = 20;
		System.out.println("----------------------------");
		System.out.println("Whitout using third variable");
		System.out.println("----------------------------");

		methodfirst(num1,num2);
		System.out.println("----------------------------");
		System.out.println("----------------------------");
		System.out.println("Using third variable");
		System.out.println("----------------------------");

		methodsecond(num1,num2);
		
	}

}
