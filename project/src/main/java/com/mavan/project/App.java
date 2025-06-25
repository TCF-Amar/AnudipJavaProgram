package com.mavan.project;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mavan.project.models.Car;
import com.mavan.project.models.Children;
import com.mavan.project.models.Parent;
import com.mavan.project.utils.Hibernateutils;


/**
 * Hello world!
 *
 */
public class App {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Hibernateutils hb = new Hibernateutils();
		Parent p = new Parent();
//		p.setId(1);
		p.setP_name("xyz");
		
		Children c1 = new Children();
		c1.setC_name("xx");
		c1.setParent(p);
		
		Children c2 = new Children();
		c2.setC_name("yy");
		c2.setParent(p);
		
		Children c3 = new Children();
		c3.setC_name("zz");
		c3.setParent(p);
		
		
		List<Children> list = new ArrayList<Children>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		
		
		p.setChildren(list);
		
		
		Session s = hb.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		

//		s.saveOrUpdate(p);
//		s.saveOrUpdate(c1);
//		s.saveOrUpdate(c2);
//		s.saveOrUpdate(c3);
//		tx.commit();
//		s.close();
		
		s = hb.getSessionFactory().openSession();
//		Parent parent = s.get(Parent.class, 2);
//		List<Children> ch = parent.getChildren();
//		
//		
//		System.out.println("Parent Name: "+parent.getP_name());
//		for (Children c : ch) {
//            System.out.println( c.getId() + ". " + c.getC_name());
//        }
		
//		Children child = s.find(Children.class, 1);
//		Parent parent = child.getParent();
//		
//		System.out.println("Child Name: " + child.getC_name());
//	    System.out.println("Parent Name: " + parent.getP_name());
//
//
//		s.close();
		
		s = hb.getSessionFactory().openSession();
		tx = s.beginTransaction();
		
//		int arr[] = {2,3,4,5,6,7,8,9};
//
		
//		for (int i : arr) {
		
		
		
		
		
		
//		    Children chh = s.get(Children.class, i);  // पहले entity लाओ
//		    if (chh != null) {
//		        s.delete(chh);  // फिर delete करो
//		    }
//		}
//	
		
//		Parent ppp = new Parent();
//		ppp.setId(3);
//		
//		s.delete(ppp);
//		tx.commit();
		Car car = new Car();
		car.setId(3);
		car.setName("Toyota");
		
	}
}
