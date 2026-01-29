package com.berard.servlet;

import java.io.IOException;
// import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
// import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// @WebServlet("/multiply")
public class MultiplyServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        HttpSession session = req.getSession();
        int num1 = (int)session.getAttribute("fnum");
        int num2 = (int)session.getAttribute("snum");

        int product = num1 * num2;
        HttpSession session2 = req.getSession();
        session2.setAttribute("result", product);
        session2.setAttribute("operation", "multiplication");
        req.getRequestDispatcher("display").forward(req, res);
    }
}
