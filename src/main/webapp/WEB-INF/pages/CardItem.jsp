<jsp:useBean id="item" scope="request" type="ru.az.sample.model.Item"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: smikhailova
  Date: 23.11.2015
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
  <h>Артикул товара:   </h><h>${item.article}</h>
  <br />
  <br />
  <h>Категория:   </h><h>${item.category.nameCategory}</h>
  <br />
  <br />
  <h>Название товара:   </h><h>${item.nameItem}</h>
  <br />
  <br />
  <h>Количество товара:   </h><h>${item.kolvo}</h>
  <br />
  <br />
  <h>Цена:   </h><h>${item.price}</h>

</body>
</html>
