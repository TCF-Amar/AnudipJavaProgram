package com.example;

import java.util.Scanner;

class BusBooking {
    Scanner sc = new Scanner(System.in);
    int[] arr = new int[10];
//    {0,0,0,0,0,0,1,0}
    public void displaySeats() {
        int sn = 1;
        System.out.println("===========================");
        for (int i : arr) {
            if (i == 1)
                System.out.println("Seat No: " + sn++ + "\t[Booked]");
            else
                System.out.println("Seat No: " + sn++ + "\t[Available]");
        }
        System.out.println("===========================");
    }

    public void bookSeat() {
        System.out.print("Enter Seat No.: ");
        int sn = sc.nextInt();
        if(sn <= 0 || sn > 10) {
            System.out.println("Wrong Seat No.");
            return;
        }
        
        if (arr[sn-1] == 1) {
            System.out.println("Seat No.: " + sn + "  Already Booked");
        } else {
            arr[sn-1] = 1;
            System.out.println("Seat No.: " + sn + " Booked Successfully");
        }

    }

    public void cancelSeat() {
        System.out.print("Enter Seat No.: ");
        int sn = sc.nextInt();
        
        
        if(sn <= 0 || sn > 10) {
            System.out.println("Wrong Seat No.");
            return;
        }
        
        if (arr[sn-1] == 1) {
            arr[sn-1] = 0;
            System.out.println("Seat Cancelled Successfully");
        } else {
            System.out.println("Seat is Already Available");
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\nBus Seat Booking System");
            System.out.println("1. Show All Seats");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    displaySeats();
                    break;
                case 2:
                    bookSeat();
                    break;
                case 3:
                    cancelSeat();
                    break;
                case 4:
                    System.out.println("Thank you for using Bus Booking System! Goodbye! 😊");
                    System.exit(0);
                default:
                    System.out.println("Invalid Input. Please try again.");
            }
        }
    }
}

public class March27 {
    public static void main(String[] args) {
        BusBooking b = new BusBooking();
        b.menu();
    }
}
