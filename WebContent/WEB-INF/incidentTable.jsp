<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Incidents</title>
</head>
<body>
    <c:choose>
        <c:when test="${dataList != null}">

            <h1>Incident Table</h1>
            <a href="create">Add incident</a>
            <table border="1">
                <tr><th>ID</th><th>Open</th><th>Close</th><th>Location</th><th>Description</th><th>IGC</th><th>Status</th></tr>
                <c:forEach var="incident" items="${dataList}">
                    <tr>
                        <td><c:out value="${incident.id}"/></td>
                        <td><c:out value="${incident.open}"/></td>
                        <td><c:out value="${incident.close}"/></td>
                        <td><c:out value="${incident.location}"/></td>
                        <td><c:out value="${incident.description}"/></td>
                        <td><c:out value="${incident.involvedGuardCount}"/></td>
                        <td><c:out value="${incident.status}"/></td>
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