package org.example.services;


import jakarta.persistence.*;
import org.example.model.Car;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CarServices {


    public void addNewCar(Car car) {
        try(Session s = HibernateUtils.getSessionFactory().openSession()) {
            Transaction tx = s.beginTransaction();
            car.setId(123);
            car.setModel("Aa");
            car.setColor("red");
            s.save(car);
            tx.commit();
            s.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
