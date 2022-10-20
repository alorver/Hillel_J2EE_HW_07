<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Product update</title>
</head>
<body>


<br/><br/>

<div class="center">
    <h2>Product update</h2>
    <%--@elvariable id="productDTO" type="productDTO"--%>
    <form:form action="postUpdateProduct" method="post" modelAttribute="productDTO">
        <table>
            <tr>
                <td>ID: </td>
                <td><form:input path="id" readonly="true"/></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><form:input path="price" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>