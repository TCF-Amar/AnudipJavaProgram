package com.Student.Managment;

import com.Student.Managment.handler.UserHandler;

public class App {
	public static void main(String[] args) {
		UserHandler userhandler = new UserHandler();
		
		userhandler.show();
	}
}
