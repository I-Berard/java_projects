package com.watchtower.controllers;

import com.watchtower.dao.IncidentDAO;
import com.watchtower.models.Incident;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"", "/dashboard"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Incident> incidents = IncidentDAO.getAll();
        req.setAttribute("incidents", incidents);
        req.getRequestDispatcher("/index.jsp").forward(req, res);
    }
}
