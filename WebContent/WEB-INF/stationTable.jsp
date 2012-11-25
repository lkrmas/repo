<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stations</title>
</head>
<body>
    <c:choose>
        <c:when test="${dataList != null}">

            <h1>Station Table</h1>
            <a href="create">Add station</a>
            <table border="1">
                <tr><th>ID</th><th>Name</th><th>Address</th><th>Guards</th><th>Modify</th><th>Delete</th></tr>
                <c:forEach var="station" items="${dataList}">
                    <tr>
                        <td><c:out value="${station.id}"/></td>
                        <td><c:out value="${station.name}"/></td>
                        <td><c:out value="${station.address}"/></td>
                        <td><c:out value="${station.guardCount}"/></td>
                        <td><a href="modify?id=<c:out value="${station.id}"/>">Modify</a></td>
                        <td><a href="delete?id=<c:out value="${station.id}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>

        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>

    <a href="../index.jsp">Index page</a>
</body>
</html>