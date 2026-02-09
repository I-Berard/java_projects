package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.dbUtil;
import models.Student;

public class StudentDAO {
    public static void save(Student student) {
        String sql = "INSERT INTO students (id, studentFirstName, studentLastName) VALUES (?, ?, ?)";
        
        try(Connection conn = dbUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, student.getId());
            stmt.setString(2, student.getStudentFirstName());
            stmt.setString(3, student.getStudentLastName());
            stmt.executeUpdate();
        }catch(Exception e){
            throw new RuntimeException("Failed to save student", e);
        }
    }

    public static List<Student> readAll() throws SQLException{
        List<Student> list = new ArrayList<>();
        String sql = "SELECT id, studentFirstName, studentLastName FROM students";

        try(
            Connection conn = dbUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();){
            
            while(rs.next()){
                Student s = new Student(rs.getString("id"), rs.getString("studentFirstName"), rs.getString("studentLastName"));
                list.add(s);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
