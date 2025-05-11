package com.advancejava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class StudentClass{
	
	
	private int rollNo;
	public String name;
	public String course;
	
	
	
	
	public StudentClass(int rollNo, String name, String course) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.course = course;
	}

 public void writeData() {
	 File file = new File("./std.txt");
	 try {
		 FileWriter fw = new FileWriter(file);
		 BufferedWriter bw = new BufferedWriter(fw);
		 
//		 pw.print(rollNo+"\t"+name+"\t"+course);
		 bw.append(rollNo+"\t"+name+"\t"+course);
		
		 bw.close();
		 fw.close();
		 System.out.println("Data Written in file");

		 
	 } catch (IOException e) {
		System.out.println(e);
		
	}finally {
	}
 }
}


public class FileHandling {

	public static void main(String[] args) {

		StudentClass sc = new StudentClass(10, "Amar", "BCA");
		
		sc.writeData();
	}

}
