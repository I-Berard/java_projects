package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PatientDAO;
import model.Patient;

@WebServlet("/patients")
public class ViewPatients extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        Patient[] patientsArray =  PatientDAO.getAllUsers();
        List<Patient> patientList = new ArrayList<>();
        if (patientsArray != null) {
            patientList = Arrays.asList(patientsArray);
        }

        req.setAttribute("patientList", patientList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("patients.jsp");
        dispatcher.forward(req, res);
    }
}
