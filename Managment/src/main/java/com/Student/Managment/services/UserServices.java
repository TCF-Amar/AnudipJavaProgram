package com.Student.Managment.services;

import java.util.Scanner;



import com.Student.Managment.dao.UserDAO;
import com.Student.Managment.handler.*;
import com.Student.Managment.models.*;

public class UserServices {
	  Scanner sc = new Scanner(System.in);
	    UserDAO userdao = new UserDAO();
	    AdminHandler am = new AdminHandler();
	
	
	public void registerService() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email Address: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        boolean res = userdao.registerUser(name, email, password);

        if (res) {
        	System.out.println("================================");
            System.out.println("✅ Account Successfully Created");
        	System.out.println("================================");

        } else {
        	System.out.println("================================");
            System.out.println("❌ Something went wrong. Try again.");
        	System.out.println("================================");

        }
    }

    public void loginServices() {
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        User user = userdao.loginUser(email, password);

        if (user != null) {
        	System.out.println("================================");
            System.out.println("✅ Login Successful. Welcome, " + user.getName() + "!");
        	System.out.println("================================");

            
            switch (user.getRole()) {
			case Admin:
				new AdminHandler().show();
				break;
			case Teacher:
				new TeacherHandler().show();
				break;
			default:
				break;
			}
        } else {
        	System.out.println("================================");
            System.out.println("❌ Invalid email or password.");
			System.out.println("================================");

        }
        
    }

	

}
