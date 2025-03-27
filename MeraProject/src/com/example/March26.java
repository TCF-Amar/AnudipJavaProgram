package com.example;

import java.util.*;

class ArrayCRUD {
	Scanner sc = new Scanner(System.in);
	int[] arr;

	public void createArray() {

		System.out.print("Enter Array Size: ");
		int size = sc.nextInt();

		arr = new int[size];

		System.out.print("Enter " + size + " elements in array (space-separated): ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("===========================");
		System.out.println("Array Successfyly Created ");
		System.out.println("===========================");
	}

	public void diplayArray() {
		if (arr == null) {
			System.out.println("Array is empty Please create an array first.");
			return;
		}
		for (int i : arr) {
			System.out.print(i + " ");
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
		System.out.println("=========================================================");
		System.out.println("Index: " + index + " Array Element Updated Successfully!");
		System.out.print("Updated Array: ");
		diplayArray();
		System.out.println("=========================================================");

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

		int[] newArr = new int[arr.length - 1];

		for (int i = 0, j = 0; i < arr.length; i++) {
			if (i != index) {
				newArr[j++] = arr[i];
			}
		}

		arr = newArr;

		System.out.println("=========================================================");
		System.out.println("Index: " + index + " Array Element deleted successfully!");
		System.out.print("Delete Element After Array: ");
		diplayArray();
		System.out.println("=========================================================");
	}

	public void menu() {
		while (true) {
			System.out.println("----- CRUD -------");
			System.out.println("1. Create(Insert)");
			System.out.println("2. Read");
			System.out.println("3. Update Single Array Elemet");
			System.out.println("4. Delete Single Array Element");
			System.out.println("5. Delete All Array Elements");
			System.out.println("6. Exit");
			System.out.print("======================\n");
			System.out.print("Enter Your Choice(1-6): ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				createArray();
				break;
			case 2:
				System.out.print("Array Elements: ");
				diplayArray();
				break;
			case 3:
				updateArray();
				break;
			case 4:
				deleteArryElement();
				break;
			case 5:
				arr = null;
				System.out.println("======================================");
				System.out.println("Successfully Delete Array All Elements");
				System.out.println("======================================");
				break;
			case 6:
				System.out.println("======================");
				System.out.println("Bye Bye Program Closed");
				System.out.println("======================");
				System.exit(choice);
			default:
				System.out.println("================");
				System.out.println(" Invalid Input ");
				System.out.println("================");
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
