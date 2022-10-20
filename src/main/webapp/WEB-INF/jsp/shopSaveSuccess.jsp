<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Shop action success</title>
</head>
<body>

<br/><br/>
<div class="center">
    <h2>Shop entity action success</h2>
    <%--@elvariable id="shopDTO" type="edu.avo.hillel_j2ee_hw_06.model.shopDTO"--%>
        <table>
            <tr>
                <td>ID: </td>
                <td>${shopDTO.id}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${shopDTO.name}</td>
            </tr>
            <tr>
                <td>Web site: </td>
                <td>${shopDTO.webSite}</td>
            </tr>
            <tr>
                <td>Phone number: </td>
                <td>${shopDTO.phoneNumber}</td>
            </tr>
        </table>

    <br/>
    <a href="/findAllShops">Shops</a>
</div>


</body>
</html>