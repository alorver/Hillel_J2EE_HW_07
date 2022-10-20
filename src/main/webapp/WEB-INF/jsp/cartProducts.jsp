<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Cart Product list</title>
    <style>
        table, th, td {
            border: 1px solid dimgrey;
        }
    </style>
</head>
<body>
<h2>Cart Product list</h2>

<br/><br/>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Delete</th>
        </tr>
        <c:forEach  items="${cartProducts}" var ="cartProduct">
            <tr>
                <td>${cartProduct.id}</td>
                <td>${cartProduct.name}</td>
                <td>${cartProduct.price}</td>

                <td>
                    <a href="/deleteCartProduct?cartId=${cartId}&productId=${cartProduct.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="/getCartProductsAdd?cartId=${cartId}">Add</a>
    <br/>
    <br/>
    <a href="/findAllCarts">Cart list</a>

</div>


</body>
</html>