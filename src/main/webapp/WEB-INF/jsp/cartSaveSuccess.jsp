<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Cart action success</title>
</head>
<body>

<br/><br/>
<div class="center">
    <h2>Cart entity action success</h2>
    <%--@elvariable id="cartDTO" type="edu.avo.hillel_j2ee_hw_06.model.cartDTO"--%>
        <table>
            <tr>
                <td>ID: </td>
                <td>${cartDTO.id}</td>
            </tr>
            <tr>
                <td>Description: </td>
                <td>${cartDTO.description}</td>
            </tr>
            <tr>
                <td>Summa: </td>
                <td>${cartDTO.summa}</td>
            </tr>
        </table>

    <br/>
    <a href="/findAllCarts">Carts</a>
</div>


</body>
</html>