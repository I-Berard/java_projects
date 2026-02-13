package controllers;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import model.Student;

@WebServlet("/register")
public class RegisterStudent extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String studentfirstname = req.getParameter("studentfirstname");
        String studentlastname = req.getParameter("studentlastname");
        int id = Integer.parseInt(req.getParameter("id"));

        if(studentfirstname == null || studentlastname == null){
            System.out.println("make sure that all things are provided");
            return;
        }

        Student newStudent = new Student(id, studentfirstname, studentlastname);
        StudentDAO.save(newStudent);
        res.sendRedirect("register.jsp?success=true");
    }
}
