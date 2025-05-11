package collectionApis;

import java.util.*;

public class ArrayLists {

	public static void addData(ArrayList<String> l, Scanner sc) {
		
		System.out.println("Enter Number of data: ");
		
		int numerOfData = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < numerOfData; i++) {
			String data = sc.nextLine();
			l.add(data);
		}

	}
	
	public static void readData() {
		
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		addData(list,sc);
		System.out.println(list);
	}

}
