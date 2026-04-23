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
                                <a href="${pageContext.request.contextPath}/login.jsp" class="btn btn-primary">Log
                                    In</a>
                                <a href="${pageContext.request.contextPath}/signup.jsp" class="btn btn-secondary">Sign
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
                                <div class="avatar"></div>
                                <a href="${pageContext.request.contextPath}/users/logout"
                                    style="font-size: 0.8rem; color: var(--text-secondary);">Logout</a>
                            </div>
                        </header>

                        <div class="dashboard-grid">
                            <!-- Sales Statistics Card (Dark) -->
                            <div class="card card-dark span-8">
                                <div style="display: flex; justify-content: space-between; align-items: flex-start;">
                                    <div>
                                        <h3 class="stat-label">System Monitoring</h3>
                                        <div class="stat-value">Active Incidents: ${user.incidents.size()}</div>
                                    </div>
                                    <div style="font-size: 0.8rem; opacity: 0.6;">Real-time Update</div>
                                </div>
                                <div class="chart-mockup">
                                    <div class="bar" style="height: 40%;"></div>
                                    <div class="bar" style="height: 60%;"></div>
                                    <div class="bar bar-active" style="height: 85%;"></div>
                                    <div class="bar" style="height: 45%;"></div>
                                    <div class="bar bar-active" style="height: 95%;"></div>
                                    <div class="bar" style="height: 70%;"></div>
                                </div>
                            </div>

                            <!-- Market Forecast (Light) -->
                            <div class="card span-4">
                                <h3 class="stat-label">Security Score</h3>
                                <div class="stat-value">92%</div>
                                <p style="color: var(--text-secondary); font-size: 0.9rem;">Your security posture is
                                    excellent. 3 recommendations pending.</p>
                                <div
                                    style="margin-top: 2rem; background: var(--bg-primary); height: 8px; border-radius: 4px; overflow: hidden;">
                                    <div style="width: 92%; height: 100%; background: var(--accent-green);"></div>
                                </div>
                            </div>

                            <!-- Current Balance (Mint) -->
                            <div class="card card-mint span-6">
                                <h3 class="stat-label">Available Credits</h3>
                                <div class="stat-value">1,420 WT</div>
                                <div style="margin-top: auto; display: flex; align-items: center; gap: 0.5rem;">
                                    <span style="font-size: 0.8rem; font-weight: 600; color: #065f46;">+12.5% from last
                                        month</span>
                                </div>
                            </div>

                            <!-- Recent Transactions (Purple) -->
                            <div class="card card-purple span-6">
                                <h3 class="stat-label">Recent Activity</h3>
                                <div style="margin-top: 1rem;">
                                    <div
                                        style="display: flex; justify-content: space-between; padding: 0.5rem 0; border-bottom: 1px solid rgba(0,0,0,0.05);">
                                        <span style="font-size: 0.9rem;">New Login (NYC)</span>
                                        <span style="font-size: 0.8rem; color: var(--text-secondary);">2m ago</span>
                                    </div>
                                    <div
                                        style="display: flex; justify-content: space-between; padding: 0.5rem 0; border-bottom: 1px solid rgba(0,0,0,0.05);">
                                        <span style="font-size: 0.9rem;">Password Updated</span>
                                        <span style="font-size: 0.8rem; color: var(--text-secondary);">1h ago</span>
                                    </div>
                                    <div style="display: flex; justify-content: space-between; padding: 0.5rem 0;">
                                        <span style="font-size: 0.9rem;">API Key Generated</span>
                                        <span style="font-size: 0.8rem; color: var(--text-secondary);">3h ago</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </body>

        </html>