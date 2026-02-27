package service;

import models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class StudentService {
    public void registerStudent(Student student){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSesssionFactory().openSession()){
            tx = session.beginTransaction();
            session.save(student);
            // session.persist(student);
            tx.commit();
        }catch(Exception e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
