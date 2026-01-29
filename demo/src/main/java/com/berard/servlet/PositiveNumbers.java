package com.berard.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/add")
public class PositiveNumbers implements Filter{
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)throws IOException, ServletException{
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        int num2 = Integer.parseInt(request.getParameter("num2"));
        if(num2 < 0){
            System.out.println("Negative number");
            response.sendRedirect("/");
        }

        chain.doFilter(request, response);
    }
}
