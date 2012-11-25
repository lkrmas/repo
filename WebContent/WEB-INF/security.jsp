<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Security</title>
</head>
<body>

    <sec:authorize access="isAuthenticated()">
        <h1>Logout</h1>
        <p>
            <a href="../j_spring_security_logout">Logout <sec:authentication property="principal.username" /></a>
        </p>
    </sec:authorize>

    <sec:authorize access="isAnonymous()">
        <h1>Login</h1>
        <form name="form" action="../j_spring_security_check" method="POST">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="j_username" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="j_password" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input name="submit" type="submit" value="Login" /></td>
                </tr>
            </table>
        </form>
    </sec:authorize>

    <p>
        <a href="../index.jsp">Index page</a>
    </p>

</body>
</html>