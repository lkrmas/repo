<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Modify station</title>
</head>
<body>

    <h2>Modify station</h2>
    <form:form method="POST" commandName="station" action="modifyStation">
    <form:hidden path="id" />
        <form:errors path="*" element="div" />
        <table>
            <tr>
                <td><form:label path="name">name</form:label></td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td><form:label path="address">address</form:label></td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td><form:label path="guardCount">guardCount</form:label></td>
                <td><form:input path="guardCount" /></td>
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