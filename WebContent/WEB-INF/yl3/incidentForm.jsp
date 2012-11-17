<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Add incident</title>
</head>
<body>

<h2>Add incident</h2>
<form:form method="POST" commandName="incident" action="addIncident">
    <table>
    <tr>
        <td><form:label path="open">open</form:label></td>
        <td><form:input path="open" /></td>
    </tr>
    <tr>
        <td><form:label path="close">close</form:label></td>
        <td><form:input path="close" /></td>
    </tr>
    <tr>
        <td><form:label path="location">location</form:label></td>
        <td><form:input path="location" /></td>
    </tr>
    <tr>
        <td><form:label path="description">description</form:label></td>
        <td><form:input path="description" /></td>
    </tr>
    <tr>
        <td><form:label path="involvedGuardCount">involvedGuardCount</form:label></td>
        <td><form:input path="involvedGuardCount" /></td>
    </tr>
    <tr>
        <td><form:label path="status">status</form:label></td>
        <td><form:input path="status" /></td>
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