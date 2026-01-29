package com.berard.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        PrintWriter out = res.getWriter();
        req.getRequestDispatcher("/header").include(req, res);
        
        int results = (int)req.getAttribute("result");
        String operation = (String)req.getAttribute("operation");
        
        res.setContentType("text/html");
        out.println("<main style=\"padding:80px 20px 60px 20px;\"> The results of " + operation + " is " + results + "</main>");
        
        req.getRequestDispatcher("/footer").include(req, res);

    }
}
