package dao;

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
}
