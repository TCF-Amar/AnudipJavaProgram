package com.example;

public class April15 {

	public static void main(String[] args) {
//		int[][] arr = { { 2, 4, 6 }, { 2, 4, 6, 8, 10 }, { 2, 4, 6, 8 }, { 2, 4, 6 } };
//
////		int total =0;
//				
//		for (int i = 0; i < arr.length; i++) {
//			
//			
//			int sum = 0;
//			System.out.print("row " + i + ": ");
//
//			for (int j = 0; j < arr[i].length; j++) {
//
//				System.out.print(arr[i][j] + " ");
//
//				sum += arr[i][j];
//			}
//
//			System.out.println(" = " + sum);
////			total += sum;
//		}
//		System.out.println("Total Sum: "+total);

		int arr[] = { 2, 45, 30, 2, 56, 22 };
		int largest = arr[0];
		int secondL = Integer.MIN_VALUE;

		for (int i = 1; i < arr.length; i++) {
		    if (arr[i] > largest) {
		        secondL = largest;
		        largest = arr[i];
		    } 
		    if (arr[i] > secondL && arr[i] != largest) {
		        secondL = arr[i];
		    }
		}

		System.out.println("Largest: " + largest);
		System.out.println("Second Largest: " + secondL);
	}
}
