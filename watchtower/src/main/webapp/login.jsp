<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Log In | Watchtower</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
            <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600&display=swap" rel="stylesheet">
        </head>

        <body>
            <div class="bg-circles">
                <div class="circle circle-1" style="left: -100px; top: -50px; background: rgba(0, 210, 255, 0.1);">
                </div>
                <div class="circle circle-2" style="right: -50px; bottom: -50px; background: rgba(118, 75, 162, 0.1);">
                </div>
            </div>

            <div class="glass-card">
                <h1>Welcome Back</h1>
                <p class="subtitle">Log in to your Watchtower account.</p>

                <c:if test="${not empty errorMessage}">
                    <div class="alert alert-error">
                        <c:out value="${errorMessage}" />
                    </div>
                </c:if>

                <c:if test="${not empty successMessage}">
                    <div class="alert alert-success">
                        <c:out value="${successMessage}" />
                    </div>
                </c:if>

                <form action="${pageContext.request.contextPath}/users/login" method="POST">
                    <div class="form-group">
                        <label for="userNameOrEmail">Username or Email</label>
                        <input type="text" id="userNameOrEmail" name="userNameOrEmail" placeholder="johndoe@example.com"
                            required>
                    </div>

                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" placeholder="••••••••" required>
                    </div>

                    <button type="submit">Log In</button>
                </form>

                <div class="footer-link">
                    Don't have an account? <a href="${pageContext.request.contextPath}/signup.jsp">Sign Up</a>
                </div>
            </div>
        </body>

        </html>