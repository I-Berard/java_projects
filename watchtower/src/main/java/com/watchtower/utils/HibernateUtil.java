package com.watchtower.utils;

//import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory(){
        try {
            return new Configuration().configure().buildSessionFactory();
        }catch (Throwable e){
            System.err.println("Initial SessionFactory creation failed. " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void closeSessionFactory(){
        sessionFactory.close();
    }
}
