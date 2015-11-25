<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: smikhailova
  Date: 24.11.2015
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Корзина</title>
</head>


<body>
<c:if test="${pageContext.request.userPrincipal.name != null}">
  <h3>${pageContext.request.userPrincipal.name}</h3>
</c:if>
<c:forEach items="${rows}" var="row">
  <p><c:out value="${row}"/></p>
</c:forEach>
<p>Всего: <c:out value="${sum}"/></p>
<p><a href="/List">Назад</a> <a href="/buyitem">Заказать</a></p>
</body>
</html>
