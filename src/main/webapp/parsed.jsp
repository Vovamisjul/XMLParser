<%--
  Created by IntelliJ IDEA.
  User: Vova
  Date: 14.12.2019
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/table.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <c:forEach var="saxheader" items="${parsedTable.headers}">
            <th>${saxheader}</th>
        </c:forEach>
    </tr>
    <c:forEach var="row" items="${parsedTable.cells}">
        <tr>
            <c:forEach var="cell" items="${row}">
                <td>${cell}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
