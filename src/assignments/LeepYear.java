package assignments;
import java.time.*;
import java.util.Scanner;

public class LeepYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Year: ");
		int year = sc.nextInt();
		
		if(Year.isLeap(year)) 
			System.out.println("Given Year " + year + " is Leep Year");
		else 
			System.out.println("Given Year " + year + " is not a Leep Year");
		
		sc.close();
	}

}
