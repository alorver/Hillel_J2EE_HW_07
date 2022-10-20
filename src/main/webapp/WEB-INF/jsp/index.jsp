
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Welcome</title>
</head>
<body>

<div>
    <h3>Welcome ${pageContext.request.userPrincipal.name}</h3>
    <sec:authorize access="!isAuthenticated()">
        <h4><a href="/login">Войти</a></h4>
        <h4><a href="/registration">Зарегистрироваться</a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/logout">Выйти</a></h4>
    </sec:authorize>
    <sec:authorize access="hasAnyRole('ADMIN')">
        <h4><a href="/admin/userList">Пользователи</a></h4>
    </sec:authorize>
</div>
<br/>



<h2>${message}</h2>
<%--<a href="${pageContext.request.contextPath}/personList">Person List</a>--%>
<a href="/findAllShops">Shops</a>
<br/>
<a href="/findAllPersons">Persons</a>
<br/>
<a href="/findAllCarts">Carts</a>
<br/>
<a href="/findAllProducts">Products</a>


</body>
</html>