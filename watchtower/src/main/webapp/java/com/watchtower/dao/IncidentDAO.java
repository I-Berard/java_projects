package com.watchtower.dao;

import com.watchtower.models.Incident;
import com.watchtower.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
