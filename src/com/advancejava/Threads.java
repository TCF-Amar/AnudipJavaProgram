package com.advancejava;


class Counter {
	int count = 0;

//	public synchronized void increment() {
	public  void increment() {
		
		synchronized(this) {
			count++;
		}
	}

	public int getCount() {
		return count;
	}
}

public class Threads {

	public static void main(String[] args) {

		Counter c = new Counter();
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
//				c.increment();
				System.out.println("Hello");
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				c.increment();
			}
		
		});
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println("Thread 1 Priority: " + t1.getPriority());
		System.out.println("Thread 2 Priority: " + t2.getPriority());
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Final count: " + c.getCount());
	}

}
