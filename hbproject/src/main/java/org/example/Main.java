package org.example;

import org.example.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Car c = new Car();

//        c.setId(13);
//        c.setModel("Ford");
//        c.setColor("Blue");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Car.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        session.save(c);
        List<Car> cars = session.createQuery("from Car",Car.class).list();
        for (Car car : cars) {
            System.out.println(car);
        }

        tx.commit();
        session.close();

    }
}