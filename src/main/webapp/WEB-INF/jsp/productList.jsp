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
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <c:forEach  items="${productDTOS}" var ="productDTO">
            <tr>
                <td>${productDTO.id}</td>
                <td>${productDTO.name}</td>
                <td>${productDTO.price}</td>

                <td>
                    <a href="/getUpdateProduct?productId=${productDTO.id}">Update</a>
                </td>
                <td>
                    <a href="/deleteProductById?productId=${productDTO.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="/getCreateProduct">Create</a>
    <br/>
    <br/>
    <a href="/">Main menu</a>

</div>


</body>
</html>