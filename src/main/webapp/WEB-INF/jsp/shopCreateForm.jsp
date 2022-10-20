<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Shop create</title>
</head>
<body>


<br/><br/>

<div class="center">
    <h2>Shop create</h2>
    <%--@elvariable id="shopDTO" type="shopDTO"--%>
    <form:form action="postCreateShop" method="post" modelAttribute="shopDTO">
        <table>
            <tr>
                <td>Name: </td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Web site: </td>
                <td><form:input path="webSite" /></td>
            </tr>
            <tr>
                <td>Phone number: </td>
                <td><form:input path="phoneNumber" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>