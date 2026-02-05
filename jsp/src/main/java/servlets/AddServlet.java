package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Calculator;

public class AddServlet extends HttpServlet{
    protected void service(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        Calculator cal = new Calculator(num1, num2);
        int sum = cal.add();
        req.setAttribute("res", sum);
        RequestDispatcher rd = req.getRequestDispatcher("result");
        rd.forward(req, res);
    }
}
