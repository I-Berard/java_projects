<%--
  Created by IntelliJ IDEA.
  User: berard
  Date: 2/27/26
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/student/save" method="post">
    First Name: <input type="text" name="firstName"><br>
    Last Name: <input type="text" name="lastName"><br>

    Computer Brand: <input type="text" name="computerBrand"><br>
    Computer Version: <input type="text" name="computerVersion"><br>

    <button type="submit">Save</button>
</form>
</body>
</html>
