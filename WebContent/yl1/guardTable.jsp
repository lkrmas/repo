<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Guard Posts</title>
</head>
<body>
    <c:choose>
        <c:when test="${dataList != null}">

            <h1>Guard Post Table</h1>
            <table border="1">
                <tr><th>Name</th><th>Address</th><th>Guard Count</th></tr>
                <c:forEach var="guardPost" items="${dataList}">
                    <tr>
                        <td><c:out value="${guardPost.name}"/></td>
                        <td><c:out value="${guardPost.address}"/></td>
                        <td><c:out value="${guardPost.guardCount}"/></td>
                    </tr>
                </c:forEach>
            </table>

        </c:when>
        <c:otherwise>
        	<c:redirect url="dataview" />
        </c:otherwise>
    </c:choose>

	<a href="addGuardPost.jsp">Add Guard Post</a>
</body>
</html>