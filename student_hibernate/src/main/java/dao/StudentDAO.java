package dao;


import java.util.ArrayList;
import java.util.List;

import model.Computer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Student;
import util.HibernateUtil;

public class StudentDAO {
    public static void save(Student student){
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

    public static void saveWithComputer(Student student, Computer computer){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSesssionFactory().openSession()){
            tx = session.beginTransaction();
            student.addComputer(computer);
            session.save(student);
            // session.persist(student);
            tx.commit();
        }catch(Exception e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }



    public static void update(Student patient){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSesssionFactory().openSession()){
            tx = session.beginTransaction();
            session.update(patient);
            tx.commit();
        }catch(Exception e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public static void delete(Student student){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSesssionFactory().openSession()){
            tx = session.beginTransaction();
            session.delete(student);
            tx.commit();
        }catch(Exception e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public static List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        try(Session session = HibernateUtil.getSesssionFactory().openSession()){
            students = session.createQuery("FROM students", Student.class).list();
        }catch(Exception e){
            // if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return students;
    }
}
