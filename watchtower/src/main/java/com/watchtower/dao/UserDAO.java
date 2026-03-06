package com.watchtower.dao;

import com.watchtower.models.Incident;
import com.watchtower.models.User;
import com.watchtower.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO {
    private static Session getSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }

    public static void save(User user){
        Transaction tx = null;
        try(Session session = getSession()){
            tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
        }catch (Exception e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public static void update(User user){
        Transaction tx = null;
        try(Session session = getSession()){
            tx = session.beginTransaction();
            session.merge(user);
            tx.commit();
        }catch (Exception e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public static User findByEmail(String email){
        User user = null;
        try(Session session = getSession()){
            user = (User) session.createQuery("FROM User u WHERE u.email = :email", User.class).setParameter("email", email).uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static User findByUsername(String username){
        User user = null;
        try(Session session = getSession()){
            user = (User) session.createQuery("FROM User u WHERE u.username = :username", User.class).setParameter("username", username).uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void assignIncidents(List<Incident> incidents, User user){
        Transaction tx = null;
        String id = user.getId();
        try(Session session = getSession()){
            User user1 = (User) session.createQuery("FROM User u where u.id = :id", User.class).setParameter("id", id).uniqueResult();
            if(user1 == null){
                throw new RuntimeException("First create the user and later assign incidents");
            }
            tx = session.beginTransaction();
            for(Incident incident : incidents){
                user1.addIncident(incident);
            }
            tx.commit();
        }catch (Exception e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
