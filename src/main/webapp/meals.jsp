<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
    <table border="1">
        <tr>
            <th>Date&time</th>
            <th>Description</th>
            <th>Calories</th>
        </tr>
        <c:forEach var="num" items="${meals}">
            <tr style="${num.isExcess() ? 'color: crimson' : 'color: darkgreen'}">
                <td>${num.getStringDate()} ${num.getStringTime()}</td>
                <td>${num.getDescription()}</td>
                <td align="right">${num.getCalories()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>