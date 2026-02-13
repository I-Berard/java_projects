package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Students;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/register1")
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // important for names with accents

        // String firstName = req.getParameter("firstName");
        // String lastName = req.getParameter("lastName");

        Students st = new Students("Melissa", "Shami", 10);
        Students st1 = new Students("Simbi", "Kelia", 16);
        Students st2 = new Students("Munezero", "Christella", 30);
        List<Students> list = new ArrayList<>();
        list.add(st);
        list.add(st1);
        list.add(st2);
        req.setAttribute("students", list);
        req.getRequestDispatcher("/display.jsp").forward(req, res);
    }
}
