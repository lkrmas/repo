<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>index</title>
</head>
<body>
    <p>Antud projekti .war on ehitatav nii Gradle kui Ant abil.</p>
    <p>Ülesanne 3</p>
    <a href="gis">Incident simulator - lihtne proovi liides intsidentide genereerimise teenusele</a><br>
    <a href="incident/listAll">Incident simulator controller - tagastab listi genereeritud intsidentidega</a><br>
    <br>
    <a href="all">Täiendav servlet, mis näitab kõiki andmebaasis olevaid intsidente</a><br>
    <a href="incident/all">Täiendav leht, mis näitab kõiki andmebaasis olevaid intsidente</a><br>
    <br>
    <p>Ülesanne 2</p>
    <a href="yl2/generateGuards?count=5">Servlet, millega on võimalik piirivalvureid genereerida</a><br>
    <a href="yl2/searchGuard?name=Kalle&age=50">Servlet, millega on võimalik valvurit otsida nime järgi</a><br>
    <a href="yl2/updateGuard?id=10&name=Pille">Servlet, millega on võimalik valvurit uuendada</a><br>
    <br>
    <a href="yl2/all">Täiendav servlet, mis näitab kõiki tabelis olevaid piirivalvureid</a><br>
    <br>
    <p>Ülesanne 1</p>
    <a href="yl1/addGuardPost.jsp">JSP, mis võimaldab sisestada piiripunkti andmed</a><br>
	<a href="yl1/dataview">JSP, mis võimaldab kuvada piiripunkti andmeid tabelis</a><br>
	<a href="yl1/showparameters">Servlet, mis kuvab kõik request parameetrid</a><br>
	<br>
	<a href="yl1/showparameters?nimi=Pille&sugu=N">Parameetreid kuvav servlet näite parameetritega</a><br>
</body>
</html>