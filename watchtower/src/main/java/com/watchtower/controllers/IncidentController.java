package com.watchtower.controllers;

import com.watchtower.dao.IncidentDAO;
import com.watchtower.models.Incident;
import com.watchtower.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@WebServlet("/incidents/*")
public class IncidentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session == null || session.getAttribute("user") == null){
            res.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        if ("/new".equals(req.getPathInfo())) {
            req.getRequestDispatcher("/add-incident.jsp").forward(req, res);
        } else {
            res.sendRedirect(req.getContextPath() + "/dashboard");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session == null || session.getAttribute("user") == null){
            res.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        User user = (User) session.getAttribute("user");

        if ("/new".equals(req.getPathInfo())) {
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            String severity = req.getParameter("severity");
            
            Incident incident = new Incident();
            incident.setId(UUID.randomUUID().toString());
            incident.setTitle(title);
            incident.setDescription(description);
            incident.setSeverity(severity);
            incident.setStatus("Open"); // Default status
            incident.setCreated_at(LocalDateTime.now());
            incident.setUser(user);

            IncidentDAO.save(incident);
            
            res.sendRedirect(req.getContextPath() + "/dashboard");
        }
    }
}
