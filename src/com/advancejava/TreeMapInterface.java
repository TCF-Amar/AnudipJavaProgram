package com.advancejava;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

class TMap{
	TreeMap m = new TreeMap();
	

	public void addData(Scanner sc) {
		
		System.out.println("Enter number of value size: ");
		int size = sc.nextInt();
		
		sc.nextLine();
		for(int i =1; i<= size; i++) {
			System.out.print("Enter value " + i + ": ");
			String input = sc.nextLine();
			m.put(i,input);
		}
	}
	
	public void getAllData() {
		
		Set s = m.entrySet();
		
		Iterator i = s.iterator();
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}	
	}
	
	public void getKey() {
		System.out.println(m.keySet());
	}
	
	public void getValue() {
		System.out.println(m.values());
	}
	public void remove(int key)
	{
		m.remove(key);
		System.out.println(m);
	}
	public void removeAll()
	{
		m.clear();
		System.out.println(m);
	}


}

public class TreeMapInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TMap tm = new TMap();
		
		tm.addData(sc);
		tm.getAllData();
		tm.getKey();
		tm.getValue();
		tm.remove(1);
		tm.removeAll();
		

	}

}
