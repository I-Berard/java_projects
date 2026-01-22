package com.example.servlets;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
     
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/plain");
        res.getWriter().println("Hello Servlet");
    }
}