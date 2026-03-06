<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Dashboard | Watchtower</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
            <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600&display=swap" rel="stylesheet">
        </head>

        <body>
            <div class="bg-circles">
                <div class="circle circle-1" style="background: rgba(46, 213, 115, 0.1);"></div>
                <div class="circle circle-2" style="background: rgba(0, 210, 255, 0.1);"></div>
            </div>

            <div class="glass-card" style="max-width: 600px;">
                <h1>Watchtower Dashboard</h1>
                <p class="subtitle">Welcome back, <strong>
                        <c:out value="${user.firstName}" />
                    </strong>!</p>

                <div style="margin-top: 2rem; padding: 20px; background: rgba(255,255,255,0.05); border-radius: 12px;">
                    <h3 style="margin-bottom: 1rem;">User Profile</h3>
                    <p style="margin-bottom: 0.5rem; color: var(--text-secondary);">Username: <span
                            style="color: #fff;">${user.username}</span></p>
                    <p style="margin-bottom: 0.5rem; color: var(--text-secondary);">Email: <span
                            style="color: #fff;">${user.email}</span></p>
                </div>

                <div style="margin-top: 2rem; text-align: center;">
                    <p style="color: var(--text-secondary);">You have <span
                            style="color: var(--accent-color); font-weight: 600;">${user.incidents.size()}</span> active
                        incidents.</p>
                </div>

                <button onclick="window.location.href='${pageContext.request.contextPath}/signup.jsp'"
                    style="background: rgba(255,255,255,0.1); color: #fff; border: 1px solid var(--glass-border); margin-top: 2rem;">Log
                    Out</button>
            </div>
        </body>

        </html>