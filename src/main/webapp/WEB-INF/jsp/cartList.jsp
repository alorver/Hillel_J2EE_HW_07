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
            <th>Products</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <c:forEach  items="${cartDTOS}" var ="cartDTO">
            <tr>
                <td>${cartDTO.id}</td>
                <td>${cartDTO.description}</td>
                <td>${cartDTO.summa}</td>

                <td>
                    <a href="/getCartProducts?cartId=${cartDTO.id}">Products</a>
                </td>
                <td>
                    <a href="/getUpdateCart?cartId=${cartDTO.id}">Update</a>
                </td>
                <td>
                    <a href="/deleteCartById?cartId=${cartDTO.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="/getCreateCart">Create</a>
    <br/>
    <br/>
    <a href="/">Main menu</a>

</div>


</body>
</html>