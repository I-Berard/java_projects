package com.example.postgrescrud;
import java.sql.*;


public class Main {
    public static final String URL = "jdbc:postgresql://localhost:5432/java_db";
    public static final String USERNAME = "javauser";
    public static final String PASSWORD = "java@123";

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void AddUser(String name, String email){
        String sqlStatement = "INSERT INTO users(name, email) VALUES (?, ?)";
        try(Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(sqlStatement);
        ){
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("User created successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
    }   
    
    public static void DeleteUser(int id){
        String sqlStatement = "DELETE FROM users WHERE id=?";
        try(Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(sqlStatement);
        ){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("User deleted successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AddUser("Irakoze", "irakozeberard12@gmail.com");
        AddUser("Berard", "irakoze@sandaicares.org");
    }
}
