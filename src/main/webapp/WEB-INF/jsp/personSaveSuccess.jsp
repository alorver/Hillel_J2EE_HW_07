<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Person action success</title>
</head>
<body>

<br/><br/>
<div class="center">
    <h2>Person entity action success</h2>
    <%--@elvariable id="personDTO" type="edu.avo.hillel_j2ee_hw_06.model.personDTO"--%>
        <table>
            <tr>
                <td>ID: </td>
                <td>${personDTO.id}</td>
            </tr>
            <tr>
                <td>First name: </td>
                <td>${personDTO.firstName}</td>
            </tr>
            <tr>
                <td>Last name: </td>
                <td>${personDTO.lastName}</td>
            </tr>
            <tr>
                <td>E-Mail: </td>
                <td>${personDTO.email}</td>
            </tr>
        </table>

    <br/>
    <a href="/findAllPersons">Persons</a>
</div>


</body>
</html>