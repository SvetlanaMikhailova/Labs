<%--
  Created by IntelliJ IDEA.
  User: smikhailova
  Date: 20.11.2015
  Time: 18:18
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
    <th>ID</th>
    <th>Name</th>
    <th>Artist</th>
    <th>Release Date</th>
    <th>List Price</th>
    <th><font color='green'>Your Price</font></th>
  </tr>
  </thead>
  <tbody>

  <c:forEach items="${results}" var="item">

    <tr>
      <td>${item.id}</td>
      <td>${item.title}</td>
      <td>${item.artist}</td>
      <td><fmt:formatDate value="${item.releaseDate}" type="date" dateStyle="medium"/></td>
      <td>$ ${item.listPrice}</td>
      <td><b><font color='green'>$ ${item.price}</font></b></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
