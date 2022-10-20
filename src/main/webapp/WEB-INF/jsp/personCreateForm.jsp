<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Person create</title>
</head>
<body>


<br/><br/>

<div class="center">
    <h2>Person create</h2>
    <%--@elvariable id="personDTO" type="personDTO"--%>
    <form:form action="postCreatePerson" method="post" modelAttribute="personDTO">
        <table>
            <tr>
                <td>First name: </td>
                <td><form:input path="firstName" /></td>
            </tr>
            <tr>
                <td>Last name: </td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td>E-Mail: </td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>