<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Guard Post</title>
</head>
<body>
	<form id="myForm" method="post" action="dataview">
		Name: <input type="text" name="name" /><br>
		Address: <input type="text" name="address" /><br>
		Guard Count: <input type="text" name="guardCount" /><br>
		<input type="submit" value="Send">
	</form>
	<br>
	<a href="dataview">View Guard Posts</a><br>
</body>
</html>