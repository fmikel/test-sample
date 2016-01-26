<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add/Edit Inventory Element</title>
</head>
<body>
<form:form method="POST" action="./saveInventoryElement" modelAttribute="inventoryElement" var="inventoryElement">
  <form:hidden path="id" />
  <table>
    <tr>
      <td>Code:</td>
      <td><form:input path="code" /></td>
    </tr>
    <tr>
      <td>Name:</td>
      <td><form:input path="name" /></td>
    </tr>
    <tr>
      <td>Cost:</td>
      <td><form:input path="cost" /></td>
    </tr>
    <tr>
      <td>Date:</td>
      <td><form:input path="date" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" />
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>
