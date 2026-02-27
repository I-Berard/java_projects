<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include fileName="" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Records - Glass UI</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;500;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Inter', sans-serif;
            /* Gradient background makes the glass effect visible */
            background: linear-gradient(135deg, #e0f2fe 0%, #ffffff 100%);
            background-attachment: fixed;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: flex-start;
            padding: 60px 20px;
            margin: 0;
        }

        .glass-container {
            width: 100%;
            max-width: 1200px; /* Increased width */
            
            /* Glassmorphism Core Properties */
            background: rgba(255, 255, 255, 0.7); 
            backdrop-filter: blur(12px);
            -webkit-backdrop-filter: blur(12px);
            border: 1px solid rgba(255, 255, 255, 0.3);
            border-radius: 20px;
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.1);
            
            padding: 40px;
        }

        h2 {
            color: #1e40af;
            margin-top: 0;
            font-weight: 600;
            letter-spacing: -0.5px;
        }

        table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0 10px; /* Adds space between rows */
        }

        th {
            color: #64748b;
            font-weight: 600;
            text-transform: uppercase;
            font-size: 0.75rem;
            letter-spacing: 0.1rem;
            padding: 15px 20px;
            text-align: left;
        }

        tbody tr {
            background: rgba(255, 255, 255, 0.5);
            transition: transform 0.2s ease, box-shadow 0.2s ease;
        }

        tbody tr:hover {
            transform: translateY(-2px);
            background: rgba(255, 255, 255, 0.8);
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
        }

        td {
            padding: 20px;
            color: #1e293b;
        }

        /* Rounding the corners of individual rows */
        td:first-child { border-radius: 12px 0 0 12px; }
        td:last-child { border-radius: 0 12px 12px 0; }

        .badge {
            padding: 6px 14px;
            border-radius: 30px;
            font-size: 0.8rem;
            font-weight: 600;
            display: inline-block;
        }

        /* Glassy Badge Colors */
        .olevel { background: rgba(30, 136, 229, 0.15); color: #1e88e5; }
        .alevel { background: rgba(67, 160, 71, 0.15); color: #43a047; }
        .senior { background: rgba(251, 140, 0, 0.15); color: #fb8c00; }

    </style>
</head>
<body>

<div class="glass-container">
    <h2>Student Registry</h2>
    <table>
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Academic Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td><strong>${student.firstName}</strong></td>
                    <td>${student.lastName}</td>
                    <td>
                        <c:choose>
                            <c:when test="${student.age lt 15}">
                                <span class="badge olevel">O'Level Student</span>
                            </c:when>
                            <c:when test="${student.age ge 15 and student.age lt 18}">
                                <span class="badge alevel">A'Level Candidate</span>
                            </c:when>
                            <c:otherwise>
                                <span class="badge senior">Senior Member</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>