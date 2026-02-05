<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h2 style="color: red;">Something went wrong</h2>
    <p>Issue: <%= exception.getMessage() %></p>
    <a href="/jsp/">Go back home</a>
</body>
</html>