<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>index</title>
</head>
<body>
    <p>Ülesanne 2</p>
    <a href="generateGuards?count=5">Servlet, millega on võimalik piirivalvureid genereerida</a><br>
    <a href="searchGuard?name=Kalle&age=50">Servlet, millega on võimalik valvurit otsida nime järgi</a><br>
    <a href="updateGuard?id=10&name=Pille">Servlet, millega on võimalik valvurit uuendada</a><br>
    <br>
    <a href="all">Täiendav servlet, mis näitab kõiki tabelis olevaid piirivalvureid</a><br>
    <br>
    <p>Ülesanne 1</p>
    <a href="yl1/addGuardPost.jsp">JSP, mis võimaldab sisestada piiripunkti andmed</a><br>
	<a href="yl1/dataview">JSP, mis võimaldab kuvada piiripunkti andmeid tabelis</a><br>
	<a href="yl1/showparameters">Servlet, mis kuvab kõik request parameetrid</a><br>
	<br>
	<a href="yl1/showparameters?nimi=Pille&sugu=N">Parameetreid kuvav servlet näite parameetritega</a><br>
</body>
</html>