package com.watchtower.dao;

import com.watchtower.models.Incident;
import com.watchtower.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class IncidentDAO {
    public static void save(Incident incident){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(incident);
            tx.commit();
        }catch (Exception e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public static void update(Incident incident){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.merge(incident);
            tx.commit();
        }catch (Exception e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public static List<Incident> getAll(){
        List<Incident> incidents = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
           incidents = session.createQuery("FROM Incident", Incident.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return incidents;
    }

    public static Incident getOneBasedOnId(String id){
        Incident incident = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
           incident = session.createQuery("FROM Incident WHERE id = :id", Incident.class)
                             .setParameter("id", id)
                             .uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return incident;
    }
}
