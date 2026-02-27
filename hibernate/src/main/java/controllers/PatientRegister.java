package controllers;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PatientDAO;
import model.Patient;

@WebServlet("/register")
public class PatientRegister extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");

        if(firstName == null || lastName == null || email == null){
            System.out.println("make sure that all things are provided");
            return;
        }

        Patient patient = new Patient(firstName, lastName, email);
        PatientDAO.save(patient);
        res.sendRedirect("index.jsp?success=true");
    }
}
