<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Cart update</title>
</head>
<body>


<br/><br/>

<div class="center">
    <h2>Cart update</h2>
    <%--@elvariable id="cartDTO" type="cartDTO"--%>
    <form:form action="postUpdateCart" method="post" modelAttribute="cartDTO">
        <table>
            <tr>
                <td>ID: </td>
                <td><form:input path="id" readonly="true"/></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><form:input path="description" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>