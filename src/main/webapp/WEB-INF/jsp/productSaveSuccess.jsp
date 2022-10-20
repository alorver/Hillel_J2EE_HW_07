<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Product action success</title>
</head>
<body>

<br/><br/>
<div class="center">
    <h2>Product entity action success</h2>
    <%--@elvariable id="productDTO" type="edu.avo.hillel_j2ee_hw_06.model.productDTO"--%>
        <table>
            <tr>
                <td>ID: </td>
                <td>${productDTO.id}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${productDTO.name}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${productDTO.price}</td>
            </tr>
        </table>

    <br/>
    <a href="/findAllProducts">Products</a>
</div>


</body>
</html>