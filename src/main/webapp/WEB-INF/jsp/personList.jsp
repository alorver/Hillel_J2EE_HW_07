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
            <th>First name</th>
            <th>Last name</th>
            <th>E-Mail</th>
            <th>Username</th>
            <th>Carts</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <c:forEach  items="${personDTOS}" var ="personDTO">
            <tr>
                <td>${personDTO.id}</td>
                <td>${personDTO.firstName}</td>
                <td>${personDTO.lastName}</td>
                <td>${personDTO.email}</td>
                <td>${personDTO.username}</td>

                <td>
                    <a href="/getPersonCarts?personId=${personDTO.id}">Carts</a>
                </td>
                <td>
                    <a href="/getUpdatePerson?personId=${personDTO.id}">Update</a>
                </td>
                <td>
                    <a href="/deletePersonById?personId=${personDTO.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="/getCreatePerson">Create</a>
    <br/>
    <br/>
    <a href="/">Main menu</a>

</div>


</body>
</html>