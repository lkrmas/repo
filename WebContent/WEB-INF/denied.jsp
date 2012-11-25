<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Access denied</title>
</head>
<body>

    <h1>Access denied</h1>

    <sec:authorize access="isAuthenticated()">
        <p>Access denied for <sec:authentication property="principal.username" />.</p>
    </sec:authorize>

    <sec:authorize access="isAnonymous()">
        <p>Access denied for anonymous users.</p>
    </sec:authorize>

    <p>
        <a href="../security/access">Security page</a>
    </p>

    <p>
        <a href="../index.jsp">Index page</a>
    </p>

</body>
</html>