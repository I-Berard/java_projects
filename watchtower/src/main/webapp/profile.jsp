<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Watchtower | Profile</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
            <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap"
                rel="stylesheet">
        </head>

        <body>
            <div class="container">
                <header class="header">
                    <div class="logo">
                        <a href="${pageContext.request.contextPath}/dashboard"
                            style="text-decoration: none; color: inherit;">
                            <h2 style="font-weight: 800; letter-spacing: -0.05em;">WATCHTOWER</h2>
                        </a>
                    </div>
                    <div class="user-tag">
                        <span style="font-weight: 500;">${user.firstName} ${user.lastName}</span>
                        <a href="${pageContext.request.contextPath}/profile">
                            <div class="avatar"></div>
                        </a>
                        <a href="${pageContext.request.contextPath}/users/logout"
                            style="font-size: 0.8rem; color: var(--text-secondary);">Logout</a>
                    </div>
                </header>

                <div class="profile-card"
                    style="max-width: 600px; margin: 4rem auto; padding: 2rem; background: white; border-radius: 12px; box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06);">
                    <div
                        style="display: flex; align-items: center; margin-bottom: 2rem; padding-bottom: 2rem; border-bottom: 1px solid #e5e7eb;">
                        <div
                            style="width: 80px; height: 80px; background: linear-gradient(135deg, #3b82f6 0%, #2563eb 100%); border-radius: 50%; display: flex; align-items: center; justify-content: center; color: white; font-size: 2rem; font-weight: 600; margin-right: 1.5rem;">
                            ${user.firstName.substring(0,1)}${user.lastName.substring(0,1)}
                        </div>
                        <div>
                            <h1 style="font-size: 1.8rem; margin: 0 0 0.25rem 0; color: #111827;">${user.firstName}
                                ${user.lastName}</h1>
                            <p style="margin: 0; color: #6b7280; font-size: 0.95rem;">${user.username}</p>
                        </div>
                    </div>

                    <div style="display: grid; gap: 1.5rem;">
                        <div>
                            <label
                                style="display: block; font-size: 0.875rem; font-weight: 500; color: #4b5563; margin-bottom: 0.5rem;">Email
                                Address</label>
                            <div
                                style="padding: 0.75rem 1rem; background: #f9fafb; border: 1px solid #e5e7eb; border-radius: 6px; color: #111827;">
                                ${user.email}
                            </div>
                        </div>
                    </div>

                    <div style="margin-top: 2rem; text-align: center;">
                        <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-primary"
                            style="text-decoration: none;">Back to Dashboard</a>
                    </div>
                </div>
            </div>
        </body>

        </html>