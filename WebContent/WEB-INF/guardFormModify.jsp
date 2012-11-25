<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Modify guard</title>
</head>
<body>

    <h2>Modify guard</h2>
    <form:form method="POST" commandName="guard" action="modifyGuard">
    <form:hidden path="id" />
        <form:errors path="*" element="div" />
        <table>
            <tr>
                <td><form:label path="name">name</form:label></td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td><form:label path="age">age</form:label></td>
                <td><form:input path="age" /></td>
            </tr>
            
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>
    </form:form>

</body>
</html>