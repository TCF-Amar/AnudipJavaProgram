package com.example;

import java.util.*;

class ArrayCRUD{
	Scanner sc = new Scanner(System.in);
	int []arr;

	public ArrayCRUD() {
		super();
	}
	
	
	public void createArray() {
		System.out.print("Enter Array Size: ");
		int size = sc.nextInt();
		
		arr = new int[size];
		
		 System.out.print("Enter " + size + " elements in array (space-separated): ");
	        for (int i = 0; i < size; i++) {
	            arr[i] = sc.nextInt();
	        }
	     System.out.println("Array Successfyly Created ");
		}
	
	public void diplayArray() {
		if (arr == null) {
            System.out.println("Array is empty Please create an array first.");
            return;
        }
		System.out.print("Array Elements: ");
		for( int i:arr) {
			System.out.print(i+ " ");
		}
		System.out.println();
			
	}
	
	public void updateArray() {
		if (arr == null) {
            System.out.println("Array is empty Please create an array first.");
            return;
        }
		
		  System.out.print("Enter index to update: ");
	        int index = sc.nextInt();
	        if (index < 0 || index >= arr.length) {
	            System.out.println("Invalid index!");
	            return;
	        }
	        System.out.print("Enter new value: ");
	        arr[index] = sc.nextInt();
	        System.out.println("Updated Successfully!");
	
		}

	public void deleteArryElement() {
		 if (arr == null) {
	            System.out.println("Array is empty! Please create an array first.");
	            return;
	        }
	        System.out.print("Enter index to delete: ");
	        int index = sc.nextInt();
	        if (index < 0 || index >= arr.length) {
	            System.out.println("Invalid index!");
	            return;
	        }
	        for (int i = index; i < arr.length - 1; i++) {
	            arr[i] = arr[i + 1];
	        }
	        arr[arr.length - 1] = 0; 
	        
	        System.out.println("Element deleted successfully!");
	}
	
	
	
	
	
	
	public void menu() {
		while (true) {
		
			System.out.println("----- CRUD -------");
			System.out.println("1. Create(Insert)");
			System.out.println("2. Read");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			System.out.println("5. Exit");
			System.out.print("Enter Your Choice: ");
			
			
			int choice = sc.nextInt();
			
				switch(choice) {
			
			
					case 1:
						createArray();
						break;
					case 2:
						diplayArray();
						break;
					case 3:
						updateArray();
						break;
					case 4:
						deleteArryElement();
						break;
						
					case 5:
						System.out.println("Program Closed");
						return;
					default:
						System.out.println("\nEnvalid Input\n");
					
				}
			}
		}

}





public class March26 {

	public static void main(String[] args) {
		
		ArrayCRUD ac = new ArrayCRUD();
		
		ac.menu();

		
		
	}

}
