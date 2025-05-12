package assignments;

import java.util.Scanner;

class AssignmentTasks {

	public void oddEvenChecker(int num) {
		if (num % 2 == 0)
			System.out.println("Given Number " + num + " is Even");
		else
			System.out.println("Given Number " + num + " is Odd");

	}

	public void gradeCalculate(int marks) {

		if (marks > 100)
			System.out.println("Invalid Marks");
		else if (marks <= 100 && marks >= 90)
			System.out.println("A Grade");
		else if (marks < 90 && marks >= 80)
			System.out.println("B Grade");
		else if (marks < 80 && marks >= 70)
			System.out.println("C Grade");
		else if (marks < 70 && marks >= 60)
			System.out.println("F Grade");
		else
			System.out.println("Fail");
	}

	public void factorialCalculate(int num) {
		int a = 0, b = 1, c = 0;
		System.out.print(a + ", " + b + ", ");
		for (int i = 2; i < num; i++) {
			c = a + b;
			a = b;
			b = c;
			System.out.print(c + ", ");
		}
		System.out.println();
	}

	public void multiplication(int num) {
		int i = 1;
		System.out.println();
		while (i <= 10) {
			System.out.println(num + " x " + i + " = " + num * i);
			i++;
		}

	}

	public void sumOfDigitPositiveInteger(Scanner sc) {
		System.out.print("Enter positive integer: ");

		int num = sc.nextInt();
		int sum = 0;

		do {
			sum += num % 10;
			num /= 10;
		} while (num > 0);

		System.out.println("Sum Of The number: " + sum);
	}

	public void findLargestElementInArray(int[] arr) {

		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("Max :" + max);

	}

	
	public void arrayReverse(int[] arr) {
		System.out.print("Revarsed Array: ");
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
		
		
	}
	

	public void averageCalculate(int[] arr) {
		int val = 0;
		for (int item : arr) {
			val += item;
		}
		int avg = val / arr.length;

		System.out.println("Average: " + avg);
	}

	public void bubbleSort(int arr[]) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		
		
		System.out.print("Sorted Array: ");
		for (int item : arr) {
			System.out.print(item + " ");
		}
	}

	
	public void selectionSort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}
}

public class Assignment {

	public static void main(String[] args) {
		AssignmentTasks at = new AssignmentTasks();
		Scanner sc = new Scanner(System.in);

		// Odd Even Check
		at.oddEvenChecker(101);

		// Grade Calculate
		at.gradeCalculate(60);

		// Factorial Calculate
		at.factorialCalculate(10);

		// multiplication
		at.multiplication(2);

		// Sum of digits
		// at.sumOfDigitPositiveInteger(sc);

		// Max find in array
		int arr[] = { 1, 2, 3 };
		at.findLargestElementInArray(arr);

		// Array Reverse
		at.arrayReverse(arr);

		// Average calculate
		at.averageCalculate(arr);

		// bubble sort
		at.bubbleSort(arr);
		System.out.println();
		
		// Selection sort
		int arr1[] = { 5, 2, 8, 1, 3 };
		
		at.selectionSort(arr1);
		System.out.print("Sorted Array: ");
		
		for (int item : arr1) {
			System.out.print(item + " ");
		}
		System.out.println();

		sc.close();
	}

	
}
