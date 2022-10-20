<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Cart list</title>
    <style>
        table, th, td {
            border: 1px solid dimgrey;
        }
    </style>
</head>
<body>
<h2>Cart list</h2>

<br/><br/>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Summa</th>
            <th>Add</th>

        </tr>
        <c:forEach  items="${cartDTOS}" var ="cartDTO">
            <tr>
                <td>${cartDTO.id}</td>
                <td>${cartDTO.description}</td>
                <td>${cartDTO.summa}</td>

                <td>
                    <a href="/addPersonCart?personId=${personId}&cartId=${cartDTO.id}">Add</a>
                </td>

            </tr>
        </c:forEach>
    </table>
    <br/>
    <br/>
    <a href="/findAllPersons">Person list</a>

</div>

</body>
</html>