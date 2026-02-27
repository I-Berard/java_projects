package dao;

import model.Computer;
import model.Student;
import model.UpdateComputerDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class ComputerDAO {
    public static void save(Computer computer){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSesssionFactory().openSession()){
            tx = session.beginTransaction();
            session.persist(computer);
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public static void save(Computer computer, Student student){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSesssionFactory().openSession()){
            tx = session.beginTransaction();
            computer.setStudent(student);
            session.persist(computer);
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public static void update(Long Id, UpdateComputerDTO computer){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSesssionFactory().openSession()){
            tx = session.beginTransaction();
            Computer computer1 = session.get(Computer.class, Id);

            if(computer1 != null){
                if(computer.getStudent() != null){
                    Student student = session.get(Student.class, computer.getStudent());
                    if(student != null){
                        computer1.setStudent(student);
                    }else {
                        throw new RuntimeException("Student with student id " + computer.getStudent() + " does not exist" );
                    }
                }
                if(computer.getBrand() != null){
                    computer1.setBrand(computer.getBrand());
                }
                if(computer.getVersion() != null){
                    computer1.setVersion(computer.getVersion());
                }
            }
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
