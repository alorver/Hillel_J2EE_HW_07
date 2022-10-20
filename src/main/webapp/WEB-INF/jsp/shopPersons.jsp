<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Shop Person list</title>
    <style>
        table, th, td {
            border: 1px solid dimgrey;
        }
    </style>
</head>
<body>
<h2>Shop Person list</h2>

<br/><br/>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>First_name</th>
            <th>Last_name</th>
            <th>E-Mail</th>
            <th>Delete</th>
        </tr>
        <c:forEach  items="${shopPersons}" var ="shopPerson">
            <tr>
                <td>${shopPerson.id}</td>
                <td>${shopPerson.firstName}</td>
                <td>${shopPerson.lastName}</td>
                <td>${shopPerson.email}</td>

                <td>
                    <a href="/deleteShopPerson?shopId=${shopId}&personId=${shopPerson.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="/getShopPersonsAdd?shopId=${shopId}">Add</a>
    <br/>
    <br/>
    <a href="/findAllShops">Shop list</a>

</div>


</body>
</html>