package com.berard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class Header extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        res.getWriter().println("<header style=\"position:fixed; top:0; left:0; width:100%; background:#4CAF50; color:white; text-align:center; padding:15px; z-index:1000;\">Welcome To RCA</header>");
    }
}
