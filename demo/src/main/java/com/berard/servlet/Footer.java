package com.berard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/footer")
public class Footer extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        res.setContentType("text/html");
        res.getWriter().println("<footer style=\"position:fixed; bottom:0; left:0; width:100%; background:#f0f0f0; text-align:center; padding:10px;\">&copy; 2026 RCA</footer>");
    }
}
