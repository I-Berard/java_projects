package com.berard.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SumServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try{
            int num1 = Integer.parseInt(req.getParameter("num1"));
            int num2 = Integer.parseInt(req.getParameter("num2"));
            int sum = num1 + num2;

            ServletConfig conf = getServletConfig();
            String servletDescription = conf.getInitParameter("ServletDescription");

            ServletContext context = getServletContext();
            String appName = context.getInitParameter("appName");


            res.setContentType("text/plain");
            PrintWriter out = res.getWriter();
            out.println("This is a " + appName);
            out.println("Description: " + servletDescription);
            out.println(sum);
        }catch(Exception e){
            res.getWriter().println("Invalid input");
        }
    }
}
