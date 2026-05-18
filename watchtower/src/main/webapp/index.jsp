<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Watchtower | Dashboard</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
            <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap"
                rel="stylesheet">
        </head>

        <body>
            <div class="container">
                <c:choose>
                    <c:when test="${empty user}">
                        <!-- Logged Out View -->
                        <section class="auth-hero">
                            <h1>Secure your future with Watchtower</h1>
                            <p>The all-in-one platform for monitoring and managing your digital security assets.</p>
                            <div class="auth-buttons">
                                <a href="${pageContext.request.contextPath}/login" class="btn btn-primary">Log In</a>
                                <a href="${pageContext.request.contextPath}/signup" class="btn btn-secondary">Sign
                                    Up</a>
                            </div>
                        </section>
                    </c:when>

                    <c:otherwise>
                        <!-- Dashboard View -->
                        <header class="header">
                            <div class="logo">
                                <h2 style="font-weight: 800; letter-spacing: -0.05em;">WATCHTOWER</h2>
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

                        <div class="blog-feed" style="max-width: 800px; margin: 2rem auto;">
                            <div
                                style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 1.5rem;">
                                <h2 style="margin: 0;">Incident Reports</h2>
                                <a href="${pageContext.request.contextPath}/incidents/new" class="btn btn-primary"
                                    style="padding: 0.5rem 1rem; font-size: 0.9rem;">+ Report Incident</a>
                            </div>
                            <c:forEach var="incident" items="${incidents}">
                                <div class="card incident-card" style="margin-bottom: 1.5rem; padding: 1.5rem;">
                                    <div
                                        style="display: flex; justify-content: space-between; align-items: start; margin-bottom: 1rem;">
                                        <h3 style="margin: 0; font-size: 1.25rem;">
                                            <c:out value="${incident.title}" />
                                        </h3>
                                        <span
                                            style="padding: 0.25rem 0.75rem; border-radius: 999px; font-size: 0.8rem; font-weight: 600; 
                                                     background: ${incident.severity == 'Critical' || incident.severity == 'High' ? 'rgba(220, 38, 38, 0.1)' : 'rgba(245, 158, 11, 0.1)'};
                                                     color: ${incident.severity == 'Critical' || incident.severity == 'High' ? '#dc2626' : '#d97706'};">
                                            <c:out value="${incident.severity}" />
                                        </span>
                                    </div>
                                    <p style="color: var(--text-secondary); margin-bottom: 1rem; line-height: 1.6;">
                                        <c:out value="${incident.description}" />
                                    </p>
                                    <div
                                        style="display: flex; justify-content: space-between; font-size: 0.85rem; color: var(--text-secondary); border-top: 1px solid rgba(0,0,0,0.05); padding-top: 1rem;">
                                        <span>Status: <strong style="color: var(--text-primary);">
                                                <c:out value="${incident.status}" />
                                            </strong></span>
                                        <span>Reported:
                                            <c:out value="${incident.created_at}" />
                                        </span>
                                    </div>
                                </div>
                            </c:forEach>
                            <c:if test="${empty incidents}">
                                <div class="card" style="text-align: center; padding: 3rem;">
                                    <p style="color: var(--text-secondary);">No incidents reported yet.</p>
                                </div>
                            </c:if>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </body>

        </html>