package com.berard.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// import javax.servlet.http.HttpSessionEvent;

public class DisplayServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        PrintWriter out = res.getWriter();
        req.getRequestDispatcher("/header").include(req, res);

        HttpSession session = req.getSession();
        
        int results = (int)session.getAttribute("result");
        String operation = (String)session.getAttribute("operation");
        
        res.setContentType("text/html");
        out.println("<main style=\"padding:80px 20px 60px 20px;\"> The results of " + operation + " is " + results + "</main>");
        
        req.getRequestDispatcher("/footer").include(req, res);

    }
}
