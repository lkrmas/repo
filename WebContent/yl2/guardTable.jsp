<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Guards</title>
</head>
<body>
    <c:choose>
        <c:when test="${dataList != null}">

            <h1>Guard Table</h1>
            <table border="1">
                <tr><th>ID</th><th>Name</th><th>Age</th></tr>
                <c:forEach var="guard" items="${dataList}">
                    <tr>
                        <td><c:out value="${guard.id}"/></td>
                        <td><c:out value="${guard.name}"/></td>
                        <td><c:out value="${guard.age}"/></td>
                    </tr>
                </c:forEach>
            </table>

        </c:when>
        <c:otherwise>
        	<c:redirect url="generateGuards?count=" />
        </c:otherwise>
    </c:choose>

</body>
</html>