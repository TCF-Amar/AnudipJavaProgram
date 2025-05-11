package com.advancejava;
import java.util.Scanner;


 class HillStations {
    public void location() {
        System.out.println("HillStations are located at different places");
    }
    
    public void famousFor() {
        System.out.println("Famous for different things");
    }
}
  class Manali extends HillStations {
    @Override
    public void location() {
        System.out.println("Manali is in Himachal Pradesh");
    }
    
    @Override
    public void famousFor() {
        System.out.println("Manali is famous for skiing and adventure sports");
    }
}
   class Mussoorie extends HillStations {
    @Override
    public void location() {
        System.out.println("Mussoorie is in Uttarakhand");
    }
    
    @Override
    public void famousFor() {
        System.out.println("Mussoorie is famous for education institutions and tourism");
    }
}

 class Gulmarg extends HillStations {
    @Override
    public void location() {
        System.out.println("Gulmarg is in Jammu & Kashmir");
    }
    
    @Override
    public void famousFor() {
        System.out.println("Gulmarg is famous for its ski resort and gondola");
    }
}


public class Program1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Manali m = new Manali();
		Mussoorie mu = new Mussoorie();
		Gulmarg g = new Gulmarg();

		while(true) {
			System.out.println("1. Manali");
			System.out.println("2. Mussoorie");
			System.out.println("3. Gulmarg");
			System.out.println("4. Exit");
			System.out.println("Choose Location:");
			
			int location = sc.nextInt();
			
			
			switch(location) {
				case 1:
					m.location();
					m.famousFor();
					break;
				case 2:
					mu.location();
					mu.famousFor();
					break;
				case 3:
					g.location();
					g.famousFor();
					break;
				case 4:
					System.out.println("Exiting...");
					sc.close();
					System.exit(0);
				default:
					System.out.println("Invalid choice. Please try again.");
			}
			
		}
		
		
	}

}
