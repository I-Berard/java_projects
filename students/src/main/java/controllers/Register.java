package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDAO;
import models.Student;

@WebServlet("/register")
public class Register extends HttpServlet{
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        String id = req.getParameter("id");
        String studentFirstName = req.getParameter("studentFirstName");
        String studentLastName = req.getParameter("studentLastName");

        Student newStudent = new Student(id, studentFirstName, studentLastName);
        
        StudentDAO.save(newStudent);        
        System.out.println("created new student");
    } 
}
