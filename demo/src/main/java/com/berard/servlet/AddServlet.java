package com.berard.servlet;

import java.io.IOException;
// import java.io.PrintWriter;

import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/add")
public class AddServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        int num1 = (int)req.getAttribute("fnum");
        int num2 = (int)req.getAttribute("snum");

        int sum = num1 + num2;
        req.setAttribute("result", sum);
        req.setAttribute("operation", "Addition");
        req.getRequestDispatcher("display").forward(req, res);
    }
}

