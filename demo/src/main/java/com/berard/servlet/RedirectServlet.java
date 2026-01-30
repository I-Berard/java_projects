package com.berard.servlet;

import java.io.IOException;
// import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletConfig;
// import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
// import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// @WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try{
            int num1 = Integer.parseInt(req.getParameter("num1"));
            int num2 = Integer.parseInt(req.getParameter("num2"));
            // int sum = num1 + num2;

            // ServletConfig conf = getServletConfig();
            // String servletDescription = conf.getInitParameter("ServletDescription");

            // ServletContext context = getServletContext();
            // String appName = context.getInitParameter("appName");


            // res.setContentType("text/html");
            // PrintWriter out = res.getWriter();
            // out.println("This is a " + appName);
            // out.println("Description: " + servletDescription);
            // out.println(sum);
            // out.println(req.getParameter("num1"));
            // req.setAttribute("fnum", num1);
            // req.setAttribute("snum", num2);
            // RequestDispatcher rd = req.getRequestDispatcher(req.getParameter("operation"));
            // rd.forward(req, res);

            HttpSession session = req.getSession();
            session.setAttribute("fnum", num1);
            session.setAttribute("snum", num2);

            String operation = req.getParameter("operation");
            if("add".equals(operation)){
                Cookie firstNumber = new Cookie("firstnum", num1+"");
                Cookie secondNumber = new Cookie("secondnum", num2+"");
                res.addCookie(firstNumber);
                res.addCookie(secondNumber);
                res.sendRedirect("add");
            }else if("subtract".equals(operation)){
                RequestDispatcher rd = req.getRequestDispatcher("subtract");
                rd.forward(req, res);
            }else if("multiply".equals(operation)){
                RequestDispatcher rd = req.getRequestDispatcher("multiply");
                rd.forward(req, res);
            }
            
        }catch(Exception e){
            res.getWriter().println("Invalid input");
            e.printStackTrace();
        }
    }
}
