package com.example;

import java.util.Scanner;

class MyBank {
	Scanner sc = new Scanner(System.in);

	double amount;

	public MyBank(double amount) {
		super();
		this.amount = amount;
	}

	public void depositAmount() {
		
		System.out.print("Deposit  Balance: ");
		
		double depositamount = sc.nextDouble();

		this.amount += depositamount; //10000 + 10000

		System.out.println("Deposit successful. New balance: " + amount);
	}

	public void withdrawAmount() {
		
		System.out.println("Winrawal Balance: ");
		
		double withdrowamount = sc.nextDouble();
		
		if (this.amount < withdrowamount) {
			System.out.println("Insufficient balance..");
		} 
		else {
			this.amount -= withdrowamount;
			System.out.println("Withdraw successful.");
			System.out.println("Remaining  Balance: " + this.amount);
		}
	}
}

public class Bank {

	public static void main(String[] args) {
		MyBank mb = new MyBank(10000);

		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("1. Check Blance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("0. Exit");
			System.out.print("Enter Your Choice: ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Current Balance: " + mb.amount);
				break;
			case 2:
				mb.depositAmount();
				break;
			case 3:
				mb.withdrawAmount();
				break;
			case 0:
				System.exit(ch);
			default:
				System.out.print("Invalid Input");
			}

		}

	}

}
