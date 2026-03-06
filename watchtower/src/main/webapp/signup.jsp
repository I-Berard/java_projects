<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up | Watchtower</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="bg-circles">
        <div class="circle circle-1"></div>
        <div class="circle circle-2"></div>
    </div>

    <div class="glass-card">
        <h1>Join Watchtower</h1>
        <p class="subtitle">Securely monitor your infrastructure.</p>

        <c:if test="${not empty errorMessage}">
            <div class="alert alert-error">
                <c:out value="${errorMessage}"/>
            </div>
        </c:if>

        <c:if test="${not empty successMessage}">
            <div class="alert alert-success">
                <c:out value="${successMessage}"/>
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/users/register" method="POST">
            <div class="form-group">
                <label for="userName">Username</label>
                <input type="text" id="userName" name="userName" placeholder="johndoe" required>
            </div>

            <div class="form-group" style="display: flex; gap: 15px;">
                <div style="flex: 1;">
                    <label for="firstName">First Name</label>
                    <input type="text" id="firstName" name="firstName" placeholder="John" required>
                </div>
                <div style="flex: 1;">
                    <label for="lastName">Last Name</label>
                    <input type="text" id="lastName" name="lastName" placeholder="Doe" required>
                </div>
            </div>

            <div class="form-group">
                <label for="email">Email Address</label>
                <input type="email" id="email" name="email" placeholder="john@example.com" required>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="••••••••" required>
            </div>

            <button type="submit">Create Account</button>
        </form>

        <div class="footer-link">
            Already have an account? <a href="${pageContext.request.contextPath}/login.jsp">Log In</a>
        </div>
    </div>
</body>
</html>
