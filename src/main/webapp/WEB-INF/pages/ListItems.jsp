<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: smikhailova
  Date: 23.11.2015
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>

<table border="1">
  <thead>
  <tr>
    <th>Article</th>
    <th>Category</th>
    <th>Name</th>
    <th>Kolvo</th>
    <th>Price</th>

  </tr>
  </thead>
  <tbody>

  <c:forEach items="${items}" var="item">
    <c:url var="BasketAdd" value="item/add/${item.id}" />
    <c:url var="ListCategory" value="List/Cat/${item.category.id}" />
    <tr>
      <td>${item.article}</td>
      <td><a href="<c:out value="${ListCategory}"/>"><c:out value="${item.category.nameCategory}"/></a></td>
      <td><a href="<c:url value="/CardItem"/>?id=<c:out value="${item.id}"/>" />${item.nameItem}</td>
      <td>${item.kolvo}</td>
      <td>${item.price}</td>
      <td><a href="${BasketAdd}">Купить</a></td>

    </tr>
  </c:forEach>
  </tbody>
</table>

<div>
  <h1>Корзина</h1>
  <p>Сумма покупок: <c:out value="${sum}"/></p>
  <p><a href="/basketOut">Смотреть корзину</a></p>
</div>
</body>
</html>
