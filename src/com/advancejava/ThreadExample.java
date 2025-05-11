package com.advancejava;

class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 20; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				System.out.println(ex);
			}

			if (i % 2 == 0) 
				System.out.println("Even Number: " + i);
			Thread.yield();
		}
	}
}

class MyThread1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 20; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				System.out.println(ex);
			}

			if (i % 2 != 0) 
				System.out.println("Odd Number: " + i);
		}
	}
}

public class ThreadExample {

	public static void main(String[] args) {

		MyThread t1 = new MyThread();
		t1.setName("Thread 1");
		t1.start();
	

		MyThread1 myThread = new MyThread1();
		Thread t2 = new Thread(myThread);
		t2.setName("Thread 2");
		t2.start();
		
	}
}
