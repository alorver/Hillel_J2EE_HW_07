<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Shop list</title>
    <style>
        table, th, td {
            border: 1px solid dimgrey;
        }
    </style>
</head>
<body>
<h2>Shop list</h2>

<br/><br/>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Web site</th>
            <th>Phone number</th>
            <th>Persons</th>
            <th>Products</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <c:forEach  items="${shopDTOS}" var ="shopDTO">
            <tr>
                <td>${shopDTO.id}</td>
                <td>${shopDTO.name}</td>
                <td>${shopDTO.webSite}</td>
                <td>${shopDTO.phoneNumber}</td>

                <td>
                    <a href="/getShopPersons?shopId=${shopDTO.id}">Persons</a>
                </td>
                <td>
                    <a href="/getShopProducts?shopId=${shopDTO.id}">Products</a>
                </td>
                <td>
                    <a href="/getUpdateShop?shopId=${shopDTO.id}">Update</a>
                </td>
                <td>
                    <a href="/deleteShopById?shopId=${shopDTO.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="/getCreateShop">Create</a>
    <br/>
    <br/>
    <a href="/">Main menu</a>

</div>


</body>
</html>