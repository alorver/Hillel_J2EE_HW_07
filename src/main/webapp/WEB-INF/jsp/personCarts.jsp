<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Person Cart list</title>
    <style>
        table, th, td {
            border: 1px solid dimgrey;
        }
    </style>
</head>
<body>
<h2>Person Cart list</h2>

<br/><br/>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Summa</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${personCarts}" var="personCart">
            <tr>
                <td>${personCart.id}</td>
                <td>${personCart.description}</td>
                <td>${personCart.summa}</td>

                <td>
                    <a href="/deletePersonCart?personId=${personId}&cartId=${personCart.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="/getPersonCartsAdd?personId=${personId}">Add</a>
    <br/>
    <br/>
    <a href="/findAllPersons">Person list</a>

</div>


</body>
</html>