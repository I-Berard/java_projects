package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Patient;
import util.HibernateUtil;

public class PatientDAO {
    public static void save(Patient patient){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(patient);
            transaction.commit();
        }catch(Exception e){
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void update(Patient patient){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(patient);
            transaction.commit();
        }catch(Exception e){
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void delete(Patient patient){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(patient);
            transaction.commit();
        }catch(Exception e){
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static Patient getUser(Long id){
        Patient patient = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            patient = session.get(Patient.class, id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return patient;
    }

    public static Patient[] getAllUsers(){
        List<Patient> patients= new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            patients = session.createQuery("FROM patients", Patient.class).list();
        }catch(Exception e){
            // if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return patients.toArray(new Patient[0]);
    }
}
