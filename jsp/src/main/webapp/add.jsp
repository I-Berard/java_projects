<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp" %>
<%!
    int divide(int a, int b){
        return a / b;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%
        String s1 = request.getParameter("num1");
        String s2 = request.getParameter("num2");

        if (s1 == null || s2 == null) {
            out.println("Missing parameters");
            return;
        }

        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);

        if (num2 == 0) {
            out.println("Cannot divide by zero");
            return;
        }

        int quotient = divide(num1, num2);
    %>
    <h1>The quotient is: <%= quotient %></h1>
</body>
</html>