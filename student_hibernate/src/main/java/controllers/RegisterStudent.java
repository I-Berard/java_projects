package controllers;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import model.Computer;
import model.Student;
import service.StudentService;

@WebServlet("/student/*")
public class RegisterStudent extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String firstname = req.getParameter("firstName");
        String lastname = req.getParameter("lastName");
//        String schoolName = req.getParameter("schoolName");
//        String academicYear = req.getParameter("academicYear");
        String computerBrand = req.getParameter("computerBrand");
        String computerVersion = req.getParameter("computerVersion");

        Student student = new Student();
        student.setStudentfirstname(firstname);
        student.setStudentlastname(lastname);
        Computer computer = new Computer();
        computer.setVersion(computerVersion);
        computer.setBrand(computerBrand);

        StudentDAO.saveWithComputer(student, computer);
        System.out.printf("Saved student");
    }
}
