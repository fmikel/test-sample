<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<html>
<head>
    <title>All Inventory Elements</title>
</head>
<body>
<table width="1000px">
    <tr>
      <td><b>Id</b></td>
      <td><b>Code</b></td>
      <td><b>Name</b></td>
      <td><b>Cost</b></td>
      <td><b>Date</b></td>
    </tr>
    <c:forEach var="inventoryElement" items="${inventoryElements}">
        <tr>
            <td>${inventoryElement.id}</td>
            <td>${inventoryElement.code}</td>
            <td>${inventoryElement.name}</td>
            <td>${inventoryElement.cost}</td>
            <td><fmt:formatDate value="${inventoryElement.date}" pattern="MM/dd/yyyy"/></td>
            <td><a href="./editInventoryElement?id=${inventoryElement.id}">Edit</a> | <a href="./deleteInventoryElement?id=${inventoryElement.id}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="./addInventoryElement">Add Inventory Element</a>
        </td>
    </tr>
</table>
</body>
</html>
