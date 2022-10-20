<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Cart create</title>
</head>
<body>


<br/><br/>

<div class="center">
    <h2>Cart create</h2>
    <%--@elvariable id="cartDTO" type="cartDTO"--%>
    <form:form action="postCreateCart" method="post" modelAttribute="cartDTO">
        <table>
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