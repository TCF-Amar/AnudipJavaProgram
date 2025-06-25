package org.example.utils;

import org.example.model.Car;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
      try {
          Configuration cfg = new Configuration();
          cfg.configure("hibernate.cfg.xml");
          cfg.addAnnotatedClass(Car.class);
          sessionFactory = cfg.buildSessionFactory();
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
      return sessionFactory;
    }
}
