<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>User list (Admin mode)</title>
    <style>
        table, th, td {
            border: 1px solid dimgrey;
        }
    </style>
</head>
<body>
<h2>User list (Admin mode)</h2>

<br/><br/>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>First name</th>
            <th>Last name</th>
            <th>E-Mail</th>
            <th>Username</th>
            <th>Password</th>
            <th>Delete</th>
        </tr>
        <c:forEach  items="${allUsers}" var ="personDTO">
            <tr>
                <td>${personDTO.id}</td>
                <td>${personDTO.firstName}</td>
                <td>${personDTO.lastName}</td>
                <td>${personDTO.email}</td>
                <td>${personDTO.username}</td>
                <td>${personDTO.password}</td>

                <td>
                    <a href="/adminDeletePersonById?personId=${personDTO.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>


    <br/>
    <br/>
    <a href="/">Main menu</a>

</div>


</body>
</html>