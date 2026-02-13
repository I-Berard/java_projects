<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
            background-color: #f0f2f5;
        }
        h2 {
            color: #333;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 6px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            max-width: 400px;
        }
        input[type=text], input[type=email] {
            width: 100%;
            padding: 8px 10px;
            margin: 6px 0 16px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 18px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type=submit]:hover {
            background-color: #45a049;
        }
        .message {
            margin-top: 15px;
            color: green;
        }
    </style>
</head>
<body>
<h2>Register New Student</h2>
<form action="register" method="post">
    <label for="studentfirstname">First Name:</label><br>
    <input type="text" id="studentfirstname" name="studentfirstname" required><br>

    <label for="studentlastname">Last Name:</label><br>
    <input type="text" id="studentlastname" name="studentlastname" required><br>

    <input type="submit" value="Register Student">
</form>

<%-- Optional: show success message if redirected with ?success=true --%>
<%
    String success = request.getParameter("success");
    if ("true".equals(success)) {
%>
    <div class="message">Student registered successfully!</div>
<%
    }
%>
</body>
</html>
