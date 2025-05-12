package collectionApis;

import java.util.*;

public class ArrayLists {

	// Method to add data to the list
	public static void addData(List<String> list, Scanner sc) {
		System.out.print("Enter number of data: ");
		int numberOfData = sc.nextInt();
		sc.nextLine(); // consume newline

		for (int i = 0; i < numberOfData; i++) {
			System.out.print("Enter data " + (i + 1) + ": ");
			String data = sc.nextLine();
			list.add(data);
		}
	}

	// Method to read and return the list
	public static List<String> readData(List<String> list) {
		return list;
	}
    // Method to update/set data in list
	public static void updateData(Scanner sc, List<String> list) {

		System.out.print("Enter index number(0 to " + (list.size() - 1) + "): ");
		int idx = sc.nextInt();
		if (idx > list.size() - 1) {
			System.out.println("Invalid index");
			updateData(sc, list);
		}
		System.out.print("Enter Data: ");
		sc.nextLine();
		String data = sc.nextLine();

		list.set(idx, data);

		System.out.println("After update data: ");
		for (String item : list) {
			System.out.println(item);
		}

	}
	
	public static void removeData(Scanner sc, List<String> list) {
		System.out.println("Choose 1 or 2, 1 for index 2 for value: ");
		int choise = sc.nextInt();
		if(choise == 1) {
			System.out.println("Enter index remove data (0 to "+ (list.size()-1) + ")");
			int idx = sc.nextInt();
			list.remove(idx);
		}else {
			System.out.println("Enter Data from list : "+list);
			sc.nextLine();
			String data = sc.nextLine();
			list.remove(data);
		}
		System.out.println(readData(list));

		
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to ArrayList Program!");
		addData(list, sc);

		System.out.println("\nData in the list:");
		for (String item : readData(list)) {
			System.out.println(item);
		}

//		updateData(sc, list);
//		removeData(sc,list);
		System.out.println(list);
		list.clear();
		System.out.println(list);
		
		sc.close();
	}
}
