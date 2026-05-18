<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Watchtower | Report Incident</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
            <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap"
                rel="stylesheet">
            <style>
                .form-group {
                    margin-bottom: 1.5rem;
                }

                .form-group label {
                    display: block;
                    margin-bottom: 0.5rem;
                    font-weight: 500;
                    color: var(--text-primary);
                }

                .form-group input,
                .form-group textarea,
                .form-group select {
                    width: 100%;
                    padding: 0.75rem;
                    border: 1px solid #e5e7eb;
                    border-radius: 6px;
                    font-family: inherit;
                    font-size: 1rem;
                    outline: none;
                }

                .form-group input:focus,
                .form-group textarea:focus,
                .form-group select:focus {
                    border-color: #3b82f6;
                    box-shadow: 0 0 0 3px rgba(59, 130, 246, 0.1);
                }
            </style>
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

                <div
                    style="max-width: 600px; margin: 2rem auto; background: white; padding: 2rem; border-radius: 12px; box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);">
                    <h2 style="margin-top: 0; margin-bottom: 1.5rem; color: #111827;">Report an Incident</h2>

                    <form action="${pageContext.request.contextPath}/incidents/new" method="POST">
                        <div class="form-group">
                            <label for="title">Incident Title</label>
                            <input type="text" id="title" name="title" required
                                placeholder="Brief summary of the issue">
                        </div>

                        <div class="form-group">
                            <label for="severity">Severity</label>
                            <select id="severity" name="severity" required>
                                <option value="Low">Low</option>
                                <option value="Medium" selected>Medium</option>
                                <option value="High">High</option>
                                <option value="Critical">Critical</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="description">Detailed Description</label>
                            <textarea id="description" name="description" rows="5" required
                                placeholder="Please provide as much detail as possible about the incident..."></textarea>
                        </div>

                        <div style="display: flex; gap: 1rem; justify-content: flex-end; margin-top: 2rem;">
                            <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-secondary"
                                style="text-decoration: none;">Cancel</a>
                            <button type="submit" class="btn btn-primary" style="cursor: pointer; border: none;">Submit
                                Report</button>
                        </div>
                    </form>
                </div>
            </div>
        </body>

        </html>