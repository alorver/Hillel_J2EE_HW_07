<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Product list</title>
    <style>
        table, th, td {
            border: 1px solid dimgrey;
        }
    </style>
</head>
<body>
<h2>Product list</h2>

<br/><br/>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Add</th>

        </tr>
        <c:forEach  items="${productDTOS}" var ="productDTO">
            <tr>
                <td>${productDTO.id}</td>
                <td>${productDTO.name}</td>
                <td>${productDTO.price}</td>

                <td>
                    <a href="/addShopProduct?shopId=${shopId}&productId=${productDTO.id}">Add</a>
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