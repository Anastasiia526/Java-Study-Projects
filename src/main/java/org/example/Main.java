package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

Animal a = new Animal();
a.setName("Cat");
a.setAge(2);
a.setTail(true);
a.setName("Dog");
a.setAge(7);
a.setTail(true);
a.setName("Hamster");
a.setAge(1);
a.setTail(false);

SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(a);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}