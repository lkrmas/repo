<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>index</title>
</head>
<body>
    <a href="addGuardPost.jsp">JSP, mis võimaldab sisestada piiripunkti andmed</a><br>
	<a href="dataview">JSP, mis võimaldab kuvada piiripunkti andmeid tabelis</a><br>
	<a href="showparameters">Servlet, mis kuvab kõik request parameetrid</a><br>
	<br>
	<a href="showparameters?nimi=Pille&sugu=N">Parameetreid kuvav servlet näite parameetritega</a><br>
</body>
</html>