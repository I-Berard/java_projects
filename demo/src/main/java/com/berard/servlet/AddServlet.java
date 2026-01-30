package com.berard.servlet;

import java.io.IOException;
// import java.io.PrintWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
// import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// @WebServlet("/add")
public class AddServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        Cookie[] cookies = req.getCookies();
        int num1 = Integer.parseInt(cookies[1].getValue());
        int num2 = Integer.parseInt(cookies[2].getValue());

        int sum = num1 + num2;

        PrintWriter out = res.getWriter();
        // req.getRequestDispatcher("/header").include(req, res);
        
        res.setContentType("text/html");
        out.println("<main style=\"padding:80px 20px 60px 20px;\"> The results of " + "addition" + " is " + sum + "</main>");
        
        // req.getRequestDispatcher("/footer").include(req, res);
        
    }
}

