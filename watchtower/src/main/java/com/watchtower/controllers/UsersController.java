package com.watchtower.controllers;

import com.watchtower.dao.UserDAO;
import com.watchtower.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/users/*")
public class UsersController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        if("/register".equals(req.getPathInfo())){
            String userName = req.getParameter("userName");
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            if(UserDAO.findByEmail(email) != null || UserDAO.findByUsername(userName) != null){
                req.setAttribute("errorMessage", "Email or username already exists");
                try {
                    req.getRequestDispatcher("/signup.jsp").forward(req, res);
                } catch (ServletException e) {
                    throw new IOException(e);
                }
                return;
            }

            User user = new User();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUsername(userName);
            user.setPassword(password);

            UserDAO.save(user);
            req.setAttribute("successMessage", "User registered successfully! Please log in.");
            try {
                req.getRequestDispatcher("/login.jsp").forward(req, res);
            } catch (ServletException e) {
                throw new IOException(e);
            }
        }
        if("/login".equals(req.getPathInfo())){
            String userNameOrEmail = req.getParameter("userNameOrEmail");
            String password = req.getParameter("password");

            if(userNameOrEmail == null || password == null || userNameOrEmail.isEmpty() || password.isEmpty()){
                req.setAttribute("errorMessage", "Username or email and password are required");
                try {
                    req.getRequestDispatcher("/login.jsp").forward(req, res);
                } catch (ServletException e) {
                    throw new IOException(e);
                }
                return;
            }

            User user = null;
            if (userNameOrEmail.contains("@")){
                user = UserDAO.findByEmail(userNameOrEmail);
            }else{
                user = UserDAO.findByUsername(userNameOrEmail);
            }

            if(user == null){
                req.setAttribute("errorMessage", "User does not exist, try registering first");
                try {
                    req.getRequestDispatcher("/login.jsp").forward(req, res);
                } catch (ServletException e) {
                    throw new IOException(e);
                }
                return;
            }

            if(password.equals(user.getPassword())){
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                res.sendRedirect(req.getContextPath() + "/index.jsp");
            } else {
                req.setAttribute("errorMessage", "Invalid password");
                try {
                    req.getRequestDispatcher("/login.jsp").forward(req, res);
                } catch (ServletException e) {
                    throw new IOException(e);
                }
            }
        }
    }
}
