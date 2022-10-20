<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Shop Product list</title>
    <style>
        table, th, td {
            border: 1px solid dimgrey;
        }
    </style>
</head>
<body>
<h2>Shop Product list</h2>

<br/><br/>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Delete</th>
        </tr>
        <c:forEach  items="${shopProducts}" var ="shopProduct">
            <tr>
                <td>${shopProduct.id}</td>
                <td>${shopProduct.name}</td>
                <td>${shopProduct.price}</td>

                <td>
                    <a href="/deleteShopProduct?shopId=${shopId}&productId=${shopProduct.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="/getShopProductsAdd?shopId=${shopId}">Add</a>
    <br/>
    <br/>
    <a href="/findAllShops">Shop list</a>

</div>


</body>
</html>