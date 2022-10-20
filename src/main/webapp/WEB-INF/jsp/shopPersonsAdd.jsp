<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Person list</title>
    <style>
        table, th, td {
            border: 1px solid dimgrey;
        }
    </style>
</head>
<body>
<h2>Person list</h2>

<br/><br/>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>First_name</th>
            <th>Last_name</th>
            <th>E-Mail</th>
            <th>Add</th>

        </tr>
        <c:forEach  items="${personDTOS}" var ="personDTO">
            <tr>
                <td>${personDTO.id}</td>
                <td>${personDTO.firstName}</td>
                <td>${personDTO.lastName}</td>
                <td>${personDTO.email}</td>

                <td>
                    <a href="/addShopPerson?shopId=${shopId}&personId=${personDTO.id}">Add</a>
                </td>

            </tr>
        </c:forEach>
    </table>
    <br/>
    <br/>
    <a href="/findAllShops">Shop list</a>

</div>


</body>
</html>